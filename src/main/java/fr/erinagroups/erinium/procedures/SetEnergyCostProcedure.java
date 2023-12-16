package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.network.EriniumModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.google.gson.Gson;

public class SetEnergyCostProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject Jobject = new com.google.gson.JsonObject();
		File file = new File("");
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
					Jobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (Jobject.get("staff.erinium.command").getAsBoolean() == true) {
						if (DoubleArgumentType.getDouble(arguments, "cost") > 0) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("\u00A7cSet energy cost to : " + new java.text.DecimalFormat("##.#####").format(DoubleArgumentType.getDouble(arguments, "cost")) + " $")), false);
							EriniumModVariables.MapVariables.get(world).energysellercost = DoubleArgumentType.getDouble(arguments, "cost");
							EriniumModVariables.MapVariables.get(world).syncData(world);
						} else if (DoubleArgumentType.getDouble(arguments, "cost") == 0) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cDisable energy cost !"), false);
							EriniumModVariables.MapVariables.get(world).energysellercost = 0;
							EriniumModVariables.MapVariables.get(world).syncData(world);
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cYou can't set an negative number !"), false);
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
