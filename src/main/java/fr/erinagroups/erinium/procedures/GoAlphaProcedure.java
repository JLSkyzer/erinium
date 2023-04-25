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

public class GoAlphaProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure GoAlpha!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure GoAlpha!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double List = 0;
		if (!EriniumModVariables.MapVariables.get(world).maintenanceAlpha) {
			if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
					new ResourceLocation("erinium:faction_alpha"))))) {
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:faction_alpha")));
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (!(entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).vip) {
							if (List < EriniumModVariables.MapVariables.get(world).MaxPlayerPerServer) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aTeleportatioooon"), (false));
								}
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
										RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("erinium:faction_alpha"));
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
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
										}
									}
								}
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate(EriniumModVariables.MapVariables.get(world).alpha_x,
											EriniumModVariables.MapVariables.get(world).alpha_y, EriniumModVariables.MapVariables.get(world).alpha_z);
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(EriniumModVariables.MapVariables.get(world).alpha_x,
												EriniumModVariables.MapVariables.get(world).alpha_y,
												EriniumModVariables.MapVariables.get(world).alpha_z, _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(
													"\u00A7cErreur : serveur complet ! attendez que le serveur se vide ou acheter un grade vip"),
											(false));
								}
							}
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aTeleportatioooon"), (false));
							}
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("erinium:faction_alpha"));
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
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate(EriniumModVariables.MapVariables.get(world).alpha_x,
										EriniumModVariables.MapVariables.get(world).alpha_y, EriniumModVariables.MapVariables.get(world).alpha_z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation(EriniumModVariables.MapVariables.get(world).alpha_x,
											EriniumModVariables.MapVariables.get(world).alpha_y, EriniumModVariables.MapVariables.get(world).alpha_z,
											_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
								}
							}
						}
					}
					world = _worldorig;
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent("\u00A7cErreur : vous \u00EAtes d\u00E9j\u00E0 dans le serveur !"), (false));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cErreur : serveur en \u00A76maintenance"), (false));
			}
		}
	}
}
