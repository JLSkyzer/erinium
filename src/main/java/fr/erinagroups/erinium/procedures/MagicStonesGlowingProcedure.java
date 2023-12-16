package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;

public class MagicStonesGlowingProcedure {
	public static boolean execute(ItemStack itemstack) {
		return !itemstack.getOrCreateTag().getBoolean("used");
	}
}
