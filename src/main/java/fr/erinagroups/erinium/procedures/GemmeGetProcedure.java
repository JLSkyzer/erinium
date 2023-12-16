package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

import com.google.gson.Gson;

public class GemmeGetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject JsonObject1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject JsonObject2 = new com.google.gson.JsonObject();
		File file = new File("");
		boolean can = false;
		String tempText = "";
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/gemme/"), File.separator + (StringArgumentType.getString(arguments, "uuid") + ".json"));
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
					JsonObject2 = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("tellraw " + entity.getDisplayName().getString() + " {\"text\":\"" + "\u00A7aNombre de gemme : \u00A76" + new java.text.DecimalFormat("##").format(Math.round(JsonObject2.get("gemme").getAsDouble())) + "\u00A7r\\uE007"
										+ "\"}"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
