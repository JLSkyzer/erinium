package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BushBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.STONE || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.DIRT_PATH
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.MYCELIUM || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.COARSE_DIRT
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.PODZOL)) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
