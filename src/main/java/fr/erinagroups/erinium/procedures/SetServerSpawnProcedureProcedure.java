package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.network.EriniumModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class SetServerSpawnProcedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
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
						if ((StringArgumentType.getString(arguments, "server")).equals("alpha")) {
							if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
								EriniumModVariables.MapVariables.get(world).alpha_x = entity.getX();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).alpha_y = entity.getY();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).alpha_z = entity.getZ();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a" + "Alpha" + " \u00A7eto : \u00A7b\u00A7l" + entity.getX() + " " + entity.getY() + " " + entity.getZ())),
											false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), false);
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("beta")) {
							if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
								EriniumModVariables.MapVariables.get(world).beta_x = entity.getX();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).beta_y = entity.getY();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).beta_z = entity.getZ();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a" + "Beta" + " \u00A7eto : \u00A7b\u00A7l" + entity.getX() + " " + entity.getY() + " " + entity.getZ())),
											false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), false);
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("charlie")) {
							if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
								EriniumModVariables.MapVariables.get(world).charlie_x = entity.getX();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).charlie_y = entity.getY();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).charlie_z = entity.getZ();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a" + "Charlie" + " \u00A7eto : \u00A7b\u00A7l" + entity.getX() + " " + entity.getY() + " " + entity.getZ())),
											false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), false);
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("minage01")) {
							if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
								EriniumModVariables.MapVariables.get(world).minage01_x = entity.getX();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage01_y = entity.getY();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage01_z = entity.getZ();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a" + "Minage01" + " \u00A7eto : \u00A7b\u00A7l" + entity.getX() + " " + entity.getY() + " " + entity.getZ())),
											false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), false);
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("minage02")) {
							if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
								EriniumModVariables.MapVariables.get(world).minage02_x = entity.getX();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage02_y = entity.getY();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage02_z = entity.getZ();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a" + "Minage02" + " \u00A7eto : \u00A7b\u00A7l" + entity.getX() + " " + entity.getY() + " " + entity.getZ())),
											false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), false);
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("minage03")) {
							if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
								EriniumModVariables.MapVariables.get(world).minage03_x = entity.getX();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage03_y = entity.getY();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage03_z = entity.getZ();
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(
											Component.literal(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a" + "Minage03" + " \u00A7eto : \u00A7b\u00A7l" + entity.getX() + " " + entity.getY() + " " + entity.getZ())),
											false);
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), false);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cWrong parameter ! use \u00A7e/setserverspawn <alpha, beta, charlie, minage01, minage02, minage03>"), false);
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
