package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;

public class BlockReplacerItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("selectedName", "null");
	}
}
