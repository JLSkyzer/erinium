package fr.erinagroups.erinium;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.function.Supplier;

import java.io.File;

import com.github.hexomod.worldeditcuife3.s;
import com.github.hexomod.worldeditcuife3.T;

public class EriniumModVariables {
	public EriniumModVariables(EriniumModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	public static File config = new File("");

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "erinium_worldvars";
		public boolean tpdim_toggle = false;
		public double duplicatePickaxeMaxFortune = 3.0;
		public boolean use_planet_spawn = false;
		public double moon_x = 0;
		public double moon_y = 120.0;
		public double moon_z = 0;
		public double candy_x = 0.0;
		public double candy_y = 120.0;
		public double candy_z = 0.0;
		public boolean rtpdim_toggle = false;

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			tpdim_toggle = nbt.getBoolean("tpdim_toggle");
			duplicatePickaxeMaxFortune = nbt.getDouble("duplicatePickaxeMaxFortune");
			use_planet_spawn = nbt.getBoolean("use_planet_spawn");
			moon_x = nbt.getDouble("moon_x");
			moon_y = nbt.getDouble("moon_y");
			moon_z = nbt.getDouble("moon_z");
			candy_x = nbt.getDouble("candy_x");
			candy_y = nbt.getDouble("candy_y");
			candy_z = nbt.getDouble("candy_z");
			rtpdim_toggle = nbt.getBoolean("rtpdim_toggle");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putBoolean("tpdim_toggle", tpdim_toggle);
			nbt.putDouble("duplicatePickaxeMaxFortune", duplicatePickaxeMaxFortune);
			nbt.putBoolean("use_planet_spawn", use_planet_spawn);
			nbt.putDouble("moon_x", moon_x);
			nbt.putDouble("moon_y", moon_y);
			nbt.putDouble("moon_z", moon_z);
			nbt.putDouble("candy_x", candy_x);
			nbt.putDouble("candy_y", candy_y);
			nbt.putDouble("candy_z", candy_z);
			nbt.putBoolean("rtpdim_toggle", rtpdim_toggle);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "erinium_mapvars";
		public boolean enableCustomChat = false;
		public double PlayerCountFactionAlpha = 0;
		public double PlayerCountFactionBeta = 0;
		public double PlayerCountFactionCharlie = 0;
		public double PlayerCountMinage01 = 0;
		public double PlayerCountMinage02 = 0;
		public double PlayerCountMinage03 = 0;
		public double MaxPlayerPerServer = 100.0;
		public double alpha_x = 0;
		public double alpha_y = 120.0;
		public double alpha_z = 0;
		public double beta_x = 0;
		public double beta_y = 120.0;
		public double beta_z = 0;
		public double charlie_x = 0;
		public double charlie_y = 120.0;
		public double charlie_z = 0;
		public double minage01_x = 0;
		public double minage01_y = 120.0;
		public double minage01_z = 0;
		public double minage02_x = 0;
		public double minage02_y = 120.0;
		public double minage02_z = 0;
		public double minage03_x = 0;
		public double minage03_y = 120.0;
		public double minage03_z = 0;
		public boolean maintenanceMinage01 = false;
		public boolean maintenanceMinage02 = false;
		public boolean maintenanceMinage03 = false;
		public boolean maintenanceAlpha = false;
		public boolean maintenanceBeta = false;
		public boolean maintenanceCharlie = false;
		public String maintenanceTextMinage01 = "\u00A7aMinage 01";
		public String maintenanceTextMinage02 = "\u00A7aMinage 02";
		public String maintenanceTextMinage03 = "\u00A7aMinage 03";
		public String maintenanceTextAlpha = "\u00A7aAlpha";
		public String maintenanceTextBeta = "\u00A7aBeta";
		public String maintenanceTextCharlie = "\u00A7aCharlie";

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			enableCustomChat = nbt.getBoolean("enableCustomChat");
			PlayerCountFactionAlpha = nbt.getDouble("PlayerCountFactionAlpha");
			PlayerCountFactionBeta = nbt.getDouble("PlayerCountFactionBeta");
			PlayerCountFactionCharlie = nbt.getDouble("PlayerCountFactionCharlie");
			PlayerCountMinage01 = nbt.getDouble("PlayerCountMinage01");
			PlayerCountMinage02 = nbt.getDouble("PlayerCountMinage02");
			PlayerCountMinage03 = nbt.getDouble("PlayerCountMinage03");
			MaxPlayerPerServer = nbt.getDouble("MaxPlayerPerServer");
			alpha_x = nbt.getDouble("alpha_x");
			alpha_y = nbt.getDouble("alpha_y");
			alpha_z = nbt.getDouble("alpha_z");
			beta_x = nbt.getDouble("beta_x");
			beta_y = nbt.getDouble("beta_y");
			beta_z = nbt.getDouble("beta_z");
			charlie_x = nbt.getDouble("charlie_x");
			charlie_y = nbt.getDouble("charlie_y");
			charlie_z = nbt.getDouble("charlie_z");
			minage01_x = nbt.getDouble("minage01_x");
			minage01_y = nbt.getDouble("minage01_y");
			minage01_z = nbt.getDouble("minage01_z");
			minage02_x = nbt.getDouble("minage02_x");
			minage02_y = nbt.getDouble("minage02_y");
			minage02_z = nbt.getDouble("minage02_z");
			minage03_x = nbt.getDouble("minage03_x");
			minage03_y = nbt.getDouble("minage03_y");
			minage03_z = nbt.getDouble("minage03_z");
			maintenanceMinage01 = nbt.getBoolean("maintenanceMinage01");
			maintenanceMinage02 = nbt.getBoolean("maintenanceMinage02");
			maintenanceMinage03 = nbt.getBoolean("maintenanceMinage03");
			maintenanceAlpha = nbt.getBoolean("maintenanceAlpha");
			maintenanceBeta = nbt.getBoolean("maintenanceBeta");
			maintenanceCharlie = nbt.getBoolean("maintenanceCharlie");
			maintenanceTextMinage01 = nbt.getString("maintenanceTextMinage01");
			maintenanceTextMinage02 = nbt.getString("maintenanceTextMinage02");
			maintenanceTextMinage03 = nbt.getString("maintenanceTextMinage03");
			maintenanceTextAlpha = nbt.getString("maintenanceTextAlpha");
			maintenanceTextBeta = nbt.getString("maintenanceTextBeta");
			maintenanceTextCharlie = nbt.getString("maintenanceTextCharlie");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putBoolean("enableCustomChat", enableCustomChat);
			nbt.putDouble("PlayerCountFactionAlpha", PlayerCountFactionAlpha);
			nbt.putDouble("PlayerCountFactionBeta", PlayerCountFactionBeta);
			nbt.putDouble("PlayerCountFactionCharlie", PlayerCountFactionCharlie);
			nbt.putDouble("PlayerCountMinage01", PlayerCountMinage01);
			nbt.putDouble("PlayerCountMinage02", PlayerCountMinage02);
			nbt.putDouble("PlayerCountMinage03", PlayerCountMinage03);
			nbt.putDouble("MaxPlayerPerServer", MaxPlayerPerServer);
			nbt.putDouble("alpha_x", alpha_x);
			nbt.putDouble("alpha_y", alpha_y);
			nbt.putDouble("alpha_z", alpha_z);
			nbt.putDouble("beta_x", beta_x);
			nbt.putDouble("beta_y", beta_y);
			nbt.putDouble("beta_z", beta_z);
			nbt.putDouble("charlie_x", charlie_x);
			nbt.putDouble("charlie_y", charlie_y);
			nbt.putDouble("charlie_z", charlie_z);
			nbt.putDouble("minage01_x", minage01_x);
			nbt.putDouble("minage01_y", minage01_y);
			nbt.putDouble("minage01_z", minage01_z);
			nbt.putDouble("minage02_x", minage02_x);
			nbt.putDouble("minage02_y", minage02_y);
			nbt.putDouble("minage02_z", minage02_z);
			nbt.putDouble("minage03_x", minage03_x);
			nbt.putDouble("minage03_y", minage03_y);
			nbt.putDouble("minage03_z", minage03_z);
			nbt.putBoolean("maintenanceMinage01", maintenanceMinage01);
			nbt.putBoolean("maintenanceMinage02", maintenanceMinage02);
			nbt.putBoolean("maintenanceMinage03", maintenanceMinage03);
			nbt.putBoolean("maintenanceAlpha", maintenanceAlpha);
			nbt.putBoolean("maintenanceBeta", maintenanceBeta);
			nbt.putBoolean("maintenanceCharlie", maintenanceCharlie);
			nbt.putString("maintenanceTextMinage01", maintenanceTextMinage01);
			nbt.putString("maintenanceTextMinage02", maintenanceTextMinage02);
			nbt.putString("maintenanceTextMinage03", maintenanceTextMinage03);
			nbt.putString("maintenanceTextAlpha", maintenanceTextAlpha);
			nbt.putString("maintenanceTextBeta", maintenanceTextBeta);
			nbt.putString("maintenanceTextCharlie", maintenanceTextCharlie);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("erinium", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("Credit", instance.Credit);
			nbt.putDouble("percent", instance.percent);
			nbt.putString("playerList", instance.playerList);
			nbt.putString("serverLanguage", instance.serverLanguage);
			nbt.putDouble("PlayerHealth", instance.PlayerHealth);
			nbt.putBoolean("PresentationToggle", instance.PresentationToggle);
			nbt.putString("presentationGui", instance.presentationGui);
			nbt.putBoolean("togglePlanetOverlay", instance.togglePlanetOverlay);
			nbt.putString("planete", instance.planete);
			nbt.putDouble("h_x", instance.h_x);
			nbt.putDouble("h_y", instance.h_y);
			nbt.putDouble("h_z", instance.h_z);
			nbt.putString("Home_dim", instance.Home_dim);
			nbt.putDouble("HomeCmdCooldown", instance.HomeCmdCooldown);
			nbt.putBoolean("inPvpMode", instance.inPvpMode);
			nbt.putDouble("pvpModeTimer", instance.pvpModeTimer);
			nbt.putDouble("playerLvl", instance.playerLvl);
			nbt.putDouble("playerXp", instance.playerXp);
			nbt.putDouble("wonXp", instance.wonXp);
			nbt.putBoolean("toggle_wonxp_overlay", instance.toggle_wonxp_overlay);
			nbt.putString("won_xp_message", instance.won_xp_message);
			nbt.putString("won_xp_message_2", instance.won_xp_message_2);
			nbt.putDouble("calc_x", instance.calc_x);
			nbt.putDouble("calc_y", instance.calc_y);
			nbt.putDouble("calc_z", instance.calc_z);
			nbt.putDouble("testBarre", instance.testBarre);
			nbt.putDouble("adminBombPuissance", instance.adminBombPuissance);
			nbt.put("blockReplacerSelectedBlock", NBTUtil.writeBlockState(instance.blockReplacerSelectedBlock));
			nbt.putDouble("rank_overlay_x", instance.rank_overlay_x);
			nbt.putDouble("rank_overlay_y", instance.rank_overlay_y);
			nbt.putDouble("won_xp_overlay_cooldown", instance.won_xp_overlay_cooldown);
			nbt.putString("PlayerName", instance.PlayerName);
			nbt.putString("GetCurrentServer", instance.GetCurrentServer);
			nbt.putDouble("GetCurrentServerPlayerCount", instance.GetCurrentServerPlayerCount);
			nbt.putString("mcpath", instance.mcpath);
			nbt.putString("playerUUID", instance.playerUUID);
			nbt.putDouble("list_player_cooldown", instance.list_player_cooldown);
			nbt.putDouble("servermap_cooldown", instance.servermap_cooldown);
			nbt.putBoolean("vip", instance.vip);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.Credit = nbt.getDouble("Credit");
			instance.percent = nbt.getDouble("percent");
			instance.playerList = nbt.getString("playerList");
			instance.serverLanguage = nbt.getString("serverLanguage");
			instance.PlayerHealth = nbt.getDouble("PlayerHealth");
			instance.PresentationToggle = nbt.getBoolean("PresentationToggle");
			instance.presentationGui = nbt.getString("presentationGui");
			instance.togglePlanetOverlay = nbt.getBoolean("togglePlanetOverlay");
			instance.planete = nbt.getString("planete");
			instance.h_x = nbt.getDouble("h_x");
			instance.h_y = nbt.getDouble("h_y");
			instance.h_z = nbt.getDouble("h_z");
			instance.Home_dim = nbt.getString("Home_dim");
			instance.HomeCmdCooldown = nbt.getDouble("HomeCmdCooldown");
			instance.inPvpMode = nbt.getBoolean("inPvpMode");
			instance.pvpModeTimer = nbt.getDouble("pvpModeTimer");
			instance.playerLvl = nbt.getDouble("playerLvl");
			instance.playerXp = nbt.getDouble("playerXp");
			instance.wonXp = nbt.getDouble("wonXp");
			instance.toggle_wonxp_overlay = nbt.getBoolean("toggle_wonxp_overlay");
			instance.won_xp_message = nbt.getString("won_xp_message");
			instance.won_xp_message_2 = nbt.getString("won_xp_message_2");
			instance.calc_x = nbt.getDouble("calc_x");
			instance.calc_y = nbt.getDouble("calc_y");
			instance.calc_z = nbt.getDouble("calc_z");
			instance.testBarre = nbt.getDouble("testBarre");
			instance.adminBombPuissance = nbt.getDouble("adminBombPuissance");
			instance.blockReplacerSelectedBlock = NBTUtil.readBlockState(nbt.getCompound("blockReplacerSelectedBlock"));
			instance.rank_overlay_x = nbt.getDouble("rank_overlay_x");
			instance.rank_overlay_y = nbt.getDouble("rank_overlay_y");
			instance.won_xp_overlay_cooldown = nbt.getDouble("won_xp_overlay_cooldown");
			instance.PlayerName = nbt.getString("PlayerName");
			instance.GetCurrentServer = nbt.getString("GetCurrentServer");
			instance.GetCurrentServerPlayerCount = nbt.getDouble("GetCurrentServerPlayerCount");
			instance.mcpath = nbt.getString("mcpath");
			instance.playerUUID = nbt.getString("playerUUID");
			instance.list_player_cooldown = nbt.getDouble("list_player_cooldown");
			instance.servermap_cooldown = nbt.getDouble("servermap_cooldown");
			instance.vip = nbt.getBoolean("vip");
		}
	}

	public static class PlayerVariables {
		public double Credit = 500.0;
		public double percent = 0;
		public String playerList = "\"\"";
		public String serverLanguage = "FR";
		public double PlayerHealth = 0;
		public boolean PresentationToggle = false;
		public String presentationGui = "\"\"";
		public boolean togglePlanetOverlay = false;
		public String planete = "\"\"";
		public double h_x = 0;
		public double h_y = 0;
		public double h_z = 0;
		public String Home_dim = "\"\"";
		public double HomeCmdCooldown = 0;
		public boolean inPvpMode = false;
		public double pvpModeTimer = 0;
		public double playerLvl = 0;
		public double playerXp = 0;
		public double wonXp = 0;
		public boolean toggle_wonxp_overlay = true;
		public String won_xp_message = "\"\"";
		public String won_xp_message_2 = "\"\"";
		public double calc_x = 0;
		public double calc_y = 0;
		public double calc_z = 0;
		public double testBarre = 60.0;
		public double adminBombPuissance = 0;
		public BlockState blockReplacerSelectedBlock = Blocks.AIR.getDefaultState();
		public double rank_overlay_x = 72.0;
		public double rank_overlay_y = -98.0;
		public double won_xp_overlay_cooldown = 0;
		public String PlayerName = "\"\"";
		public String GetCurrentServer = "\"\"";
		public double GetCurrentServerPlayerCount = 0;
		public String mcpath = "\"\"";
		public String playerUUID = "\"\"";
		public double list_player_cooldown = 0.0;
		public double servermap_cooldown = 0.0;
		public boolean vip = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.Credit = original.Credit;
		clone.percent = original.percent;
		clone.playerList = original.playerList;
		clone.serverLanguage = original.serverLanguage;
		clone.presentationGui = original.presentationGui;
		clone.togglePlanetOverlay = original.togglePlanetOverlay;
		clone.planete = original.planete;
		clone.h_x = original.h_x;
		clone.h_y = original.h_y;
		clone.h_z = original.h_z;
		clone.Home_dim = original.Home_dim;
		clone.HomeCmdCooldown = original.HomeCmdCooldown;
		clone.inPvpMode = original.inPvpMode;
		clone.pvpModeTimer = original.pvpModeTimer;
		clone.playerLvl = original.playerLvl;
		clone.playerXp = original.playerXp;
		clone.toggle_wonxp_overlay = original.toggle_wonxp_overlay;
		clone.calc_x = original.calc_x;
		clone.calc_y = original.calc_y;
		clone.calc_z = original.calc_z;
		clone.testBarre = original.testBarre;
		clone.adminBombPuissance = original.adminBombPuissance;
		clone.blockReplacerSelectedBlock = original.blockReplacerSelectedBlock;
		clone.rank_overlay_x = original.rank_overlay_x;
		clone.rank_overlay_y = original.rank_overlay_y;
		clone.won_xp_overlay_cooldown = original.won_xp_overlay_cooldown;
		clone.PlayerName = original.PlayerName;
		clone.GetCurrentServer = original.GetCurrentServer;
		clone.mcpath = original.mcpath;
		clone.playerUUID = original.playerUUID;
		clone.list_player_cooldown = original.list_player_cooldown;
		clone.servermap_cooldown = original.servermap_cooldown;
		clone.vip = original.vip;
		if (!event.isWasDeath()) {
			clone.PlayerHealth = original.PlayerHealth;
			clone.PresentationToggle = original.PresentationToggle;
			clone.wonXp = original.wonXp;
			clone.won_xp_message = original.won_xp_message;
			clone.won_xp_message_2 = original.won_xp_message_2;
			clone.GetCurrentServerPlayerCount = original.GetCurrentServerPlayerCount;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.Credit = message.data.Credit;
					variables.percent = message.data.percent;
					variables.playerList = message.data.playerList;
					variables.serverLanguage = message.data.serverLanguage;
					variables.PlayerHealth = message.data.PlayerHealth;
					variables.PresentationToggle = message.data.PresentationToggle;
					variables.presentationGui = message.data.presentationGui;
					variables.togglePlanetOverlay = message.data.togglePlanetOverlay;
					variables.planete = message.data.planete;
					variables.h_x = message.data.h_x;
					variables.h_y = message.data.h_y;
					variables.h_z = message.data.h_z;
					variables.Home_dim = message.data.Home_dim;
					variables.HomeCmdCooldown = message.data.HomeCmdCooldown;
					variables.inPvpMode = message.data.inPvpMode;
					variables.pvpModeTimer = message.data.pvpModeTimer;
					variables.playerLvl = message.data.playerLvl;
					variables.playerXp = message.data.playerXp;
					variables.wonXp = message.data.wonXp;
					variables.toggle_wonxp_overlay = message.data.toggle_wonxp_overlay;
					variables.won_xp_message = message.data.won_xp_message;
					variables.won_xp_message_2 = message.data.won_xp_message_2;
					variables.calc_x = message.data.calc_x;
					variables.calc_y = message.data.calc_y;
					variables.calc_z = message.data.calc_z;
					variables.testBarre = message.data.testBarre;
					variables.adminBombPuissance = message.data.adminBombPuissance;
					variables.blockReplacerSelectedBlock = message.data.blockReplacerSelectedBlock;
					variables.rank_overlay_x = message.data.rank_overlay_x;
					variables.rank_overlay_y = message.data.rank_overlay_y;
					variables.won_xp_overlay_cooldown = message.data.won_xp_overlay_cooldown;
					variables.PlayerName = message.data.PlayerName;
					variables.GetCurrentServer = message.data.GetCurrentServer;
					variables.GetCurrentServerPlayerCount = message.data.GetCurrentServerPlayerCount;
					variables.mcpath = message.data.mcpath;
					variables.playerUUID = message.data.playerUUID;
					variables.list_player_cooldown = message.data.list_player_cooldown;
					variables.servermap_cooldown = message.data.servermap_cooldown;
					variables.vip = message.data.vip;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
