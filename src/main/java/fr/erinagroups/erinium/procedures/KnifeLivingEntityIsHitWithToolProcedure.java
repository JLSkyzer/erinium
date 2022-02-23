package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.item.EmptyLargeBottleItem;
import fr.erinagroups.erinium.item.BloodLargeBottleItem;
import fr.erinagroups.erinium.EriniumMod;

public class KnifeLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure KnifeLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EmptyLargeBottleItem.block)) : false) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(EmptyLargeBottleItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BloodLargeBottleItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
