package fr.erinagroups.erinium.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;
import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class AstralMinerUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure AstralMinerUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure AstralMinerUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure AstralMinerUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure AstralMinerUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		ItemStack tempItem = ItemStack.EMPTY;
		double randomnumber = 0;
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "energyprocess") < 99600) {
			if (new Object() {
				public int getEnergyStored(IWorld world, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 166) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z));
					int _amount = (int) 166;
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("energyprocess", (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(x, y, z), "energyprocess") + 166));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else {
			randomnumber = (MathHelper.nextInt(new Random(), 1, 3));
			if (randomnumber == 1) {
				tempItem = new ItemStack((new Object() {
					public Item getRandomItem(ResourceLocation name) {
						ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
						return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
					}
				}.getRandomItem(new ResourceLocation("forge:ores"))));
			} else if (randomnumber == 2) {
				tempItem = new ItemStack((new Object() {
					public Item getRandomItem(ResourceLocation name) {
						ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
						return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
					}
				}.getRandomItem(new ResourceLocation("forge:dusts"))));
			} else {
				tempItem = new ItemStack((new Object() {
					public Item getRandomItem(ResourceLocation name) {
						ITag<Item> _tag = ItemTags.getCollection().getTagByID(name);
						return _tag.getAllElements().isEmpty() ? Items.AIR : _tag.getRandomElement(new Random());
					}
				}.getRandomItem(new ResourceLocation("forge:gems"))));
			}
			if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos(x, y, z), (int) (0))).getItem() == Blocks.AIR.asItem() || (new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos(x, y, z), (int) (0))).getItem() == (tempItem).getItem()) && new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos(x, y, z), (int) (0)) < 64) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = (tempItem);
						_setstack.setCount((int) (new Object() {
							public int getAmount(IWorld world, BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(world, new BlockPos(x, y, z), (int) (0)) + 1));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("energyprocess", 0);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(x, y, z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("percent", (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "energyprocess")) * 100) / 99600));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
