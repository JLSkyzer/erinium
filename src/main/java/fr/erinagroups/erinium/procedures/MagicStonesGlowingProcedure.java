package fr.erinagroups.erinium.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class MagicStonesGlowingProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure MagicStonesGlowing!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		return !itemstack.getOrCreateTag().getBoolean("used");
	}
}
