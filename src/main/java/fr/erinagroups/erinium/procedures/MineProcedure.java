package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.block.DraniteOreBlock;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class MineProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure Mine!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure Mine!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure Mine!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure Mine!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure Mine!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.STONE) {
			{
				double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 1);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerXp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\uFFFDa+" + "1" + " xp " + "\uFFFDf| " + "\uFFFD2"
						+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
						+ " / 100.000")), (true));
			}
		} else {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
				if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.COAL_ORE) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 30);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\uFFFDa+" + "30" + " xp " + "\uFFFDf| " + "\uFFFD2"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DIAMOND_ORE) {
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 320);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\uFFFDa+" + "320" + " xp " + "\uFFFDf| " + "\uFFFD2"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				}
			} else {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 10) {
					if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.COAL_ORE) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 8);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\uFFFDa+" + "8" + " xp " + "\uFFFDf| " + "\uFFFD2"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DIAMOND_ORE) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 170);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\uFFFDa+" + "170" + " xp " + "\uFFFDf| " + "\uFFFD2"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == DraniteOreBlock.block) {
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 240);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\uFFFDa+" + "240" + " xp " + "\uFFFDf| " + "\uFFFD2"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					}
				} else {
					if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 15) {
						if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DIAMOND_ORE) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 65);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\uFFFDa+" + "65" + " xp " + "\uFFFDf| " + "\uFFFD2"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == DraniteOreBlock.block) {
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 120);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\uFFFDa+" + "120" + " xp " + "\uFFFDf| " + "\uFFFD2"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						}
					} else {
						if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 20) {
							if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == DraniteOreBlock.block) {
								{
									double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp + 45);
									entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.playerXp = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity)
											.sendStatusMessage(
													new StringTextComponent(("\uFFFDa+" + "45" + " xp " + "\uFFFDf| " + "\uFFFD2"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
													(true));
								}
							}
						}
					}
				}
			}
		}
	}
}
