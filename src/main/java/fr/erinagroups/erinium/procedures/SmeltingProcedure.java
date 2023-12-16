package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModItems;

@Mod.EventBusSubscriber
public class SmeltingProcedure {
	@SubscribeEvent
	public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
		execute(event, event.getEntity(), event.getSmelting());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if (itemstack.getItem() == Items.IRON_INGOT) {
				{
					double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 30;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "\u00A7a+" + itemstack.getCount() * 30 + " xp ";
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
			} else if (itemstack.getItem() == Items.GOLD_INGOT) {
				{
					double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 90;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "\u00A7a+" + itemstack.getCount() * 90 + " xp ";
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
				if (itemstack.getItem() == Items.IRON_INGOT) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 60;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + itemstack.getCount() * 60 + " xp ";
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
				} else if (itemstack.getItem() == Items.GOLD_INGOT) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 120;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + itemstack.getCount() * 120 + " xp ";
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
				} else if (itemstack.getItem() == EriniumModItems.SILVER_INGOT.get()) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 125;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + itemstack.getCount() * 125 + " xp ";
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
				} else if (itemstack.getItem() == EriniumModItems.SILICONE_FRAGMENT.get()) {
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 125;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "\u00A7a+" + itemstack.getCount() * 125 + " xp ";
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
					if (itemstack.getItem() == Items.IRON_INGOT) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 95;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + itemstack.getCount() * 95 + " xp ";
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
					} else if (itemstack.getItem() == Items.GOLD_INGOT) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 150;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + itemstack.getCount() * 150 + " xp ";
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
					} else if (itemstack.getItem() == EriniumModItems.COPPER_INGOT.get()) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 105;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + itemstack.getCount() * 105 + " xp ";
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
					} else if (itemstack.getItem() == EriniumModItems.SILVER_INGOT.get()) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 130;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + itemstack.getCount() * 130 + " xp ";
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
					} else if (itemstack.getItem() == EriniumModItems.SILICONE_FRAGMENT.get()) {
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 105;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "\u00A7a+" + itemstack.getCount() * 105 + " xp ";
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
						if (itemstack.getItem() == Items.GOLD_INGOT) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 150;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + itemstack.getCount() * 150 + " xp ";
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
						} else if (itemstack.getItem() == EriniumModItems.COPPER_INGOT.get()) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 125;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + itemstack.getCount() * 125 + " xp ";
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
						} else if (itemstack.getItem() == EriniumModItems.ERINIUM_INGOT.get()) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 145;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + itemstack.getCount() * 145 + " xp ";
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
						} else if (itemstack.getItem() == EriniumModItems.SILVER_INGOT.get()) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 135;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + itemstack.getCount() * 135 + " xp ";
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
						} else if (itemstack.getItem() == EriniumModItems.SILICONE_FRAGMENT.get()) {
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + itemstack.getCount() * 150;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = "\u00A7a+" + itemstack.getCount() * 150 + " xp ";
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
