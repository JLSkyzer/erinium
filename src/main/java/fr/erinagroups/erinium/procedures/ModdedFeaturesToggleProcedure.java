package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class ModdedFeaturesToggleProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure ModdedFeaturesToggle!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure ModdedFeaturesToggle!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		File file = new File("");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		boolean canexecute = false;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).commanddelay == 0) {
			file = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/players/"),
					File.separator + (entity.getDisplayName().getString() + ".json"));
			canexecute = (false);
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
							canexecute = (true);
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
			if (canexecute) {
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
							if (JsonObject.get("moddedfeatures.enabled") != null) {
								EriniumModVariables.MapVariables.get(world).enablemoddedfeatures = JsonObject.get("moddedfeatures.enabled")
										.getAsBoolean();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
											("\u00A7bSet modded feature to \u00A7c" + JsonObject.get("moddedfeatures.enabled").getAsBoolean())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7bJSON property \u00A7amoddedfeatures.enabled \u00A7bnot exist !"),
											(false));
								}
							}

						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			{
				double _setval = 60;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.commanddelay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			WaitXSecondProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
