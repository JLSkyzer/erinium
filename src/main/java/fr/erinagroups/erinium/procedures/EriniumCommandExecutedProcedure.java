package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.google.gson.Gson;

public class EriniumCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure EriniumCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				EriniumMod.LOGGER.warn("Failed to load dependency cmdparams for procedure EriniumCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		File file = new File("");
		com.google.gson.JsonObject MainJsonObject = new com.google.gson.JsonObject();
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
					MainJsonObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (MainJsonObject.get("staff.erinium.command").getAsBoolean() == true) {
						if ((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText()).equals("rank")) {
							if ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("1");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()).equals("xp")) {
								if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("set")) {
									{
										double _setval = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(new Object() {
											public String getText() {
												String param = (String) cmdparams.get("3");
												if (param != null) {
													return param;
												}
												return "";
											}
										}.getText());
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerXp = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("give")) {
									{
										double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp + new Object() {
													double convert(String s) {
														try {
															return Double.parseDouble(s.trim());
														} catch (Exception e) {
														}
														return 0;
													}
												}.convert(new Object() {
													public String getText() {
														String param = (String) cmdparams.get("3");
														if (param != null) {
															return param;
														}
														return "";
													}
												}.getText()));
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerXp = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("take")) {
									{
										double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp - new Object() {
													double convert(String s) {
														try {
															return Double.parseDouble(s.trim());
														} catch (Exception e) {
														}
														return 0;
													}
												}.convert(new Object() {
													public String getText() {
														String param = (String) cmdparams.get("3");
														if (param != null) {
															return param;
														}
														return "";
													}
												}.getText()));
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerXp = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("reset")) {
									{
										double _setval = 0;
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerXp = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(
												new StringTextComponent("\u00A7c/erinium rank xp <set | give | take | reset> <number>"), (false));
									}
								}
							} else if ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("1");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()).equals("lvl")) {
								if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("set")) {
									{
										double _setval = new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(new Object() {
											public String getText() {
												String param = (String) cmdparams.get("3");
												if (param != null) {
													return param;
												}
												return "";
											}
										}.getText());
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerLvl = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("give")) {
									{
										double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerLvl + new Object() {
													double convert(String s) {
														try {
															return Double.parseDouble(s.trim());
														} catch (Exception e) {
														}
														return 0;
													}
												}.convert(new Object() {
													public String getText() {
														String param = (String) cmdparams.get("3");
														if (param != null) {
															return param;
														}
														return "";
													}
												}.getText()));
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerLvl = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("take")) {
									{
										double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerLvl - new Object() {
													double convert(String s) {
														try {
															return Double.parseDouble(s.trim());
														} catch (Exception e) {
														}
														return 0;
													}
												}.convert(new Object() {
													public String getText() {
														String param = (String) cmdparams.get("3");
														if (param != null) {
															return param;
														}
														return "";
													}
												}.getText()));
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerLvl = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else if ((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("2");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()).equals("reset")) {
									{
										double _setval = 0;
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerLvl = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a\u00A7lDone !"), (false));
									}
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(
												new StringTextComponent("\u00A7c/erinium rank lvl <set | give | take | reset> <number>"), (false));
									}
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7c/erinium rank <xp | lvl>"), (false));
								}
							}
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7erinium <rank>"), (false));
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
