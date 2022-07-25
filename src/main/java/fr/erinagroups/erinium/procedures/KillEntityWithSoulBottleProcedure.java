package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.Entity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.item.SoulBottleItem;
import fr.erinagroups.erinium.item.SoulBottle5Item;
import fr.erinagroups.erinium.item.SoulBottle4Item;
import fr.erinagroups.erinium.item.SoulBottle3Item;
import fr.erinagroups.erinium.item.SoulBottle2Item;
import fr.erinagroups.erinium.item.SoulBottle1Item;
import fr.erinagroups.erinium.EriniumMod;

public class KillEntityWithSoulBottleProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure KillEntityWithSoulBottle!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure KillEntityWithSoulBottle!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				EriniumMod.LOGGER.warn("Failed to load dependency sourceentity for procedure KillEntityWithSoulBottle!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack temp = ItemStack.EMPTY;
		if (entity instanceof CowEntity) {
			if ((sourceentity instanceof PlayerEntity)
					? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle4Item.block))
					: false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _iitemhandlerref.set(capability));
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == SoulBottle4Item.block) {
								if (sourceentity instanceof PlayerEntity) {
									ItemStack _stktoremove = itemstackiterator;
									((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
											((PlayerEntity) sourceentity).container.func_234641_j_());
								}
								temp = new ItemStack(SoulBottle5Item.block);
								(temp).getOrCreateTag().putString("type", "Cow");
								if (sourceentity instanceof PlayerEntity) {
									ItemStack _setstack = (temp);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
								}
								break;
							}
						}
					}
				}
			} else {
				if ((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle3Item.block))
						: false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _iitemhandlerref.set(capability));
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == SoulBottle3Item.block) {
									if (sourceentity instanceof PlayerEntity) {
										ItemStack _stktoremove = itemstackiterator;
										((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
												((PlayerEntity) sourceentity).container.func_234641_j_());
									}
									temp = new ItemStack(SoulBottle4Item.block);
									(temp).getOrCreateTag().putString("type", "Cow");
									if (sourceentity instanceof PlayerEntity) {
										ItemStack _setstack = (temp);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
									}
									break;
								}
							}
						}
					}
				} else {
					if ((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle2Item.block))
							: false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _iitemhandlerref.set(capability));
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == SoulBottle2Item.block) {
										if (sourceentity instanceof PlayerEntity) {
											ItemStack _stktoremove = itemstackiterator;
											((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
													(int) 1, ((PlayerEntity) sourceentity).container.func_234641_j_());
										}
										temp = new ItemStack(SoulBottle3Item.block);
										(temp).getOrCreateTag().putString("type", "Cow");
										if (sourceentity instanceof PlayerEntity) {
											ItemStack _setstack = (temp);
											_setstack.setCount((int) 1);
											ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
										}
										break;
									}
								}
							}
						}
					} else {
						if ((sourceentity instanceof PlayerEntity)
								? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle1Item.block))
								: false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
										.ifPresent(capability -> _iitemhandlerref.set(capability));
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == SoulBottle1Item.block) {
											if (sourceentity instanceof PlayerEntity) {
												ItemStack _stktoremove = itemstackiterator;
												((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
														(int) 1, ((PlayerEntity) sourceentity).container.func_234641_j_());
											}
											temp = new ItemStack(SoulBottle2Item.block);
											(temp).getOrCreateTag().putString("type", "Cow");
											if (sourceentity instanceof PlayerEntity) {
												ItemStack _setstack = (temp);
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
											}
											break;
										}
									}
								}
							}
						} else {
							if ((sourceentity instanceof PlayerEntity)
									? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottleItem.block))
									: false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
											.ifPresent(capability -> _iitemhandlerref.set(capability));
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == SoulBottleItem.block) {
												if (sourceentity instanceof PlayerEntity) {
													ItemStack _stktoremove = itemstackiterator;
													((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
															(int) 1, ((PlayerEntity) sourceentity).container.func_234641_j_());
												}
												temp = new ItemStack(SoulBottle1Item.block);
												(temp).getOrCreateTag().putString("type", "Cow");
												if (sourceentity instanceof PlayerEntity) {
													ItemStack _setstack = (temp);
													_setstack.setCount((int) 1);
													ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
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
		} else if (entity instanceof EndermanEntity) {
			if ((sourceentity instanceof PlayerEntity)
					? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle4Item.block))
					: false) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _iitemhandlerref.set(capability));
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == SoulBottle4Item.block) {
								if (sourceentity instanceof PlayerEntity) {
									ItemStack _stktoremove = itemstackiterator;
									((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
											((PlayerEntity) sourceentity).container.func_234641_j_());
								}
								temp = new ItemStack(SoulBottle5Item.block);
								(temp).getOrCreateTag().putString("type", "Enderman");
								if (sourceentity instanceof PlayerEntity) {
									ItemStack _setstack = (temp);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
								}
								break;
							}
						}
					}
				}
			} else {
				if ((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle3Item.block))
						: false) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _iitemhandlerref.set(capability));
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == SoulBottle3Item.block) {
									if (sourceentity instanceof PlayerEntity) {
										ItemStack _stktoremove = itemstackiterator;
										((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
												((PlayerEntity) sourceentity).container.func_234641_j_());
									}
									temp = new ItemStack(SoulBottle4Item.block);
									(temp).getOrCreateTag().putString("type", "Enderman");
									if (sourceentity instanceof PlayerEntity) {
										ItemStack _setstack = (temp);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
									}
									break;
								}
							}
						}
					}
				} else {
					if ((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle2Item.block))
							: false) {
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _iitemhandlerref.set(capability));
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									if (itemstackiterator.getItem() == SoulBottle2Item.block) {
										if (sourceentity instanceof PlayerEntity) {
											ItemStack _stktoremove = itemstackiterator;
											((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
													(int) 1, ((PlayerEntity) sourceentity).container.func_234641_j_());
										}
										temp = new ItemStack(SoulBottle3Item.block);
										(temp).getOrCreateTag().putString("type", "Enderman");
										if (sourceentity instanceof PlayerEntity) {
											ItemStack _setstack = (temp);
											_setstack.setCount((int) 1);
											ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
										}
										break;
									}
								}
							}
						}
					} else {
						if ((sourceentity instanceof PlayerEntity)
								? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottle1Item.block))
								: false) {
							{
								AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
								sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
										.ifPresent(capability -> _iitemhandlerref.set(capability));
								if (_iitemhandlerref.get() != null) {
									for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
										ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
										if (itemstackiterator.getItem() == SoulBottle1Item.block) {
											if (sourceentity instanceof PlayerEntity) {
												ItemStack _stktoremove = itemstackiterator;
												((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
														(int) 1, ((PlayerEntity) sourceentity).container.func_234641_j_());
											}
											temp = new ItemStack(SoulBottle2Item.block);
											(temp).getOrCreateTag().putString("type", "Enderman");
											if (sourceentity instanceof PlayerEntity) {
												ItemStack _setstack = (temp);
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
											}
											break;
										}
									}
								}
							}
						} else {
							if ((sourceentity instanceof PlayerEntity)
									? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SoulBottleItem.block))
									: false) {
								{
									AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
									sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
											.ifPresent(capability -> _iitemhandlerref.set(capability));
									if (_iitemhandlerref.get() != null) {
										for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
											ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
											if (itemstackiterator.getItem() == SoulBottleItem.block) {
												if (sourceentity instanceof PlayerEntity) {
													ItemStack _stktoremove = itemstackiterator;
													((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
															(int) 1, ((PlayerEntity) sourceentity).container.func_234641_j_());
												}
												temp = new ItemStack(SoulBottle1Item.block);
												(temp).getOrCreateTag().putString("type", "Enderman");
												if (sourceentity instanceof PlayerEntity) {
													ItemStack _setstack = (temp);
													_setstack.setCount((int) 1);
													ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
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
