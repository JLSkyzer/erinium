package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.init.EriniumModBlocks;

public class SciningCactusAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EriniumModBlocks.SCINING_SAND.get()) {
			world.setBlock(BlockPos.containing(x, y, z), EriniumModBlocks.SCINING_CACTUS.get().defaultBlockState(), 3);
			return true;
		}
		return false;
	}
}
