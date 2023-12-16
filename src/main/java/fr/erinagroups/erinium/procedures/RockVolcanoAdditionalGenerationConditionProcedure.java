package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.init.EriniumModBlocks;

public class RockVolcanoAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EriniumModBlocks.MOON_SAND.get()) {
			return true;
		}
		return false;
	}
}
