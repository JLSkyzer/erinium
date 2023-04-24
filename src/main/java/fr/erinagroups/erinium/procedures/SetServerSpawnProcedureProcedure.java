package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

import com.github.hexomod.worldeditcuife3.e;

public class SetServerSpawnProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure SetServerSpawnProcedure!");
			return;
		}
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				EriniumMod.LOGGER.warn("Failed to load dependency arguments for procedure SetServerSpawnProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure SetServerSpawnProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
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
						if ((StringArgumentType.getString(arguments, "server")).equals("alpha")) {
							if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:faction_alpha")))) {
								EriniumModVariables.MapVariables.get(world).alpha_x = (entity.getPosX());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).alpha_y = (entity.getPosY());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).alpha_z = (entity.getPosZ());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a"
													+ "Alpha" + " \u00A7eto : \u00A7b\u00A7l" + entity.getPosX() + " " + entity.getPosY() + " "
													+ entity.getPosZ())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), (false));
								}
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("beta")) {
							if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:faction_beta")))) {
								EriniumModVariables.MapVariables.get(world).beta_x = (entity.getPosX());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).beta_y = (entity.getPosY());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).beta_z = (entity.getPosZ());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a"
													+ "Beta" + " \u00A7eto : \u00A7b\u00A7l" + entity.getPosX() + " " + entity.getPosY() + " "
													+ entity.getPosZ())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), (false));
								}
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("charlie")) {
							if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:faction_charlie")))) {
								EriniumModVariables.MapVariables.get(world).charlie_x = (entity.getPosX());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).charlie_y = (entity.getPosY());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).charlie_z = (entity.getPosZ());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a"
													+ "Charlie" + " \u00A7eto : \u00A7b\u00A7l" + entity.getPosX() + " " + entity.getPosY() + " "
													+ entity.getPosZ())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), (false));
								}
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("minage01")) {
							if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:minage_01")))) {
								EriniumModVariables.MapVariables.get(world).minage01_x = (entity.getPosX());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage01_y = (entity.getPosY());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage01_z = (entity.getPosZ());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a"
													+ "Minage01" + " \u00A7eto : \u00A7b\u00A7l" + entity.getPosX() + " " + entity.getPosY() + " "
													+ entity.getPosZ())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), (false));
								}
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("minage02")) {
							if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:minage_02")))) {
								EriniumModVariables.MapVariables.get(world).minage02_x = (entity.getPosX());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage02_y = (entity.getPosY());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage02_z = (entity.getPosZ());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a"
													+ "Minage02" + " \u00A7eto : \u00A7b\u00A7l" + entity.getPosX() + " " + entity.getPosY() + " "
													+ entity.getPosZ())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), (false));
								}
							}
						} else if ((StringArgumentType.getString(arguments, "server")).equals("minage03")) {
							if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("erinium:minage_03")))) {
								EriniumModVariables.MapVariables.get(world).minage03_x = (entity.getPosX());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage03_y = (entity.getPosY());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								EriniumModVariables.MapVariables.get(world).minage03_z = (entity.getPosZ());
								EriniumModVariables.MapVariables.get(world).syncData(world);
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("\u00A74[\u00A76Server Manager\u00A74] \u00A7eSet spawn location for : \u00A7a"
													+ "Minage03" + " \u00A7eto : \u00A7b\u00A7l" + entity.getPosX() + " " + entity.getPosY() + " "
													+ entity.getPosZ())),
											(false));
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A7cVous n'\u00EAtes pas sur le bon server pour faire \u00E7a !"), (false));
								}
							}
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A7cWrong parameter ! use \u00A7e/setserverspawn <alpha, beta, charlie, minage01, minage02, minage03>"),
										(false));
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
