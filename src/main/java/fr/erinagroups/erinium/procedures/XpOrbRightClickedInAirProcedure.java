package fr.erinagroups.erinium.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import fr.erinagroups.erinium.item.XpOrbItem;
import fr.erinagroups.erinium.EriniumMod;

public class XpOrbRightClickedInAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure XpOrbRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).giveExperiencePoints((int) ((new Random()).nextInt((int) 5 + 1)));
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(XpOrbItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
