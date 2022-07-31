package fr.erinagroups.erinium.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.item.SilverIngotItem;
import fr.erinagroups.erinium.item.SiliconeFragmentItem;
import fr.erinagroups.erinium.item.EriniumIngotItem;
import fr.erinagroups.erinium.item.DraniteGemItem;
import fr.erinagroups.erinium.item.CopperIngotItem;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BreakBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BreakBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure BreakBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure BreakBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure BreakBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure BreakBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure BreakBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 5) {
			if (((world instanceof World && ((World) world).getRecipeManager()
					.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
							((World) world))
					.isPresent())
							? ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), (World) world)
									.get().getRecipeOutput().copy()
							: ItemStack.EMPTY)
					.getItem() == Items.IRON_INGOT) {
				for (int index0 = 0; index0 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index0++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
								.getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				world.destroyBlock(new BlockPos(x, y, z), false);
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp
							+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 110);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 110
									+ " xp " + "\u00A7f| " + "\u00A72" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ " / 100.000")), (true));
				}
			} else if (((world instanceof World && ((World) world).getRecipeManager()
					.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
							((World) world))
					.isPresent())
							? ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), (World) world)
									.get().getRecipeOutput().copy()
							: ItemStack.EMPTY)
					.getItem() == Items.GOLD_INGOT) {
				for (int index1 = 0; index1 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index1++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
								.getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				world.destroyBlock(new BlockPos(x, y, z), false);
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp
							+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 200);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 200
									+ " xp " + "\u00A7f| " + "\u00A72" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ " / 100.000")), (true));
				}
			} else if (((world instanceof World && ((World) world).getRecipeManager()
					.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
							((World) world))
					.isPresent())
							? ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), (World) world)
									.get().getRecipeOutput().copy()
							: ItemStack.EMPTY)
					.getItem() == Items.COAL) {
				for (int index2 = 0; index2 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index2++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
								.getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				world.destroyBlock(new BlockPos(x, y, z), false);
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp
							+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 30);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 30
									+ " xp " + "\u00A7f| " + "\u00A72" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ " / 100.000")), (true));
				}
			} else if (((world instanceof World && ((World) world).getRecipeManager()
					.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
							((World) world))
					.isPresent())
							? ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), (World) world)
									.get().getRecipeOutput().copy()
							: ItemStack.EMPTY)
					.getItem() == Items.DIAMOND) {
				for (int index3 = 0; index3 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index3++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
								.getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				world.destroyBlock(new BlockPos(x, y, z), false);
				{
					double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerXp
							+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 320);
					entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerXp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 320
									+ " xp " + "\u00A7f| " + "\u00A72" + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ " / 100.000")), (true));
				}
			}
		} else {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 10) {
				if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == Items.IRON_INGOT) {
					for (int index4 = 0; index4 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index4++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 60);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 60 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == Items.GOLD_INGOT) {
					for (int index5 = 0; index5 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index5++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 170);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 170 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == SilverIngotItem.block) {
					for (int index6 = 0; index6 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index6++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 125);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 125 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == SiliconeFragmentItem.block) {
					for (int index7 = 0; index7 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index7++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 125);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 125 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == Items.COAL) {
					for (int index8 = 0; index8 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index8++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 8);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 8 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == Items.DIAMOND) {
					for (int index9 = 0; index9 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index9++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 170);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 170 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				} else if (((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY)
						.getItem() == DraniteGemItem.block) {
					for (int index10 = 0; index10 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index10++) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
									.getRecipeManager()
									.getRecipe(IRecipeType.SMELTING,
											new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
					world.destroyBlock(new BlockPos(x, y, z), false);
					{
						double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).playerXp
								+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 240);
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.playerXp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(
												("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 240 + " xp " + "\u00A7f| "
														+ "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
										(true));
					}
				}
			} else {
				if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 15) {
					if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == Items.IRON_INGOT) {
						for (int index11 = 0; index11 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index11++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 15);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 15 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == Items.GOLD_INGOT) {
						for (int index12 = 0; index12 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index12++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 95);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 95 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == CopperIngotItem.block) {
						for (int index13 = 0; index13 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index13++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 105);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 105 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == SilverIngotItem.block) {
						for (int index14 = 0; index14 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index14++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 105);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 105 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == SiliconeFragmentItem.block) {
						for (int index15 = 0; index15 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index15++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 105);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 105 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == Items.DIAMOND) {
						for (int index16 = 0; index16 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index16++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 65);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 65 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					} else if (((world instanceof World && ((World) world).getRecipeManager()
							.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
									((World) world))
							.isPresent())
									? ((World) world).getRecipeManager()
											.getRecipe(IRecipeType.SMELTING,
													new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
													(World) world)
											.get().getRecipeOutput().copy()
									: ItemStack.EMPTY)
							.getItem() == DraniteGemItem.block) {
						for (int index17 = 0; index17 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index17++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
										((world instanceof World && ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory(
																		(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
						world.destroyBlock(new BlockPos(x, y, z), false);
						{
							double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).playerXp
									+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 120);
							entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.playerXp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 120 + " xp " + "\u00A7f| "
															+ "\u00A72"
															+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new EriniumModVariables.PlayerVariables())).playerXp
															+ " / 100.000")),
											(true));
						}
					}
				} else {
					if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerLvl < 20) {
						if (((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY)
								.getItem() == Items.GOLD_INGOT) {
							for (int index18 = 0; index18 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index18++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											((world instanceof World && ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															((World) world))
													.isPresent())
															? ((World) world).getRecipeManager()
																	.getRecipe(IRecipeType.SMELTING, new Inventory(
																			(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																			(World) world)
																	.get().getRecipeOutput().copy()
															: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							world.destroyBlock(new BlockPos(x, y, z), false);
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp
										+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 38);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 38
														+ " xp " + "\u00A7f| " + "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						} else if (((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY)
								.getItem() == CopperIngotItem.block) {
							for (int index19 = 0; index19 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index19++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											((world instanceof World && ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															((World) world))
													.isPresent())
															? ((World) world).getRecipeManager()
																	.getRecipe(IRecipeType.SMELTING, new Inventory(
																			(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																			(World) world)
																	.get().getRecipeOutput().copy()
															: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							world.destroyBlock(new BlockPos(x, y, z), false);
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp
										+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 28);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 28
														+ " xp " + "\u00A7f| " + "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						} else if (((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY)
								.getItem() == EriniumIngotItem.block) {
							for (int index20 = 0; index20 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index20++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											((world instanceof World && ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															((World) world))
													.isPresent())
															? ((World) world).getRecipeManager()
																	.getRecipe(IRecipeType.SMELTING, new Inventory(
																			(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																			(World) world)
																	.get().getRecipeOutput().copy()
															: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							world.destroyBlock(new BlockPos(x, y, z), false);
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp
										+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 45);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 28
														+ " xp " + "\u00A7f| " + "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						} else if (((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY)
								.getItem() == SilverIngotItem.block) {
							for (int index21 = 0; index21 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index21++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											((world instanceof World && ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															((World) world))
													.isPresent())
															? ((World) world).getRecipeManager()
																	.getRecipe(IRecipeType.SMELTING, new Inventory(
																			(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																			(World) world)
																	.get().getRecipeOutput().copy()
															: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							world.destroyBlock(new BlockPos(x, y, z), false);
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp
										+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 26);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 28
														+ " xp " + "\u00A7f| " + "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						} else if (((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY)
								.getItem() == SiliconeFragmentItem.block) {
							for (int index22 = 0; index22 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index22++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											((world instanceof World && ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															((World) world))
													.isPresent())
															? ((World) world).getRecipeManager()
																	.getRecipe(IRecipeType.SMELTING, new Inventory(
																			(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																			(World) world)
																	.get().getRecipeOutput().copy()
															: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							world.destroyBlock(new BlockPos(x, y, z), false);
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp
										+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 26);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 28
														+ " xp " + "\u00A7f| " + "\u00A72"
														+ (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new EriniumModVariables.PlayerVariables())).playerXp
														+ " / 100.000")),
												(true));
							}
						} else if (((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY)
								.getItem() == DraniteGemItem.block) {
							for (int index23 = 0; index23 < (int) (2 + itemstack.getOrCreateTag().getDouble("fortune")); index23++) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
											((world instanceof World && ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING,
															new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
															((World) world))
													.isPresent())
															? ((World) world).getRecipeManager()
																	.getRecipe(IRecipeType.SMELTING, new Inventory(
																			(new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
																			(World) world)
																	.get().getRecipeOutput().copy()
															: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
							world.destroyBlock(new BlockPos(x, y, z), false);
							{
								double _setval = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EriniumModVariables.PlayerVariables())).playerXp
										+ (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 45);
								entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.playerXp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A7a+" + (2 + itemstack.getOrCreateTag().getDouble("fortune")) * 45
														+ " xp " + "\u00A7f| " + "\u00A72"
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
