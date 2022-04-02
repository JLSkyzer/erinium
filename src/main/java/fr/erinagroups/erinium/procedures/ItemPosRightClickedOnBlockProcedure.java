package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.block.CalculatorBlock;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class ItemPosRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure ItemPosRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure ItemPosRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure ItemPosRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure ItemPosRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure ItemPosRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CalculatorBlock.block) {
			{
				double _setval = x;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.calc_x = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = y;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.calc_y = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = z;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.calc_z = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aBlock pos set !"), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(("X : " + (x - (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).calc_x))),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(("Y : " + (y - (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).calc_y))),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(("Z : " + (z - (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).calc_z))),
						(false));
			}
		}
	}
}
