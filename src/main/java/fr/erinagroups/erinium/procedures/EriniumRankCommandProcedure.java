package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import fr.erinagroups.erinium.network.EriniumModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.google.gson.Gson;

public class EriniumRankCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject MainJsonObject = new com.google.gson.JsonObject();
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
					MainJsonObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (MainJsonObject.get("staff.erinium.command").getAsBoolean() == true) {
						if (!("" + new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()).equals("null")) {
							if ((StringArgumentType.getString(arguments, "type")).equals("xp")) {
								if ((StringArgumentType.getString(arguments, "action")).equals("set")) {
									if (DoubleArgumentType.getDouble(arguments, "amount") >= 1) {
										{
											double _setval = DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerXp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74XP\u00A7c] \u00A72set the \u00A7e" + (new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getDisplayName().getString() + "'s xp \u00A72to \u00A7a" + DoubleArgumentType.getDouble(arguments, "amount"))), false);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cInvalid amount"), false);
									}
								} else if ((StringArgumentType.getString(arguments, "action")).equals("give")) {
									if (DoubleArgumentType.getDouble(arguments, "amount") >= 1) {
										{
											double _setval = ((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerXp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74XP\u00A7c] \u00A72Send \u00A7a" + DoubleArgumentType.getDouble(arguments, "amount") + " \u00A72to \u00A7e" + (new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getDisplayName().getString())), false);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cInvalid amount"), false);
									}
								} else if ((StringArgumentType.getString(arguments, "action")).equals("take")) {
									if (DoubleArgumentType.getDouble(arguments, "amount") >= 1) {
										{
											double _setval = ((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp - DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerXp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74XP\u00A7c] \u00A72Take \u00A7a" + DoubleArgumentType.getDouble(arguments, "amount") + " \u00A72to \u00A7e" + (new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getDisplayName().getString())), false);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cInvalid amount"), false);
									}
								} else if ((StringArgumentType.getString(arguments, "action")).equals("reset")) {
									{
										double _setval = 0;
										(new Object() {
											public Entity getEntity() {
												try {
													return EntityArgument.getEntity(arguments, "player");
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return null;
												}
											}
										}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerXp = _setval;
											capability.syncPlayerVariables((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()));
										});
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74XP\u00A7c] \u00A72set the \u00A7e" + (new Object() {
											public Entity getEntity() {
												try {
													return EntityArgument.getEntity(arguments, "player");
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return null;
												}
											}
										}.getEntity()).getDisplayName().getString() + "'s xp \u00A72to \u00A7a0")), false);
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A7cInvalid action use <set, give, take or reset>"), false);
								}
							} else if ((StringArgumentType.getString(arguments, "type")).equals("lvl")) {
								if ((StringArgumentType.getString(arguments, "action")).equals("set")) {
									if (DoubleArgumentType.getDouble(arguments, "amount") >= 1) {
										{
											double _setval = DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerLvl = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = 150000 * 1.065 * DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.cap_xp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = 150000 * 1.065 * (DoubleArgumentType.getDouble(arguments, "amount") - 1);
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.old_cap_xp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = 0;
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerXp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74LVL\u00A7c] \u00A72set the \u00A7e" + (new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getDisplayName().getString() + "'s lvl \u00A72to \u00A7a" + DoubleArgumentType.getDouble(arguments, "amount"))), false);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cInvalid amount"), false);
									}
								} else if ((StringArgumentType.getString(arguments, "action")).equals("give")) {
									if (DoubleArgumentType.getDouble(arguments, "amount") >= 1) {
										{
											double _setval = ((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl + DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerLvl = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = ((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp;
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.old_cap_xp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = ((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).old_cap_xp * 1.065;
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.cap_xp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = 0;
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerXp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74LVL\u00A7c] \u00A72Send \u00A7a" + DoubleArgumentType.getDouble(arguments, "amount") + " \u00A72to \u00A7e" + (new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getDisplayName().getString())), false);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cInvalid amount"), false);
									}
								} else if ((StringArgumentType.getString(arguments, "action")).equals("take")) {
									if (DoubleArgumentType.getDouble(arguments, "amount") >= 1) {
										{
											double _setval = 150000 * 1.065 * (((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl - (DoubleArgumentType.getDouble(arguments, "amount") - 1));
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.old_cap_xp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = 150000 * 1.065 * (((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl - DoubleArgumentType.getDouble(arguments, "amount"));
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.cap_xp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = ((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl - DoubleArgumentType.getDouble(arguments, "amount");
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerLvl = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										{
											double _setval = 0;
											(new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.playerXp = _setval;
												capability.syncPlayerVariables((new Object() {
													public Entity getEntity() {
														try {
															return EntityArgument.getEntity(arguments, "player");
														} catch (CommandSyntaxException e) {
															e.printStackTrace();
															return null;
														}
													}
												}.getEntity()));
											});
										}
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74LVL\u00A7c] \u00A72Take \u00A7a" + DoubleArgumentType.getDouble(arguments, "amount") + " \u00A72to \u00A7e" + (new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()).getDisplayName().getString())), false);
									} else {
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("\u00A7cInvalid amount"), false);
									}
								} else if ((StringArgumentType.getString(arguments, "action")).equals("reset")) {
									{
										double _setval = 1;
										(new Object() {
											public Entity getEntity() {
												try {
													return EntityArgument.getEntity(arguments, "player");
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return null;
												}
											}
										}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerLvl = _setval;
											capability.syncPlayerVariables((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()));
										});
									}
									{
										double _setval = 150000;
										(new Object() {
											public Entity getEntity() {
												try {
													return EntityArgument.getEntity(arguments, "player");
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return null;
												}
											}
										}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.cap_xp = _setval;
											capability.syncPlayerVariables((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()));
										});
									}
									{
										double _setval = 0;
										(new Object() {
											public Entity getEntity() {
												try {
													return EntityArgument.getEntity(arguments, "player");
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return null;
												}
											}
										}.getEntity()).getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.playerXp = _setval;
											capability.syncPlayerVariables((new Object() {
												public Entity getEntity() {
													try {
														return EntityArgument.getEntity(arguments, "player");
													} catch (CommandSyntaxException e) {
														e.printStackTrace();
														return null;
													}
												}
											}.getEntity()));
										});
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal(("\u00A7c[\u00A74LVL\u00A7c] \u00A72set the \u00A7e" + (new Object() {
											public Entity getEntity() {
												try {
													return EntityArgument.getEntity(arguments, "player");
												} catch (CommandSyntaxException e) {
													e.printStackTrace();
													return null;
												}
											}
										}.getEntity()).getDisplayName().getString() + "'s lvl \u00A72to \u00A7a0")), false);
								} else {
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("\u00A7cInvalid action use <set, give, take or reset>"), false);
								}
							} else {
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("\u00A7cInvalid type use <lvl or xp>"), false);
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cUnknow player"), false);
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
