package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.init.EriniumModItems;

public class OverlayChestFinderDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EriniumModItems.CHEST_FINDER.get();
	}
}
