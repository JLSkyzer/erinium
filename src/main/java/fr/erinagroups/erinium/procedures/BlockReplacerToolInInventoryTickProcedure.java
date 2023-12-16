package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import fr.erinagroups.erinium.init.EriniumModItems;

public class BlockReplacerToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setHoverName(Component.literal((new ItemStack(EriniumModItems.BLOCK_REPLACER.get()).getDisplayName().getString() + " \u00A7a(" + itemstack.getOrCreateTag().getString("selectedName") + ")")));
	}
}
