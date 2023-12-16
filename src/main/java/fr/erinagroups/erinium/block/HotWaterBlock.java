
package fr.erinagroups.erinium.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.procedures.HotWaterMobplayerCollidesBlockProcedure;
import fr.erinagroups.erinium.init.EriniumModFluids;

public class HotWaterBlock extends LiquidBlock {
	public HotWaterBlock() {
		super(() -> EriniumModFluids.HOT_WATER.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(50f).lightLevel(s -> 1).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		HotWaterMobplayerCollidesBlockProcedure.execute(entity);
	}
}
