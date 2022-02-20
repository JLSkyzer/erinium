package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.ArrayList;

import java.io.File;

import fr.erinagroups.erinium.block.MagicBlockWaterBlock;
import fr.erinagroups.erinium.block.MagicBlockSlownessBlock;
import fr.erinagroups.erinium.block.MagicBlockMessageBlock;
import fr.erinagroups.erinium.block.MagicBlockLavaBlock;
import fr.erinagroups.erinium.block.MagicBlockExplosionBlock;
import fr.erinagroups.erinium.block.MagicBlockAlarmBlock;
import fr.erinagroups.erinium.EriniumMod;

public class MagicblockStickRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure MagicblockStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure MagicblockStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure MagicblockStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure MagicblockStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure MagicblockStickRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		File MagicBlockWL = new File("");
		String test = "";
		String autorisedPlayer = "";
		BlockState tempBlock = Blocks.AIR.getDefaultState();
		ArrayList playerListArray = new ArrayList();
		ItemStack TempBlock = ItemStack.EMPTY;
		MagicBlockWL = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/erinium/magicBlockWL/"), File.separator + ((new Object() {
			public String getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "autor")) + ".json"));
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockLavaBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockWaterBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockExplosionBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockSlownessBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockAlarmBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockMessageBlock.block) {
			if ((new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "autor")).contains(entity.getDisplayName().getString())) {
				TempBlock = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, (TempBlock));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cYou can not do this !"), (false));
				}
			}
		}
	}
}
