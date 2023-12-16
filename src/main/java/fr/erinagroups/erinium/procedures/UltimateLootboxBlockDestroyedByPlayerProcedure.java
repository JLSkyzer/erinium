package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModItems;
import fr.erinagroups.erinium.init.EriniumModBlocks;

public class UltimateLootboxBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack tempItem = ItemStack.EMPTY;
		double random = 0;
		double random2 = 0;
		double multiple = 0;
		random = Math.round(Math.random() * 100);
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (random <= 1) {
			random2 = Math.round(Math.random() * 3);
			for (int index0 = 0; index0 < (int) random2; index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModBlocks.ULTIMATE_LOOTBOX.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.PURE_GEM.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			if (random <= 3) {
				multiple = Math.round(Math.random() * 2);
				if (multiple <= 1) {
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.DIAMOND_BLOCK.defaultBlockState());
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.GOLD_BLOCK.defaultBlockState());
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.IRON_BLOCK.defaultBlockState());
					if (world instanceof ServerLevel _level)
						FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.EMERALD_BLOCK.defaultBlockState());
				} else {
					if (multiple <= 2) {
						for (int index1 = 0; index1 < 16; index1++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.DIAMOND));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.IRON_INGOT));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLD_INGOT));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			} else {
				if (random <= 8) {
					random2 = Math.round(Math.random() * 5);
					for (int index2 = 0; index2 < (int) random2; index2++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModBlocks.CLASSIC_LOOTBOX.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				} else {
					if (random <= 10) {
						random2 = Math.round(Math.random() * 16);
						for (int index3 = 0; index3 < (int) random2; index3++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.ERINIUM_INGOT.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("" + Component.translatable("lootbox.event.drop_erinium").getString())), false);
					} else {
						if (random <= 20) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("" + Component.translatable("lootbox.event.oregen_1").getString())), false);
							for (int index4 = 0; index4 < 32; index4++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.GOLD_ORE));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.IRON_ORE));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
							for (int index5 = 0; index5 < 16; index5++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.COAL_ORE));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.DIAMOND_ORE));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						} else {
							if (random <= 25) {
								multiple = Math.round(Math.random() * 3);
								if (multiple <= 1) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ZOMBIE_SPAWN_EGG));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else {
									if (multiple <= 2) {
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.SPIDER_SPAWN_EGG));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else {
										if (multiple <= 3) {
											if (world instanceof ServerLevel _level) {
												ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.SKELETON_SPAWN_EGG));
												entityToSpawn.setPickUpDelay(10);
												_level.addFreshEntity(entityToSpawn);
											}
										}
									}
								}
							} else {
								if (random <= 40) {
									random2 = Math.round(Math.random() * 1500);
									{
										double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).Credit + random2;
										entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Credit = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal(("\u00A7c+ " + new java.text.DecimalFormat("##.##").format(random2) + " $")), false);
								} else {
									if (random <= 50) {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:pistol\",Count:1}}");
									} else {
										if (random <= 55) {
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(Blocks.BOOKSHELF);
												_setstack.setCount(6);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
											if (entity instanceof Player _player) {
												ItemStack _setstack = new ItemStack(Blocks.ANCIENT_DEBRIS);
												_setstack.setCount(1);
												ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
											}
										} else {
											if (random <= 65) {
												world.setBlock(BlockPos.containing(x, y, z), Blocks.DIAMOND_BLOCK.defaultBlockState(), 3);
												world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.GOLD_BLOCK.defaultBlockState(), 3);
												world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.EMERALD_BLOCK.defaultBlockState(), 3);
											} else {
												if (random <= 90) {
													if (world instanceof ServerLevel _level) {
														ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EXPERIENCE_BOTTLE));
														entityToSpawn.setPickUpDelay(10);
														_level.addFreshEntity(entityToSpawn);
													}
												} else {
													if (random <= 95) {
														random2 = Mth.nextInt(RandomSource.create(), 1, 4);
														if (random2 == 1) {
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.RAINBOW_SWORD.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
														} else if (random2 == 2) {
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.RAINBOW_PICKAXE.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
														} else if (random2 == 3) {
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.RAINBOW_AXE.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
														} else if (random2 == 4) {
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.RAINBOW_SHOVEL.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
														}
													} else {
														if (random <= 98) {
															if (world instanceof ServerLevel _level) {
																ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EriniumModItems.MAGIC_STONES_INVISIBILITY.get()));
																entityToSpawn.setPickUpDelay(10);
																_level.addFreshEntity(entityToSpawn);
															}
														} else {
															random2 = Math.round(Math.random() * 30000);
															{
																double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + random2;
																entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																	capability.playerXp = _setval;
																	capability.syncPlayerVariables(entity);
																});
															}
															if (entity instanceof Player _player && !_player.level().isClientSide())
																_player.displayClientMessage(Component.literal(("\u00A7c+ " + new java.text.DecimalFormat("##").format(random2) + " xp")), false);
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
		}
	}
}
