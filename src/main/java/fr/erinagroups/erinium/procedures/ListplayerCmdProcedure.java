package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
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

import com.github.hexomod.worldeditcuife3.e;

public class ListplayerCmdProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure ListplayerCmd!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure ListplayerCmd!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		com.google.gson.JsonObject JsonObject = new com.google.gson.JsonObject();
		File file = new File("");
		boolean allowed = false;
		double List = 0;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).list_player_cooldown <= 0) {
			{
				double _setval = 600;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.list_player_cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			allowed = (false);
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
							allowed = (true);
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
			if (allowed) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7eListe des joueurs :"), (false));
				}
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer().getWorld(World.OVERWORLD);
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											("\u00A77[\u260E] \u00A7aLobby : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									("\u00A77[\uD83C\uDFF9] \u00A7aFaction Alpha : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:faction_beta")));
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									("\u00A77[\uD83C\uDFF9] \u00A7aFaction Beta : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:faction_charlie")));
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									("\u00A77[\uD83C\uDFF9] \u00A7aFaction Charlie : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:minage_01")));
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											("\u00A77[\u26CF] \u00A7aMinage01 : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:minage_02")));
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											("\u00A77[\u26CF] \u00A7aMinage02 : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:minage_03")));
					if (world != null) {
						List = 0;
						{
							List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
							for (Entity entityiterator : _players) {
								List = (List + 1);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											("\u00A77[\u26CF] \u00A7aMinage03 : \u00A76" + new java.text.DecimalFormat("### ###").format(List))),
									(false));
						}
					}
					world = _worldorig;
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity)
						.sendStatusMessage(
								new StringTextComponent(
										("\u00A7cVous ne pouvez executer cette commandes maintenant ! Vous pourrez l'executer dans : \u00A7e"
												+ new java.text.DecimalFormat("##").format(
														Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).list_player_cooldown / 20)))),
								(false));
			}
		}
	}
}
