
package fr.erinagroups.erinium.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;

import fr.erinagroups.erinium.procedures.SoulBottle1ItemInInventoryTickProcedure;

public class SoulBottle5Item extends Item {
	public SoulBottle5Item() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7b5 / 5"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			SoulBottle1ItemInInventoryTickProcedure.execute(itemstack);
		SoulBottle1ItemInInventoryTickProcedure.execute(itemstack);
	}
}
