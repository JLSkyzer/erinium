package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

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
		if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("lvl")) {
			if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
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
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText());
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Lvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7aLvl set to " + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()))), (false));
				}
			} else if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("give")) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).Lvl + new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new Object() {
								public String getText() {
									String param = (String) cmdparams.get("2");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Lvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7aadding " + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()) + " lvl")), (false));
				}
			} else if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("take")) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).Lvl - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new Object() {
								public String getText() {
									String param = (String) cmdparams.get("2");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Lvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7aTake " + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()) + " lvl")), (false));
				}
			} else if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("reset")) {
				{
					double _setval = 0;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Lvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aLvl set to 0"), (false));
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
		}.getText()).equals("xp")) {
			if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
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
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText());
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.xp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7axp set to " + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()))), (false));
				}
			} else if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("give")) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).xp + new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new Object() {
								public String getText() {
									String param = (String) cmdparams.get("2");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.xp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7aadding " + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()) + " xp")), (false));
				}
			} else if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("take")) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).xp - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(new Object() {
								public String getText() {
									String param = (String) cmdparams.get("2");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()));
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.xp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7aTake " + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							String param = (String) cmdparams.get("2");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText()) + " xp")), (false));
				}
			} else if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("reset")) {
				{
					double _setval = 0;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.xp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7axp set to 0"), (false));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7c/erinium lvl <set, give, take, reset> <amount>"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7c/erinium xp <set, give, take, reset> <amount>"), (false));
			}
		}
	}
}
