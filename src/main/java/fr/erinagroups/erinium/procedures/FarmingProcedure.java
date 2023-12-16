package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModBlocks;

@Mod.EventBusSubscriber
public class FarmingProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WHEAT && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 7) {
				{
					double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 120;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "\u00A7a+" + 120 + " xp ";
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
							+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 60;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_overlay_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				RankLevelUpProcedure.execute(entity);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_3.get()
					&& (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl >= 3) {
				{
					double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 180;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "\u00A7a+" + 180 + " xp ";
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
							+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 60;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_overlay_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				RankLevelUpProcedure.execute(entity);
			}
		} else {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 10) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WHEAT && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1) == 7) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 150;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + 150 + " xp ";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
								+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_overlay_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					RankLevelUpProcedure.execute(entity);
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CARROTS
						&& (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip13 ? blockstate.getValue(_getip13) : -1) == 7) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 100;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + 100 + " xp ";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
								+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_overlay_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					RankLevelUpProcedure.execute(entity);
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POTATOES
						&& (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1) == 7) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 100;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + 100 + " xp ";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
								+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_overlay_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					RankLevelUpProcedure.execute(entity);
				} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_3.get()) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 180;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + 180 + " xp ";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
								+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_overlay_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					RankLevelUpProcedure.execute(entity);
				}
			} else {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 15) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CARROTS
							&& (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip23 ? blockstate.getValue(_getip23) : -1) == 7) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 165;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + 165 + " xp ";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
									+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_overlay_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						RankLevelUpProcedure.execute(entity);
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POTATOES
							&& (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip27 ? blockstate.getValue(_getip27) : -1) == 7) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 165;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + 165 + " xp ";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
									+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_overlay_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						RankLevelUpProcedure.execute(entity);
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.MELON) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 220;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + 220 + " xp ";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
									+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_overlay_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						RankLevelUpProcedure.execute(entity);
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_3.get()) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 210;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + 210 + " xp ";
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
									+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message_2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 60;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_overlay_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						RankLevelUpProcedure.execute(entity);
					}
				} else {
					if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 20) {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CARROTS
								&& (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip35 ? blockstate.getValue(_getip35) : -1) == 7) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 180;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + 180 + " xp ";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
										+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_overlay_cooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							RankLevelUpProcedure.execute(entity);
						} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POTATOES
								&& (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip39 ? blockstate.getValue(_getip39) : -1) == 7) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 180;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + 180 + " xp ";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
										+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_overlay_cooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							RankLevelUpProcedure.execute(entity);
						} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.MELON) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 250;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + 250 + " xp ";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
										+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_overlay_cooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							RankLevelUpProcedure.execute(entity);
						} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_3.get()) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + 210;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + 210 + " xp ";
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74"
										+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message_2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 60;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_overlay_cooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							RankLevelUpProcedure.execute(entity);
						}
					}
				}
			}
		}
	}
}
