package fr.erinagroups.erinium.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class CobbleVoidRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure CobbleVoidRightclicked!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("enabled")) {
			itemstack.getOrCreateTag().putBoolean("enabled", (false));
		} else {
			itemstack.getOrCreateTag().putBoolean("enabled", (true));
		}
	}
}
