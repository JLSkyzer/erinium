package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.block.MagicBlockWaterBlock;
import fr.erinagroups.erinium.block.MagicBlockSlownessBlock;
import fr.erinagroups.erinium.block.MagicBlockMessageBlock;
import fr.erinagroups.erinium.block.MagicBlockLavaBlock;
import fr.erinagroups.erinium.block.MagicBlockExplosionBlock;
import fr.erinagroups.erinium.block.MagicBlockAlarmBlock;
import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BlockIsPlacedProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
			Entity entity = event.getEntity();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("placedagainst", event.getPlacedAgainst());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BlockIsPlaced!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure BlockIsPlaced!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure BlockIsPlaced!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure BlockIsPlaced!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure BlockIsPlaced!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockLavaBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockWaterBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockExplosionBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockSlownessBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockAlarmBlock.block
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MagicBlockMessageBlock.block) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putString("autor", ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).playerList));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
