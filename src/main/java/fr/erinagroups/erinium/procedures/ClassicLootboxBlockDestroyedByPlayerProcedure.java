package fr.erinagroups.erinium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import fr.erinagroups.erinium.item.XpOrbItem;
import fr.erinagroups.erinium.item.SilverIngotItem;
import fr.erinagroups.erinium.item.FabricRollItem;
import fr.erinagroups.erinium.item.EriniumArmorItem;
import fr.erinagroups.erinium.item.CardboardItem;
import fr.erinagroups.erinium.block.ClassicLootboxBlock;
import fr.erinagroups.erinium.EriniumMod;

public class ClassicLootboxBlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure ClassicLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure ClassicLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure ClassicLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure ClassicLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure ClassicLootboxBlockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack tempItem = ItemStack.EMPTY;
		double random = 0;
		double random2 = 0;
		random = Math.round(Math.random() * 100);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		if (random <= 1) {
			random2 = Math.round(Math.random() * 10);
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ClassicLootboxBlock.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		} else {
			if (random <= 4) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.NETHER_STAR));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (random <= 10) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EriniumArmorItem.helmet));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EriniumArmorItem.legs));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else {
					if (random <= 11) {
						tempItem = new ItemStack(Items.NETHERITE_SWORD);
					} else {
						if (random <= 18) {
							random2 = Math.round(Math.random() * 10);
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EriniumArmorItem.boots));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
							for (int index0 = 0; index0 < (int) (random2); index0++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.DIAMOND));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SilverIngotItem.block));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(XpOrbItem.block));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						} else {
							if (random <= 40) {
								random2 = Math.round(Math.random() * 20);
								for (int index1 = 0; index1 < (int) (random2); index1++) {
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.OAK_LOG));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.OAK_FENCE));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.OAK_SLAB));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.GLASS));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cMr Decorator !"), (false));
								}
							} else {
								if (random <= 55) {
									for (int index2 = 0; index2 < (int) (16); index2++) {
										if (world instanceof World && !world.isRemote()) {
											ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL));
											entityToSpawn.setPickupDelay((int) 10);
											world.addEntity(entityToSpawn);
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cFurnace !"), (false));
									}
								} else {
									if (random <= 65) {
										random2 = Math.round(Math.random() * 12);
										for (int index3 = 0; index3 < (int) (random2); index3++) {
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.CHICKEN));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cKFC"), (false));
										}
									} else {
										if (random <= 85) {
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
														new ItemStack(Items.EXPERIENCE_BOTTLE));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
														new ItemStack(Items.EXPERIENCE_BOTTLE));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
														new ItemStack(FabricRollItem.block));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(CardboardItem.block));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
										} else {
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.EMERALD));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.EMERALD));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
