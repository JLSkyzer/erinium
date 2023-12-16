package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;

public class MagicStonesDebugItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("used", false);
	}
}
