package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import fr.erinagroups.erinium.block.NetherStarGenBlock;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class GProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure G!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure G!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure G!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure G!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean found = false;
		boolean detect_coffre = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double zz = 0;
		double yy = 0;
		double xx = 0;
		double text_z = 0;
		double test_x = 0;
		double NumCoffre = 0;
		NumCoffre = 0;
		sx = (-16);
		found = (false);
		for (int index0 = 0; index0 < (int) (32); index0++) {
			sy = 1;
			for (int index1 = 0; index1 < (int) (254); index1++) {
				sz = (-16);
				for (int index2 = 0; index2 < (int) (32); index2++) {
					if ((world.getBlockState(new BlockPos((int) (x + sx), (int) sy, (int) (z + sz)))).getBlock() == Blocks.CHEST
							|| (world.getBlockState(new BlockPos((int) (x + sx), (int) sy, (int) (z + sz)))).getBlock() == Blocks.FURNACE
							|| (world.getBlockState(new BlockPos((int) (x + sx), (int) sy, (int) (z + sz)))).getBlock() == NetherStarGenBlock.block) {
						found = (true);
						NumCoffre = (NumCoffre + 1);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		if (found == true) {
			{
				double _setval = NumCoffre;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.percent = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 0;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.percent = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
