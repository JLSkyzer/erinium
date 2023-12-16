package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;

public class MagicStonesDebugMakeItemGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		return !itemstack.getOrCreateTag().getBoolean("used");
	}
}
