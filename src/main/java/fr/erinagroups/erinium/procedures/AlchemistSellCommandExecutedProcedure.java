package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import fr.erinagroups.erinium.item.AmenineLiquid5Item;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class AlchemistSellCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure AlchemistSellCommandExecuted!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure AlchemistSellCommandExecuted!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		double count = 0;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmenineLiquid5Item.block)) : false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _iitemhandlerref.set(capability));
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == AmenineLiquid5Item.block) {
								count = (count + (itemstackiterator).getCount());
							}
						}
					}
				}
				random = (MathHelper.nextInt(new Random(), 120, 200));
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
							+ new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
							+ " / "
							+ new java.text.DecimalFormat("###,###")
									.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).cap_xp))),
							(true));
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(AmenineLiquid5Item.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				{
					String _setval = ("\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ");
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
				if ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmenineLiquid5Item.block))
						: false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _iitemhandlerref.set(capability));
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == AmenineLiquid5Item.block) {
									count = (count + (itemstackiterator).getCount());
								}
							}
						}
					}
					random = (MathHelper.nextInt(new Random(), 120, 350));
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(new StringTextComponent(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
										+ " / "
										+ new java.text.DecimalFormat("###,###")
												.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new EriniumModVariables.PlayerVariables())).cap_xp))),
										(true));
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(AmenineLiquid5Item.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					{
						String _setval = ("\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ");
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
					if ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmenineLiquid5Item.block))
							: false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _iitemhandlerref.set(capability));
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == AmenineLiquid5Item.block) {
										count = (count + (itemstackiterator).getCount());
									}
								}
							}
						}
						random = (MathHelper.nextInt(new Random(), 180, 400));
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
											+ new java.text.DecimalFormat("###,###")
													.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
											+ " / "
											+ new java.text.DecimalFormat("###,###")
													.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new EriniumModVariables.PlayerVariables())).cap_xp))),
											(true));
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(AmenineLiquid5Item.block);
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						{
							String _setval = ("\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ");
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
							.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 18) {
						if ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmenineLiquid5Item.block))
								: false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
										.ifPresent(capability -> _iitemhandlerref.set(capability));
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == AmenineLiquid5Item.block) {
											count = (count + (itemstackiterator).getCount());
										}
									}
								}
							}
							random = (MathHelper.nextInt(new Random(), 200, 550));
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(new StringTextComponent(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
												+ new java.text.DecimalFormat("###,###")
														.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
												+ " / "
												+ new java.text.DecimalFormat("###,###")
														.format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).cap_xp))),
												(true));
							}
							if (entity instanceof PlayerEntity) {
								ItemStack _stktoremove = new ItemStack(AmenineLiquid5Item.block);
								((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
										((PlayerEntity) entity).container.func_234641_j_());
							}
							{
								String _setval = ("\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ");
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
							if ((entity instanceof PlayerEntity)
									? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AmenineLiquid5Item.block))
									: false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
											.ifPresent(capability -> _iitemhandlerref.set(capability));
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == AmenineLiquid5Item.block) {
												count = (count + (itemstackiterator).getCount());
											}
										}
									}
								}
								random = (MathHelper.nextInt(new Random(), 250, 750));
								{
									double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random);
									entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.playerXp = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity)
											.sendStatusMessage(
													new StringTextComponent(
															("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
																	+ new java.text.DecimalFormat("###,###").format((entity
																			.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																			.orElse(new EriniumModVariables.PlayerVariables())).playerXp)
																	+ " / "
																	+ new java.text.DecimalFormat("###,###").format((entity
																			.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																			.orElse(new EriniumModVariables.PlayerVariables())).cap_xp))),
													(true));
								}
								if (entity instanceof PlayerEntity) {
									ItemStack _stktoremove = new ItemStack(AmenineLiquid5Item.block);
									((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) count,
											((PlayerEntity) entity).container.func_234641_j_());
								}
								{
									String _setval = ("\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ");
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
}
