package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;

public class CobbleVoidMakeItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("enabled");
	}
}
