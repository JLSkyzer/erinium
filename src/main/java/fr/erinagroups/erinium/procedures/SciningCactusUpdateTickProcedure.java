package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.init.EriniumModBlocks;

public class SciningCactusUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EriniumModBlocks.SCINING_CACTUS.get())) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(x, y + 1, z), EriniumModBlocks.SCINING_CACTUS.get().defaultBlockState(), 3);
			}
		} else {
			if (!((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == EriniumModBlocks.SCINING_CACTUS.get())) {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
					world.setBlock(BlockPos.containing(x, y + 1, z), EriniumModBlocks.SCINING_CACTUS.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
