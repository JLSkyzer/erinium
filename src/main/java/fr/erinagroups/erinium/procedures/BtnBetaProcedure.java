package fr.erinagroups.erinium.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BtnBetaProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BtnBeta!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!EriniumModVariables.MapVariables.get(world).maintenanceBeta) {
			EriniumModVariables.MapVariables.get(world).maintenanceBeta = (true);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextBeta = "\u00A7cBeta";
			EriniumModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerWorld) {
				IWorld _worldorig = world;
				world = ((ServerWorld) world).getServer()
						.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:faction_beta")));
				if (world != null) {
					{
						List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
						for (Entity entityiterator : _players) {
							{
								Entity _ent = entityiterator;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = World.OVERWORLD;
									ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
									if (nextWorld != null) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
										((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
												nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
												_ent.rotationPitch);
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
										for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
										}
										((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
							if (((entityiterator.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
								if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
									((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent(
											"\u00A7cVous avez \u00E9t\u00E9 d\u00E9connecter : \u00A76Maintenance en cours !"), (false));
								}
							} else if (((entityiterator.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
								if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
									((PlayerEntity) entityiterator).sendStatusMessage(
											new StringTextComponent("\u00A7cYou have been disconnected: \u00A76Maintenance in progress!"), (false));
								}
							}
							{
								Entity _ent = entityiterator;
								_ent.setPositionAndUpdate((world.getWorldInfo().getSpawnX()), (world.getWorldInfo().getSpawnY()),
										(world.getWorldInfo().getSpawnZ()));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((world.getWorldInfo().getSpawnX()),
											(world.getWorldInfo().getSpawnY()), (world.getWorldInfo().getSpawnZ()), _ent.rotationYaw,
											_ent.rotationPitch, Collections.emptySet());
								}
							}
						}
					}
				}
				world = _worldorig;
			}
		} else {
			EriniumModVariables.MapVariables.get(world).maintenanceBeta = (false);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextBeta = "\u00A7aBeta";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
