package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

import fr.erinagroups.erinium.init.EriniumModItems;
import fr.erinagroups.erinium.init.EriniumModBlocks;

@Mod.EventBusSubscriber
public class UnifyItemBlockProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double count = 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:ores/copper"))) && !(itemstackiterator.getItem() == EriniumModBlocks.COPPER_ORE.get().asItem())) {
						count = itemstackiterator.getCount();
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstackiterator;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(EriniumModBlocks.COPPER_ORE.get());
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7aUnification termin\u00A7e"), true);
					} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:ingots/copper"))) && !(itemstackiterator.getItem() == EriniumModItems.COPPER_INGOT.get())) {
						count = itemstackiterator.getCount();
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstackiterator;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(EriniumModItems.COPPER_INGOT.get());
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7aUnification termin\u00A7e"), true);
					} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:ores/lead"))) && !(itemstackiterator.getItem() == EriniumModBlocks.LEAD_ORE.get().asItem())) {
						count = itemstackiterator.getCount();
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstackiterator;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(EriniumModBlocks.LEAD_ORE.get());
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7aUnification termin\u00A7e"), true);
					} else if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:ingots/lead"))) && !(itemstackiterator.getItem() == EriniumModItems.LEAD_INGOT.get())) {
						count = itemstackiterator.getCount();
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = itemstackiterator;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) count, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(EriniumModItems.LEAD_INGOT.get());
							_setstack.setCount((int) count);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7aUnification termin\u00A7e"), true);
					}
				}
			}
		}
	}
}
