package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.concurrent.atomic.AtomicReference;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModItems;

public class AlchemistSellCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		double count = 0;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get())) : false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == EriniumModItems.AMENINE_LIQUID_5.get()) {
								count = count + itemstackiterator.getCount();
							}
						}
					}
				}
				random = Mth.nextInt(RandomSource.create(), 120, 200);
				{
					double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random;
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
							+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / "
							+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp))), true);
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
				}
				{
					String _setval = "\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ";
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
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get())) : false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == EriniumModItems.AMENINE_LIQUID_5.get()) {
									count = count + itemstackiterator.getCount();
								}
							}
						}
					}
					random = Mth.nextInt(RandomSource.create(), 120, 350);
					{
						double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
								+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / "
								+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp))), true);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
					}
					{
						String _setval = "\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ";
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
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get())) : false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == EriniumModItems.AMENINE_LIQUID_5.get()) {
										count = count + itemstackiterator.getCount();
									}
								}
							}
						}
						random = Mth.nextInt(RandomSource.create(), 180, 400);
						{
							double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random;
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
									+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / "
									+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp))), true);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
						}
						{
							String _setval = "\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ";
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
					if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 18) {
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get())) : false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == EriniumModItems.AMENINE_LIQUID_5.get()) {
											count = count + itemstackiterator.getCount();
										}
									}
								}
							}
							random = Mth.nextInt(RandomSource.create(), 200, 550);
							{
								double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random;
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
										+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / "
										+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp))), true);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
							}
							{
								String _setval = "\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ";
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
							if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get())) : false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == EriniumModItems.AMENINE_LIQUID_5.get()) {
												count = count + itemstackiterator.getCount();
											}
										}
									}
								}
								random = Mth.nextInt(RandomSource.create(), 250, 750);
								{
									double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + count * random;
									entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.playerXp = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(("\u00A7a+" + count * random + " xp " + "\u00A7f| " + "\u00A72"
											+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / "
											+ new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp))), true);
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(EriniumModItems.AMENINE_LIQUID_5.get());
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
								}
								{
									String _setval = "\u00A7a+" + new java.text.DecimalFormat("###,###").format(count * random) + " xp ";
									entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.won_xp_message = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									String _setval = new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp)
											+ " / \u00A74" + new java.text.DecimalFormat("###,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
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
}
