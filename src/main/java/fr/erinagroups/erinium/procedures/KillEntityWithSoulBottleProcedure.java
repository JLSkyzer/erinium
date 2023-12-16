package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

import fr.erinagroups.erinium.init.EriniumModItems;

@Mod.EventBusSubscriber
public class KillEntityWithSoulBottleProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack temp = ItemStack.EMPTY;
		if (entity instanceof Cow) {
			if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_4.get())) : false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_4.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Cow")) {
								if (sourceentity instanceof Player _player) {
									ItemStack _stktoremove = itemstackiterator;
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_5.get());
								temp.getOrCreateTag().putString("type", "Cow");
								if (sourceentity instanceof Player _player) {
									ItemStack _setstack = temp;
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
								break;
							}
						}
					}
				}
			} else {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_3.get())) : false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_3.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Cow")) {
									if (sourceentity instanceof Player _player) {
										ItemStack _stktoremove = itemstackiterator;
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_4.get());
									temp.getOrCreateTag().putString("type", "Cow");
									if (sourceentity instanceof Player _player) {
										ItemStack _setstack = temp;
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									break;
								}
							}
						}
					}
				} else {
					if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_2.get())) : false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_2.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Cow")) {
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = itemstackiterator;
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_3.get());
										temp.getOrCreateTag().putString("type", "Cow");
										if (sourceentity instanceof Player _player) {
											ItemStack _setstack = temp;
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
										break;
									}
								}
							}
						}
					} else {
						if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_1.get())) : false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_1.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Cow")) {
											if (sourceentity instanceof Player _player) {
												ItemStack _stktoremove = itemstackiterator;
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_2.get());
											temp.getOrCreateTag().putString("type", "Cow");
											if (sourceentity instanceof Player _player) {
												ItemStack _setstack = temp;
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											break;
										}
									}
								}
							}
						} else {
							if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE.get())) : false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE.get()) {
												if (sourceentity instanceof Player _player) {
													ItemStack _stktoremove = itemstackiterator;
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
												temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_1.get());
												temp.getOrCreateTag().putString("type", "Cow");
												if (sourceentity instanceof Player _player) {
													ItemStack _setstack = temp;
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} else if (entity instanceof EnderMan) {
			if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_4.get())) : false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_4.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Enderman")) {
								if (sourceentity instanceof Player _player) {
									ItemStack _stktoremove = itemstackiterator;
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_5.get());
								temp.getOrCreateTag().putString("type", "Enderman");
								if (sourceentity instanceof Player _player) {
									ItemStack _setstack = temp;
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
								break;
							}
						}
					}
				}
			} else {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_3.get())) : false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_3.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Enderman")) {
									if (sourceentity instanceof Player _player) {
										ItemStack _stktoremove = itemstackiterator;
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_4.get());
									temp.getOrCreateTag().putString("type", "Enderman");
									if (sourceentity instanceof Player _player) {
										ItemStack _setstack = temp;
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									break;
								}
							}
						}
					}
				} else {
					if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_2.get())) : false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_2.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Enderman")) {
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = itemstackiterator;
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_3.get());
										temp.getOrCreateTag().putString("type", "Enderman");
										if (sourceentity instanceof Player _player) {
											ItemStack _setstack = temp;
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
										break;
									}
								}
							}
						}
					} else {
						if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_1.get())) : false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_1.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Enderman")) {
											if (sourceentity instanceof Player _player) {
												ItemStack _stktoremove = itemstackiterator;
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_2.get());
											temp.getOrCreateTag().putString("type", "Enderman");
											if (sourceentity instanceof Player _player) {
												ItemStack _setstack = temp;
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											break;
										}
									}
								}
							}
						} else {
							if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE.get())) : false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE.get()) {
												if (sourceentity instanceof Player _player) {
													ItemStack _stktoremove = itemstackiterator;
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
												temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_1.get());
												temp.getOrCreateTag().putString("type", "Enderman");
												if (sourceentity instanceof Player _player) {
													ItemStack _setstack = temp;
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} else if (entity instanceof Skeleton) {
			if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_4.get())) : false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_4.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Skeleton")) {
								if (sourceentity instanceof Player _player) {
									ItemStack _stktoremove = itemstackiterator;
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
								}
								temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_5.get());
								temp.getOrCreateTag().putString("type", "Skeleton");
								if (sourceentity instanceof Player _player) {
									ItemStack _setstack = temp;
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
								break;
							}
						}
					}
				}
			} else {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_3.get())) : false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_3.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Skeleton")) {
									if (sourceentity instanceof Player _player) {
										ItemStack _stktoremove = itemstackiterator;
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_4.get());
									temp.getOrCreateTag().putString("type", "Skeleton");
									if (sourceentity instanceof Player _player) {
										ItemStack _setstack = temp;
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									break;
								}
							}
						}
					}
				} else {
					if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_2.get())) : false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_2.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Skeleton")) {
										if (sourceentity instanceof Player _player) {
											ItemStack _stktoremove = itemstackiterator;
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_3.get());
										temp.getOrCreateTag().putString("type", "Skeleton");
										if (sourceentity instanceof Player _player) {
											ItemStack _setstack = temp;
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
										break;
									}
								}
							}
						}
					} else {
						if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE_1.get())) : false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE_1.get() && (itemstackiterator.getOrCreateTag().getString("type")).equals("Skeleton")) {
											if (sourceentity instanceof Player _player) {
												ItemStack _stktoremove = itemstackiterator;
												_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
											}
											temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_2.get());
											temp.getOrCreateTag().putString("type", "Skeleton");
											if (sourceentity instanceof Player _player) {
												ItemStack _setstack = temp;
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											break;
										}
									}
								}
							}
						} else {
							if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EriniumModItems.SOUL_BOTTLE.get())) : false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == EriniumModItems.SOUL_BOTTLE.get()) {
												if (sourceentity instanceof Player _player) {
													ItemStack _stktoremove = itemstackiterator;
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
												}
												temp = new ItemStack(EriniumModItems.SOUL_BOTTLE_1.get());
												temp.getOrCreateTag().putString("type", "Skeleton");
												if (sourceentity instanceof Player _player) {
													ItemStack _setstack = temp;
													_setstack.setCount(1);
													ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
												}
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
