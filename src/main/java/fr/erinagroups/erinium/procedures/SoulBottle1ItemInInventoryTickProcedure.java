package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class SoulBottle1ItemInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setHoverName(Component.literal(("\u00A79Soul Bottle \u00A7a(" + itemstack.getOrCreateTag().getString("type") + ")")));
	}
}
