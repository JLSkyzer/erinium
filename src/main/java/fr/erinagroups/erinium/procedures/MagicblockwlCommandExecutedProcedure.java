package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class MagicblockwlCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure MagicblockwlCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				EriniumMod.LOGGER.warn("Failed to load dependency cmdparams for procedure MagicblockwlCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		File MagicBlockWL = new File("");
		com.google.gson.JsonObject playerList = new com.google.gson.JsonObject();
		ArrayList playerListArray = new ArrayList();
		double listIndex = 0;
		MagicBlockWL = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/magicBlockWL/"),
				File.separator + (entity.getDisplayName().getString() + ".json"));
		if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("create")) {
			if (!MagicBlockWL.exists()) {
				try {
					MagicBlockWL.getParentFile().mkdirs();
					MagicBlockWL.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			playerListArray.add((entity.getDisplayName().getString()));
			playerList.addProperty("playerList", ("" + playerListArray));
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(MagicBlockWL);
					fileWriter.write(mainGSONBuilderVariable.toJson(playerList));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			{
				String _setval = (entity.getDisplayName().getString());
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerList = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7bYour whitelist has been created !"), (false));
			}
		} else if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("add")) {
			if (MagicBlockWL.exists()) {
				playerListArray.add(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerList));
				playerListArray.add((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(MagicBlockWL));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						playerList = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						playerList.addProperty("playerList", ("" + playerListArray));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(MagicBlockWL);
								fileWriter.write(mainGSONBuilderVariable.toJson(playerList));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					String _setval = ("" + playerListArray);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerList = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerList).replace("[", ""));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerList = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerList).replace("]", ""));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerList = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("Added \u00A7b" + (new Object() {
						public String getText() {
							String param = (String) cmdparams.get("1");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()))), (false));
				}
			}
		} else if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("check")) {
			playerListArray.add(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerList));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7b" + playerListArray)), (false));
			}
		} else if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("remove")) {
			if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerList).contains((new Object() {
						public String getText() {
							String param = (String) cmdparams.get("1");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()) + ", ")) {
				{
					String _setval = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerList).replace((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("1");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()) + ", ", ""));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerList = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					String _setval = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerList).replace(", " + (new Object() {
								public String getText() {
									String param = (String) cmdparams.get("1");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()), ""));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerList = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				String _setval = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerList).replace("[", ""));
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerList = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerList).replace("]", ""));
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerList = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			playerListArray.add(((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerList));
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(MagicBlockWL));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					playerList = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					playerList.addProperty("playerList", ("" + playerListArray));
					{
						Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
						try {
							FileWriter fileWriter = new FileWriter(MagicBlockWL);
							fileWriter.write(mainGSONBuilderVariable.toJson(playerList));
							fileWriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("Deleted \u00A7b" + (new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()))), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A71--------------------"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"\u00A7a/magicblockWL create \u00A76Cr\u00E9e ou reset votre whitelist / Create or reset your whitelist"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								"\u00A7a/magicblockWL add <player> \u00A76Ajouter un joueur a votre whitelist / add player on your whitelist"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								"\u00A7a/magicblockWL remove <player> \u00A76Retire un joueur de la whitelist / remove player from your whitelist"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"\u00A7a/magicblockWL check \u00A76Liste des joueurs de la whitelist / List of your whitelist's players"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"\u00A7e\u00A7lInformation: \u00A7bsi vous supprimez votre pseudo de la liste vous pourrez toujours supprimer les block magique"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								"\u00A7e\u00A7lInformation: \u00A7bif you delete your nickname from the list you can always delete the magic block"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A71--------------------"), (false));
			}
		}
	}
}
