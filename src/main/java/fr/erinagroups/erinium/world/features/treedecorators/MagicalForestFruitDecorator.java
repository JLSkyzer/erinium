
package fr.erinagroups.erinium.world.features.treedecorators;

import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

import com.mojang.serialization.Codec;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagicalForestFruitDecorator extends CocoaDecorator {
	public static Codec<MagicalForestFruitDecorator> CODEC = Codec.unit(MagicalForestFruitDecorator::new);
	public static TreeDecoratorType<?> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

	@SubscribeEvent
	public static void registerPointOfInterest(RegisterEvent event) {
		event.register(ForgeRegistries.Keys.TREE_DECORATOR_TYPES, registerHelper -> registerHelper.register("magical_forest_tree_fruit_decorator", DECORATOR_TYPE));
	}

	public MagicalForestFruitDecorator() {
		super(0.2f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return DECORATOR_TYPE;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		RandomSource randomsource = context.random();
		if (!(randomsource.nextFloat() >= 0.2F)) {
			List<BlockPos> list = context.logs();
			int i = list.get(0).getY();
			list.stream().filter((p_69980_) -> {
				return p_69980_.getY() - i <= 2;
			}).forEach((p_226026_) -> {
				for (Direction direction : Direction.Plane.HORIZONTAL) {
					if (randomsource.nextFloat() <= 0.25F) {
						Direction direction1 = direction.getOpposite();
						BlockPos blockpos = p_226026_.offset(direction1.getStepX(), 0, direction1.getStepZ());
						if (context.isAir(blockpos)) {
							context.setBlock(blockpos, Blocks.AIR.defaultBlockState());
						}
					}
				}
			});
		}
	}
}
