package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;

import java.util.Map;

import fr.erinagroups.erinium.item.BlockReplacerItem;
import fr.erinagroups.erinium.EriniumMod;

public class BlockReplacerToolInInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure BlockReplacerToolInInventoryTick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).setDisplayName(new StringTextComponent((new ItemStack(BlockReplacerItem.block).getDisplayName().getString() + " \u00A7a("
				+ itemstack.getOrCreateTag().getString("selectedName") + ")")));
	}
}
