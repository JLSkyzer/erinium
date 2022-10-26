package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

import fr.erinagroups.erinium.item.XpOrbItem;
import fr.erinagroups.erinium.item.PureGemItem;
import fr.erinagroups.erinium.item.EriniumIngotItem;
import fr.erinagroups.erinium.block.UltimateLootboxBlock;
import fr.erinagroups.erinium.block.ClassicLootboxBlock;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;

public class UltimateLootboxBlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure UltimateLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure UltimateLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure UltimateLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure UltimateLootboxBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure UltimateLootboxBlockDestroyedByPlayer!");
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
		double multiple = 0;
		if (!Screen.hasControlDown()) {
			random = Math.round(MathHelper.nextInt(new Random(), 0, 100));
			world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
			if (random <= 1) {
				random2 = Math.round(Math.random() * 3);
				for (int index0 = 0; index0 < (int) (random2); index0++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(UltimateLootboxBlock.block));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PureGemItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (random <= 3) {
					multiple = Math.round(Math.random() * 2);
					if (multiple <= 1) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:heavy_rifle\",Count:1}}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:advanced_bullet\",Count:16}}");
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7etchik paaaaan"), (false));
						}
					} else {
						if (multiple <= 2) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:assault_rifle\",Count:1}}");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:basic_bullet\",Count:40}}");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:basic_bullet\",Count:40}}");
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7egood luck soldier"), (false));
							}
						}
					}
				} else {
					if (random <= 8) {
						random2 = Math.round(Math.random() * 5);
						for (int index1 = 0; index1 < (int) (random2); index1++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ClassicLootboxBlock.block));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
					} else {
						if (random <= 10) {
							random2 = Math.round(Math.random() * 16);
							for (int index2 = 0; index2 < (int) (random2); index2++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EriniumIngotItem.block));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent(("" + new TranslationTextComponent("lootbox.event.drop_erinium").getString())),
										(false));
							}
						} else {
							if (random <= 20) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(("" + new TranslationTextComponent("lootbox.event.oregen_1").getString())),
											(false));
								}
								for (int index3 = 0; index3 < (int) (32); index3++) {
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.GOLD_ORE));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.IRON_ORE));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								}
								for (int index4 = 0; index4 < (int) (16); index4++) {
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.COAL_ORE));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.DIAMOND_ORE));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								}
							} else {
								if (random <= 25) {
									multiple = Math.round(Math.random() * 3);
									if (multiple <= 1) {
										if (world instanceof World && !world.isRemote()) {
											ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.ZOMBIE_SPAWN_EGG));
											entityToSpawn.setPickupDelay((int) 10);
											world.addEntity(entityToSpawn);
										}
									} else {
										if (multiple <= 2) {
											if (world instanceof World && !world.isRemote()) {
												ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
														new ItemStack(Items.SPIDER_SPAWN_EGG));
												entityToSpawn.setPickupDelay((int) 10);
												world.addEntity(entityToSpawn);
											}
										} else {
											if (multiple <= 3) {
												if (world instanceof World && !world.isRemote()) {
													ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
															new ItemStack(Items.SKELETON_SPAWN_EGG));
													entityToSpawn.setPickupDelay((int) 10);
													world.addEntity(entityToSpawn);
												}
											}
										}
									}
								} else {
									if (random <= 40) {
										random2 = Math.round(Math.random() * 1500);
										{
											double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new EriniumModVariables.PlayerVariables())).Credit + random2);
											entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Credit = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
													("\u00A7c+ " + new java.text.DecimalFormat("##.##").format(random2) + " $")), (false));
										}
									} else {
										if (random <= 50) {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"summon minecraft:item ~ ~ ~ {Item:{id:\"cgm:pistol\",Count:1}}");
											}
										} else {
											if (random <= 55) {
												if (entity instanceof PlayerEntity) {
													ItemStack _setstack = new ItemStack(Blocks.BOOKSHELF);
													_setstack.setCount((int) 6);
													ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
												}
												if (entity instanceof PlayerEntity) {
													ItemStack _setstack = new ItemStack(Blocks.ANCIENT_DEBRIS);
													_setstack.setCount((int) 1);
													ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
												}
											} else {
												if (random <= 65) {
													world.setBlockState(new BlockPos(x, y, z), Blocks.DIAMOND_BLOCK.getDefaultState(), 3);
													world.setBlockState(new BlockPos(x, y + 1, z), Blocks.GOLD_BLOCK.getDefaultState(), 3);
													world.setBlockState(new BlockPos(x, y + 2, z), Blocks.EMERALD_BLOCK.getDefaultState(), 3);
												} else {
													if (random <= 90) {
														if (world instanceof World && !world.isRemote()) {
															ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
																	new ItemStack(XpOrbItem.block));
															entityToSpawn.setPickupDelay((int) 10);
															world.addEntity(entityToSpawn);
														}
													} else {
														random2 = Math.round(Math.random() * 30000);
														{
															double _setval = ((entity
																	.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp + random2);
															entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.ifPresent(capability -> {
																		capability.playerXp = _setval;
																		capability.syncPlayerVariables(entity);
																	});
														}
														if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
															((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																	("\u00A7c+ " + new java.text.DecimalFormat("##").format(random2) + " xp")),
																	(false));
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
		} else {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(UltimateLootboxBlock.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
