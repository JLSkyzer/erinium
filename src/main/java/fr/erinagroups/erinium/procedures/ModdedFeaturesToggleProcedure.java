package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.network.EriniumModVariables;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class ModdedFeaturesToggleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		boolean canexecute = false;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).commanddelay == 0) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/players/"), File.separator + (entity.getDisplayName().getString() + ".json"));
			canexecute = false;
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
							canexecute = true;
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cVous n'avez pas la permission !"), false);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (canexecute) {
				file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/"), File.separator + "config.json");
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
							if (JsonObject.has("moddedfeatures.enabled")) {
								EriniumModVariables.MapVariables.get(world).enablemoddedfeatures = JsonObject.get("moddedfeatures.enabled").getAsBoolean();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("\u00A7bSet modded feature to \u00A7c" + JsonObject.get("moddedfeatures.enabled").getAsBoolean())), false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7bJSON property \u00A7amoddedfeatures.enabled \u00A7bnot exist !"), false);
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
			WaitXSecondProcedure.execute(entity);
		}
	}
}
