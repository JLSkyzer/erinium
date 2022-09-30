package fr.erinagroups.erinium.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class BlockReplacerItemIsCraftedsmeltedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure BlockReplacerItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		itemstack.getOrCreateTag().putString("selectedName", "null");
	}
}
