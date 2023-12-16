package fr.erinagroups.erinium.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import java.io.File;

import fr.erinagroups.erinium.EriniumMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EriniumModVariables {
	public static File config = new File("");

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EriniumMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		EriniumMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
			clone.timer_earnmoney = original.timer_earnmoney;
			clone.commanddelay = original.commanddelay;
			clone.cap_xp = original.cap_xp;
			clone.old_cap_xp = original.old_cap_xp;
			if (!event.isWasDeath()) {
				clone.PlayerHealth = original.PlayerHealth;
				clone.PresentationToggle = original.PresentationToggle;
				clone.wonXp = original.wonXp;
				clone.won_xp_message = original.won_xp_message;
				clone.won_xp_message_2 = original.won_xp_message_2;
				clone.GetCurrentServerPlayerCount = original.GetCurrentServerPlayerCount;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
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

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
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
		public CompoundTag save(CompoundTag nbt) {
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

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
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
		public double nether_x = 0;
		public double nether_y = 120.0;
		public double nether_z = 0;
		public boolean maintenanceNether = false;
		public boolean essentialPluginEnabled = false;
		public boolean enablemoddedfeatures = false;
		public double energysellercost = 0.0;
		public boolean toggle_pvp = true;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
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
			nether_x = nbt.getDouble("nether_x");
			nether_y = nbt.getDouble("nether_y");
			nether_z = nbt.getDouble("nether_z");
			maintenanceNether = nbt.getBoolean("maintenanceNether");
			essentialPluginEnabled = nbt.getBoolean("essentialPluginEnabled");
			enablemoddedfeatures = nbt.getBoolean("enablemoddedfeatures");
			energysellercost = nbt.getDouble("energysellercost");
			toggle_pvp = nbt.getBoolean("toggle_pvp");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
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
			nbt.putDouble("nether_x", nether_x);
			nbt.putDouble("nether_y", nether_y);
			nbt.putDouble("nether_z", nether_z);
			nbt.putBoolean("maintenanceNether", maintenanceNether);
			nbt.putBoolean("essentialPluginEnabled", essentialPluginEnabled);
			nbt.putBoolean("enablemoddedfeatures", enablemoddedfeatures);
			nbt.putDouble("energysellercost", energysellercost);
			nbt.putBoolean("toggle_pvp", toggle_pvp);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("erinium", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
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
		public double playerLvl = 1.0;
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
		public BlockState blockReplacerSelectedBlock = Blocks.AIR.defaultBlockState();
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
		public double timer_earnmoney = 1200.0;
		public double commanddelay = 0;
		public double cap_xp = 150000.0;
		public double old_cap_xp = 150000.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				EriniumMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Credit", Credit);
			nbt.putDouble("percent", percent);
			nbt.putString("playerList", playerList);
			nbt.putString("serverLanguage", serverLanguage);
			nbt.putDouble("PlayerHealth", PlayerHealth);
			nbt.putBoolean("PresentationToggle", PresentationToggle);
			nbt.putString("presentationGui", presentationGui);
			nbt.putBoolean("togglePlanetOverlay", togglePlanetOverlay);
			nbt.putString("planete", planete);
			nbt.putDouble("h_x", h_x);
			nbt.putDouble("h_y", h_y);
			nbt.putDouble("h_z", h_z);
			nbt.putString("Home_dim", Home_dim);
			nbt.putDouble("HomeCmdCooldown", HomeCmdCooldown);
			nbt.putBoolean("inPvpMode", inPvpMode);
			nbt.putDouble("pvpModeTimer", pvpModeTimer);
			nbt.putDouble("playerLvl", playerLvl);
			nbt.putDouble("playerXp", playerXp);
			nbt.putDouble("wonXp", wonXp);
			nbt.putBoolean("toggle_wonxp_overlay", toggle_wonxp_overlay);
			nbt.putString("won_xp_message", won_xp_message);
			nbt.putString("won_xp_message_2", won_xp_message_2);
			nbt.putDouble("calc_x", calc_x);
			nbt.putDouble("calc_y", calc_y);
			nbt.putDouble("calc_z", calc_z);
			nbt.putDouble("testBarre", testBarre);
			nbt.putDouble("adminBombPuissance", adminBombPuissance);
			nbt.put("blockReplacerSelectedBlock", NbtUtils.writeBlockState(blockReplacerSelectedBlock));
			nbt.putDouble("rank_overlay_x", rank_overlay_x);
			nbt.putDouble("rank_overlay_y", rank_overlay_y);
			nbt.putDouble("won_xp_overlay_cooldown", won_xp_overlay_cooldown);
			nbt.putString("PlayerName", PlayerName);
			nbt.putString("GetCurrentServer", GetCurrentServer);
			nbt.putDouble("GetCurrentServerPlayerCount", GetCurrentServerPlayerCount);
			nbt.putString("mcpath", mcpath);
			nbt.putString("playerUUID", playerUUID);
			nbt.putDouble("list_player_cooldown", list_player_cooldown);
			nbt.putDouble("servermap_cooldown", servermap_cooldown);
			nbt.putBoolean("vip", vip);
			nbt.putDouble("timer_earnmoney", timer_earnmoney);
			nbt.putDouble("commanddelay", commanddelay);
			nbt.putDouble("cap_xp", cap_xp);
			nbt.putDouble("old_cap_xp", old_cap_xp);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Credit = nbt.getDouble("Credit");
			percent = nbt.getDouble("percent");
			playerList = nbt.getString("playerList");
			serverLanguage = nbt.getString("serverLanguage");
			PlayerHealth = nbt.getDouble("PlayerHealth");
			PresentationToggle = nbt.getBoolean("PresentationToggle");
			presentationGui = nbt.getString("presentationGui");
			togglePlanetOverlay = nbt.getBoolean("togglePlanetOverlay");
			planete = nbt.getString("planete");
			h_x = nbt.getDouble("h_x");
			h_y = nbt.getDouble("h_y");
			h_z = nbt.getDouble("h_z");
			Home_dim = nbt.getString("Home_dim");
			HomeCmdCooldown = nbt.getDouble("HomeCmdCooldown");
			inPvpMode = nbt.getBoolean("inPvpMode");
			pvpModeTimer = nbt.getDouble("pvpModeTimer");
			playerLvl = nbt.getDouble("playerLvl");
			playerXp = nbt.getDouble("playerXp");
			wonXp = nbt.getDouble("wonXp");
			toggle_wonxp_overlay = nbt.getBoolean("toggle_wonxp_overlay");
			won_xp_message = nbt.getString("won_xp_message");
			won_xp_message_2 = nbt.getString("won_xp_message_2");
			calc_x = nbt.getDouble("calc_x");
			calc_y = nbt.getDouble("calc_y");
			calc_z = nbt.getDouble("calc_z");
			testBarre = nbt.getDouble("testBarre");
			adminBombPuissance = nbt.getDouble("adminBombPuissance");
			blockReplacerSelectedBlock = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("blockReplacerSelectedBlock"));
			rank_overlay_x = nbt.getDouble("rank_overlay_x");
			rank_overlay_y = nbt.getDouble("rank_overlay_y");
			won_xp_overlay_cooldown = nbt.getDouble("won_xp_overlay_cooldown");
			PlayerName = nbt.getString("PlayerName");
			GetCurrentServer = nbt.getString("GetCurrentServer");
			GetCurrentServerPlayerCount = nbt.getDouble("GetCurrentServerPlayerCount");
			mcpath = nbt.getString("mcpath");
			playerUUID = nbt.getString("playerUUID");
			list_player_cooldown = nbt.getDouble("list_player_cooldown");
			servermap_cooldown = nbt.getDouble("servermap_cooldown");
			vip = nbt.getBoolean("vip");
			timer_earnmoney = nbt.getDouble("timer_earnmoney");
			commanddelay = nbt.getDouble("commanddelay");
			cap_xp = nbt.getDouble("cap_xp");
			old_cap_xp = nbt.getDouble("old_cap_xp");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
					variables.timer_earnmoney = message.data.timer_earnmoney;
					variables.commanddelay = message.data.commanddelay;
					variables.cap_xp = message.data.cap_xp;
					variables.old_cap_xp = message.data.old_cap_xp;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
