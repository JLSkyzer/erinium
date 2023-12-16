package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import java.util.Map;

import fr.erinagroups.erinium.init.EriniumModBlocks;

public class SetanumPlantsGrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double random = 0;
		random = Math.round(Mth.nextInt(RandomSource.create(), 1, 3));
		if (random == 1) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_0.get()) {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = EriniumModBlocks.SETANUM_STAGE_1.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_1.get()) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = EriniumModBlocks.SETANUM_STAGE_2.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				} else {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.SETANUM_STAGE_2.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EriniumModBlocks.SETANUM_STAGE_3.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
				}
			}
		}
	}
}
