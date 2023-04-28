package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
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

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class GoMoonProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure GoMoon!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		com.google.gson.JsonObject SecJsonObject = new com.google.gson.JsonObject();
		File file = new File("");
		File file2 = new File("");
		file = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/"), File.separator + "config.json");
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
					if (JsonObject.get("use.planetspawn").getAsBoolean()) {
						file2 = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/Planet Spawn/"),
								File.separator + "config.json");
						{
							try {
								BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
								StringBuilder jsonstringbuilder2 = new StringBuilder();
								String line2;
								while ((line2 = bufferedReader2.readLine()) != null) {
									jsonstringbuilder2.append(line2);
								}
								bufferedReader2.close();
								SecJsonObject = new Gson().fromJson(jsonstringbuilder2.toString(), com.google.gson.JsonObject.class);
								if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerLvl >= 5) {
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
													new ResourceLocation("erinium:moon"));
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
										_ent.setPositionAndUpdate(SecJsonObject.get("moon_x").getAsDouble(),
												SecJsonObject.get("moon_y").getAsDouble(), SecJsonObject.get("moon_z").getAsDouble());
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation(SecJsonObject.get("moon_x").getAsDouble(),
													SecJsonObject.get("moon_y").getAsDouble(), SecJsonObject.get("moon_z").getAsDouble(),
													_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
										}
									}
								} else {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).closeScreen();
									ErrorDonthaveLevelProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
								}

							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else {
						if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerLvl >= 5) {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("erinium:moon"));
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
						} else {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).closeScreen();
							ErrorDonthaveLevelProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
