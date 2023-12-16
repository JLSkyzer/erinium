
package fr.erinagroups.erinium.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import fr.erinagroups.erinium.init.EriniumModItems;
import fr.erinagroups.erinium.init.EriniumModFluids;
import fr.erinagroups.erinium.init.EriniumModFluidTypes;
import fr.erinagroups.erinium.init.EriniumModBlocks;

public abstract class HotWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> EriniumModFluidTypes.HOT_WATER_TYPE.get(), () -> EriniumModFluids.HOT_WATER.get(), () -> EriniumModFluids.FLOWING_HOT_WATER.get())
			.explosionResistance(50f).bucket(() -> EriniumModItems.HOT_WATER_BUCKET.get()).block(() -> (LiquidBlock) EriniumModBlocks.HOT_WATER.get());

	private HotWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.BUBBLE;
	}

	public static class Source extends HotWaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends HotWaterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
