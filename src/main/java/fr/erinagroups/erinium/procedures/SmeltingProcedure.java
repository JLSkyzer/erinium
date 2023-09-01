package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import fr.erinagroups.erinium.item.SilverIngotItem;
import fr.erinagroups.erinium.item.SiliconeFragmentItem;
import fr.erinagroups.erinium.item.EriniumIngotItem;
import fr.erinagroups.erinium.item.CopperIngotItem;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class SmeltingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
			Entity entity = event.getPlayer();
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			ItemStack itemStack = event.getSmelting();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("itemstack", itemStack);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure Smelting!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure Smelting!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if (itemstack.getItem() == Items.IRON_INGOT) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 30);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = ("\u00A7a+" + (itemstack).getCount() * 30 + " xp ");
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (new java.text.DecimalFormat("###,###")
							.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
							+ " / \u00A74"
							+ new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
				RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else if (itemstack.getItem() == Items.GOLD_INGOT) {
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 90);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = ("\u00A7a+" + (itemstack).getCount() * 90 + " xp ");
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.won_xp_message = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = (new java.text.DecimalFormat("###,###")
							.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
							+ " / \u00A74"
							+ new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
				RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		} else {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 10) {
				if (itemstack.getItem() == Items.IRON_INGOT) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 60);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a+" + (itemstack).getCount() * 60 + " xp ");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (new java.text.DecimalFormat("###,###")
								.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
								+ " / \u00A74"
								+ new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
					RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				} else if (itemstack.getItem() == Items.GOLD_INGOT) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 120);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a+" + (itemstack).getCount() * 120 + " xp ");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (new java.text.DecimalFormat("###,###")
								.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
								+ " / \u00A74"
								+ new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
					RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				} else if (itemstack.getItem() == SilverIngotItem.block) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 125);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a+" + (itemstack).getCount() * 125 + " xp ");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (new java.text.DecimalFormat("###,###")
								.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
								+ " / \u00A74"
								+ new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
					RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				} else if (itemstack.getItem() == SiliconeFragmentItem.block) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 125);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ("\u00A7a+" + (itemstack).getCount() * 125 + " xp ");
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.won_xp_message = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (new java.text.DecimalFormat("###,###")
								.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
								+ " / \u00A74"
								+ new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
					RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			} else {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 15) {
					if (itemstack.getItem() == Items.IRON_INGOT) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 95);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a+" + (itemstack).getCount() * 95 + " xp ");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
									+ " / \u00A74"
									+ new java.text.DecimalFormat("###,###")
											.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
						RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else if (itemstack.getItem() == Items.GOLD_INGOT) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 150);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a+" + (itemstack).getCount() * 150 + " xp ");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
									+ " / \u00A74"
									+ new java.text.DecimalFormat("###,###")
											.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
						RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else if (itemstack.getItem() == CopperIngotItem.block) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 105);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a+" + (itemstack).getCount() * 105 + " xp ");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
									+ " / \u00A74"
									+ new java.text.DecimalFormat("###,###")
											.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
						RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else if (itemstack.getItem() == SilverIngotItem.block) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 130);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a+" + (itemstack).getCount() * 130 + " xp ");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
									+ " / \u00A74"
									+ new java.text.DecimalFormat("###,###")
											.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
						RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else if (itemstack.getItem() == SiliconeFragmentItem.block) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 105);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ("\u00A7a+" + (itemstack).getCount() * 105 + " xp ");
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.won_xp_message = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
									+ " / \u00A74"
									+ new java.text.DecimalFormat("###,###")
											.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
						RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				} else {
					if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 20) {
						if (itemstack.getItem() == Items.GOLD_INGOT) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 150);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a+" + (itemstack).getCount() * 150 + " xp ");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
										+ " / \u00A74"
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
							RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						} else if (itemstack.getItem() == CopperIngotItem.block) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 125);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a+" + (itemstack).getCount() * 125 + " xp ");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
										+ " / \u00A74"
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
							RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						} else if (itemstack.getItem() == EriniumIngotItem.block) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 145);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a+" + (itemstack).getCount() * 145 + " xp ");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
										+ " / \u00A74"
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
							RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						} else if (itemstack.getItem() == SilverIngotItem.block) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 135);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a+" + (itemstack).getCount() * 135 + " xp ");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
										+ " / \u00A74"
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
							RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						} else if (itemstack.getItem() == SiliconeFragmentItem.block) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + (itemstack).getCount() * 150);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = ("\u00A7a+" + (itemstack).getCount() * 150 + " xp ");
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.won_xp_message = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (new java.text.DecimalFormat("###,###")
										.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
										+ " / \u00A74"
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
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
							RankLevelUpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
			}
		}
	}
}
