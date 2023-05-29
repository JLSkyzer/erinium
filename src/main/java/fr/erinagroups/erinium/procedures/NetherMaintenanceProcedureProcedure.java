package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

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
import java.util.ArrayList;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class NetherMaintenanceProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure NetherMaintenanceProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure NetherMaintenanceProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		File file = new File("");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		file = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/players/"),
				File.separator + (entity.getDisplayName().getString() + ".json"));
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					JsonObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (JsonObject.get("staff.erinium.command").getAsBoolean() == true) {
						if (!EriniumModVariables.MapVariables.get(world).maintenanceNether) {
							EriniumModVariables.MapVariables.get(world).maintenanceNether = (true);
							EriniumModVariables.MapVariables.get(world).syncData(world);
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cMaintenance \u00A7aON"), (false));
							}
							if (world instanceof ServerWorld) {
								IWorld _worldorig = world;
								world = ((ServerWorld) world).getServer()
										.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:erinium_nether")));
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
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
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
											if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
												((PlayerEntity) entityiterator)
														.sendStatusMessage(new StringTextComponent("\u00A7cKicked because : maintenance"), (false));
											}
										}
									}
								}
								world = _worldorig;
							}
						} else {
							EriniumModVariables.MapVariables.get(world).maintenanceNether = (false);
							EriniumModVariables.MapVariables.get(world).syncData(world);
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cMaintenance \u00A7aOFF"), (false));
							}
						}
					} else {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cVous n'avez pas la permission !"), (false));
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
