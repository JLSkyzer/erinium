package fr.erinagroups.erinium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class BasicHammerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BasicHammer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure BasicHammer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure BasicHammer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure BasicHammer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure BasicHammer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.rotationPitch > 45 || entity.rotationPitch < -45) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x - 1, y, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x - 1, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x - 1, y, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x + 1, y, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + 1, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + 1, y, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y, z - 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z - 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z - 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y, z + 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z + 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z + 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x - 1, y, z - 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x - 1, y, z - 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x - 1, y, z - 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x - 1, y, z + 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x - 1, y, z + 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x - 1, y, z + 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x + 1, y, z - 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + 1, y, z - 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + 1, y, z - 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x + 1, y, z + 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + 1, y, z + 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + 1, y, z + 1), false);
				}
			}
		} else if ((entity.getHorizontalFacing()) == Direction.NORTH || (entity.getHorizontalFacing()) == Direction.SOUTH) {
			if ((world.getBlockState(new BlockPos(x + 1, y, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + 1, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + 1, y, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x - 1, y, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x - 1, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x - 1, y, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + 1, y + 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + 1, y + 1, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x + 1, y - 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x + 1, y - 1, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x - 1, y - 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x - 1, y - 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x - 1, y - 1, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x - 1, y + 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x - 1, y + 1, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y + 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y + 1, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y - 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y - 1, z), false);
				}
			}
		} else if ((entity.getHorizontalFacing()) == Direction.WEST || (entity.getHorizontalFacing()) == Direction.EAST) {
			if ((world.getBlockState(new BlockPos(x, y, z + 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z + 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z + 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y, z - 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z - 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z - 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y + 1, z + 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y + 1, z + 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y - 1, z + 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y - 1, z + 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y - 1, z - 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y - 1, z - 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y + 1, z - 1)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y + 1, z - 1), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y + 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y + 1, z), false);
				}
			}
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y - 1, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y - 1, z), false);
				}
			}
		}
	}
}
