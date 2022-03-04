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
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
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
			nbt.putDouble("lvlFarmer", instance.lvlFarmer);
			nbt.putDouble("xpFarmer", instance.xpFarmer);
			nbt.putDouble("lvlHunter", instance.lvlHunter);
			nbt.putDouble("xpHunter", instance.xpHunter);
			nbt.putDouble("lvlMiner", instance.lvlMiner);
			nbt.putDouble("xpMiner", instance.xpMiner);
			nbt.putDouble("lvlAlchimiste", instance.lvlAlchimiste);
			nbt.putDouble("xpAlchimiste", instance.xpAlchimiste);
			nbt.putString("serverLanguage", instance.serverLanguage);
			nbt.putString("stringFarmerXp", instance.stringFarmerXp);
			nbt.putString("stringMinerXp", instance.stringMinerXp);
			nbt.putString("stringHunterXp", instance.stringHunterXp);
			nbt.putString("stringAlchimiste", instance.stringAlchimiste);
			nbt.putDouble("PlayerHealth", instance.PlayerHealth);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.Credit = nbt.getDouble("Credit");
			instance.percent = nbt.getDouble("percent");
			instance.playerList = nbt.getString("playerList");
			instance.lvlFarmer = nbt.getDouble("lvlFarmer");
			instance.xpFarmer = nbt.getDouble("xpFarmer");
			instance.lvlHunter = nbt.getDouble("lvlHunter");
			instance.xpHunter = nbt.getDouble("xpHunter");
			instance.lvlMiner = nbt.getDouble("lvlMiner");
			instance.xpMiner = nbt.getDouble("xpMiner");
			instance.lvlAlchimiste = nbt.getDouble("lvlAlchimiste");
			instance.xpAlchimiste = nbt.getDouble("xpAlchimiste");
			instance.serverLanguage = nbt.getString("serverLanguage");
			instance.stringFarmerXp = nbt.getString("stringFarmerXp");
			instance.stringMinerXp = nbt.getString("stringMinerXp");
			instance.stringHunterXp = nbt.getString("stringHunterXp");
			instance.stringAlchimiste = nbt.getString("stringAlchimiste");
			instance.PlayerHealth = nbt.getDouble("PlayerHealth");
		}
	}

	public static class PlayerVariables {
		public double Credit = 500.0;
		public double percent = 0;
		public String playerList = "\"\"";
		public double lvlFarmer = 0;
		public double xpFarmer = 0;
		public double lvlHunter = 0;
		public double xpHunter = 0;
		public double lvlMiner = 0;
		public double xpMiner = 0;
		public double lvlAlchimiste = 0;
		public double xpAlchimiste = 0;
		public String serverLanguage = "FR";
		public String stringFarmerXp = "\"\"";
		public String stringMinerXp = "\"\"";
		public String stringHunterXp = "\"\"";
		public String stringAlchimiste = "\"\"";
		public double PlayerHealth = 0;

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
		clone.lvlFarmer = original.lvlFarmer;
		clone.xpFarmer = original.xpFarmer;
		clone.lvlHunter = original.lvlHunter;
		clone.xpHunter = original.xpHunter;
		clone.lvlMiner = original.lvlMiner;
		clone.xpMiner = original.xpMiner;
		clone.lvlAlchimiste = original.lvlAlchimiste;
		clone.xpAlchimiste = original.xpAlchimiste;
		clone.serverLanguage = original.serverLanguage;
		clone.stringFarmerXp = original.stringFarmerXp;
		clone.stringMinerXp = original.stringMinerXp;
		clone.stringHunterXp = original.stringHunterXp;
		clone.stringAlchimiste = original.stringAlchimiste;
		if (!event.isWasDeath()) {
			clone.PlayerHealth = original.PlayerHealth;
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
					variables.lvlFarmer = message.data.lvlFarmer;
					variables.xpFarmer = message.data.xpFarmer;
					variables.lvlHunter = message.data.lvlHunter;
					variables.xpHunter = message.data.xpHunter;
					variables.lvlMiner = message.data.lvlMiner;
					variables.xpMiner = message.data.xpMiner;
					variables.lvlAlchimiste = message.data.lvlAlchimiste;
					variables.xpAlchimiste = message.data.xpAlchimiste;
					variables.serverLanguage = message.data.serverLanguage;
					variables.stringFarmerXp = message.data.stringFarmerXp;
					variables.stringMinerXp = message.data.stringMinerXp;
					variables.stringHunterXp = message.data.stringHunterXp;
					variables.stringAlchimiste = message.data.stringAlchimiste;
					variables.PlayerHealth = message.data.PlayerHealth;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
