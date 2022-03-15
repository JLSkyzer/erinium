package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.state.IntegerProperty;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class FarmingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure Farming!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure Farming!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure Farming!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure Farming!");
			return;
		}
		if (dependencies.get("blockstate") == null) {
			if (!dependencies.containsKey("blockstate"))
				EriniumMod.LOGGER.warn("Failed to load dependency blockstate for procedure Farming!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure Farming!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState blockstate = (BlockState) dependencies.get("blockstate");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WHEAT && (new Object() {
				public int get(BlockState _bs, String property) {
					Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
					return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
				}
			}.get(blockstate, "age")) == 7) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 450);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 60;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.wonXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "\u00A7e+450 xp";
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 10) {
				if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WHEAT && (new Object() {
					public int get(BlockState _bs, String property) {
						Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
						return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
					}
				}.get(blockstate, "age")) == 7) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 150);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wonXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7e+150 xp";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CARROTS && (new Object() {
					public int get(BlockState _bs, String property) {
						Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
						return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
					}
				}.get(blockstate, "age")) == 7) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 280);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wonXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7e+280 xp";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.POTATOES && (new Object() {
					public int get(BlockState _bs, String property) {
						Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
						return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
					}
				}.get(blockstate, "age")) == 7) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 285);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wonXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7e+285 xp";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 15) {
					if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CARROTS && (new Object() {
						public int get(BlockState _bs, String property) {
							Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
							return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
						}
					}.get(blockstate, "age")) == 7) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 180);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wonXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7e+180 xp";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.POTATOES && (new Object() {
						public int get(BlockState _bs, String property) {
							Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
							return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
						}
					}.get(blockstate, "age")) == 7) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 200);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wonXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7e+200 xp";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.MELON) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 225);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wonXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7e+225 xp";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else {
					if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 20) {
						if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CARROTS && (new Object() {
							public int get(BlockState _bs, String property) {
								Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
								return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
							}
						}.get(blockstate, "age")) == 7) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 90);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.wonXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7e+90 xp";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.POTATOES && (new Object() {
							public int get(BlockState _bs, String property) {
								Property<?> _prop = _bs.getBlock().getStateContainer().getProperty(property);
								return _prop instanceof IntegerProperty ? _bs.get((IntegerProperty) _prop) : -1;
							}
						}.get(blockstate, "age")) == 7) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 105);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.wonXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7e+105 xp";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.MELON) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 140);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.wonXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7e+140 xp";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + " / 100.000");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}
}
