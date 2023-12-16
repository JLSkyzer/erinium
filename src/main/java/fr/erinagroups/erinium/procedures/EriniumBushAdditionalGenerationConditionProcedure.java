package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.init.EriniumModBlocks;

public class EriniumBushAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EriniumModBlocks.ERINIUM_BUSH.get()) {
			return true;
		}
		return false;
	}
}
