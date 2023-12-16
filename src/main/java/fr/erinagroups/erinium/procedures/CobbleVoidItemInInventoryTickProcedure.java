package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.concurrent.atomic.AtomicReference;

public class CobbleVoidItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("enabled")) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:stone"))) || itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:cobblestone")))) {
							itemstack.getOrCreateTag().putDouble("count", (itemstack.getOrCreateTag().getDouble("count") + itemstackiterator.getCount()));
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = itemstackiterator;
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
							}
						}
					}
				}
			}
		}
		itemstack.setHoverName(Component.literal(("\u00A7bCobble Void \u00A7a\u00A7l" + new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("count")) + " \u00A7bblock(s)")));
	}
}
