
package fr.erinagroups.erinium.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.StateContainer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

import fr.erinagroups.erinium.procedures.VolcanoRocksBreakProcedure;
import fr.erinagroups.erinium.itemgroup.EriniumBlocksItemGroup;
import fr.erinagroups.erinium.EriniumModElements;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;
import com.github.hexomod.worldeditcuife3.s;
import com.github.hexomod.worldeditcuife3.e;
import com.github.hexomod.worldeditcuife3.bs;
import com.github.hexomod.worldeditcuife3.br;
import com.github.hexomod.worldeditcuife3.bp;

@EriniumModElements.ModElement.Tag
public class VolcanoRockBlock extends EriniumModElements.ModElement {
	@ObjectHolder("erinium:volcano_rock")
	public static final Block block = null;

	public VolcanoRockBlock(EriniumModElements instance) {
		super(instance, 610);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(EriniumBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public static final EnumProperty<AttachFace> FACE = HorizontalFaceBlock.FACE;

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK, MaterialColor.RED).sound(SoundType.STONE).hardnessAndResistance(3f, 3f).setLightLevel(s -> 0)
					.notSolid().setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
			setRegistryName("volcano_rock");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					switch ((AttachFace) state.get(FACE)) {
						case FLOOR :
							return VoxelShapes.or(makeCuboidShape(13, 0, 13, 4, 9, 4))

									.withOffset(offset.x, offset.y, offset.z);
						case CEILING :
							return VoxelShapes.or(makeCuboidShape(3, 7, 4, 12, 16, 13))

									.withOffset(offset.x, offset.y, offset.z);
						case WALL :
						default :
							return VoxelShapes.or(makeCuboidShape(13, 3, 9, 4, 12, 0))

									.withOffset(offset.x, offset.y, offset.z);
					}
				case NORTH :
					switch ((AttachFace) state.get(FACE)) {
						case FLOOR :
							return VoxelShapes.or(makeCuboidShape(3, 0, 3, 12, 9, 12))

									.withOffset(offset.x, offset.y, offset.z);
						case CEILING :
							return VoxelShapes.or(makeCuboidShape(13, 7, 12, 4, 16, 3))

									.withOffset(offset.x, offset.y, offset.z);
						case WALL :
						default :
							return VoxelShapes.or(makeCuboidShape(3, 12, 16, 12, 3, 7))

									.withOffset(offset.x, offset.y, offset.z);
					}
				case EAST :
					switch ((AttachFace) state.get(FACE)) {
						case FLOOR :
							return VoxelShapes.or(makeCuboidShape(13, 0, 3, 4, 9, 12))

									.withOffset(offset.x, offset.y, offset.z);
						case CEILING :
							return VoxelShapes.or(makeCuboidShape(4, 7, 13, 13, 16, 4))

									.withOffset(offset.x, offset.y, offset.z);
						case WALL :
						default :
							return VoxelShapes.or(makeCuboidShape(9, 3, 3, 0, 12, 12))

									.withOffset(offset.x, offset.y, offset.z);
					}
				case WEST :
					switch ((AttachFace) state.get(FACE)) {
						case FLOOR :
							return VoxelShapes.or(makeCuboidShape(3, 0, 13, 12, 9, 4))

									.withOffset(offset.x, offset.y, offset.z);
						case CEILING :
							return VoxelShapes.or(makeCuboidShape(12, 7, 3, 3, 16, 12))

									.withOffset(offset.x, offset.y, offset.z);
						case WALL :
						default :
							return VoxelShapes.or(makeCuboidShape(16, 12, 13, 7, 3, 4))

									.withOffset(offset.x, offset.y, offset.z);
					}
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING, FACE);
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(FACE, faceForDirection(context.getNearestLookingDirection())).with(FACING,
					context.getPlacementHorizontalFacing().getOpposite());
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		private AttachFace faceForDirection(Direction direction) {
			if (direction.getAxis() == Direction.Axis.Y)
				return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
			else
				return AttachFace.WALL;
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.RED;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Blocks.AIR));
		}

		@Override
		public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			VolcanoRocksBreakProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}

		@Override
		public void onExplosionDestroy(World world, BlockPos pos, Explosion e) {
			super.onExplosionDestroy(world, pos, e);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			VolcanoRocksBreakProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
