package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class CobbleVoidItemInInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure CobbleVoidItemInInventoryTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure CobbleVoidItemInInventoryTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure CobbleVoidItemInInventoryTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("enabled")) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (ItemTags.getCollection().getTagByID(new ResourceLocation("forge:stone")).contains(itemstackiterator.getItem()) || ItemTags
								.getCollection().getTagByID(new ResourceLocation("forge:cobblestone")).contains(itemstackiterator.getItem())) {
							itemstack.getOrCreateTag().putDouble("count",
									(itemstack.getOrCreateTag().getDouble("count") + (itemstackiterator).getCount()));
							if (entity instanceof PlayerEntity) {
								ItemStack _stktoremove = itemstackiterator;
								((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
										(int) ((itemstackiterator).getCount()), ((PlayerEntity) entity).container.func_234641_j_());
							}
						}
					}
				}
			}
		}
		(itemstack).setDisplayName(new StringTextComponent(("\u00A7bCobble Void \u00A7a\u00A7l"
				+ new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("count")) + " \u00A7bblock(s)")));
	}
}
