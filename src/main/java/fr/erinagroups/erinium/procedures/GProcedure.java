package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModBlocks;

public class GProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
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
		sx = -16;
		found = false;
		for (int index0 = 0; index0 < 32; index0++) {
			sy = 1;
			for (int index1 = 0; index1 < 254; index1++) {
				sz = -16;
				for (int index2 = 0; index2 < 32; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, sy, z + sz))).getBlock() == Blocks.CHEST || (world.getBlockState(BlockPos.containing(x + sx, sy, z + sz))).getBlock() == Blocks.FURNACE
							|| (world.getBlockState(BlockPos.containing(x + sx, sy, z + sz))).getBlock() == EriniumModBlocks.NETHER_STAR_GEN.get()) {
						found = true;
						NumCoffre = NumCoffre + 1;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
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
