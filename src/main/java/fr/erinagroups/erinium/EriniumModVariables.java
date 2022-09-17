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
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

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

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			tpdim_toggle = nbt.getBoolean("tpdim_toggle");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putBoolean("tpdim_toggle", tpdim_toggle);
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

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
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
			nbt.putString("stringFarmerXp", instance.stringFarmerXp);
			nbt.putString("stringMinerXp", instance.stringMinerXp);
			nbt.putString("stringHunterXp", instance.stringHunterXp);
			nbt.putString("stringAlchimiste", instance.stringAlchimiste);
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
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.Credit = nbt.getDouble("Credit");
			instance.percent = nbt.getDouble("percent");
			instance.playerList = nbt.getString("playerList");
			instance.serverLanguage = nbt.getString("serverLanguage");
			instance.stringFarmerXp = nbt.getString("stringFarmerXp");
			instance.stringMinerXp = nbt.getString("stringMinerXp");
			instance.stringHunterXp = nbt.getString("stringHunterXp");
			instance.stringAlchimiste = nbt.getString("stringAlchimiste");
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
		}
	}

	public static class PlayerVariables {
		public double Credit = 500.0;
		public double percent = 0;
		public String playerList = "\"\"";
		public String serverLanguage = "FR";
		public String stringFarmerXp = "\"\"";
		public String stringMinerXp = "\"\"";
		public String stringHunterXp = "\"\"";
		public String stringAlchimiste = "\"\"";
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
		clone.stringFarmerXp = original.stringFarmerXp;
		clone.stringMinerXp = original.stringMinerXp;
		clone.stringHunterXp = original.stringHunterXp;
		clone.stringAlchimiste = original.stringAlchimiste;
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
		if (!event.isWasDeath()) {
			clone.PlayerHealth = original.PlayerHealth;
			clone.PresentationToggle = original.PresentationToggle;
			clone.wonXp = original.wonXp;
			clone.won_xp_message = original.won_xp_message;
			clone.won_xp_message_2 = original.won_xp_message_2;
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
					variables.stringFarmerXp = message.data.stringFarmerXp;
					variables.stringMinerXp = message.data.stringMinerXp;
					variables.stringHunterXp = message.data.stringHunterXp;
					variables.stringAlchimiste = message.data.stringAlchimiste;
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}
