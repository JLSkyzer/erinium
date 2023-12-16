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

public class EnableCustomChatProcedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/players/"), File.separator + (entity.getDisplayName().getString() + ".json"));
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
						if (!EriniumModVariables.MapVariables.get(world).enableCustomChat) {
							EriniumModVariables.MapVariables.get(world).enableCustomChat = true;
							EriniumModVariables.MapVariables.get(world).syncData(world);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7aSet custom chat to \u00A7btrue"), false);
						} else {
							EriniumModVariables.MapVariables.get(world).enableCustomChat = false;
							EriniumModVariables.MapVariables.get(world).syncData(world);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7aSet custom chat to \u00A7bfalse"), false);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cVous n'avez pas la permission !"), false);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
