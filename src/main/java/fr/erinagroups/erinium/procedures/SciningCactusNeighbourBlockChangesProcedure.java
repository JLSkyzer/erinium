package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SciningCactusNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR || !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR)
				|| !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR) || !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR)
				|| !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR)) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
