package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

import fr.erinagroups.erinium.block.FusionStationDeltaBlock;
import fr.erinagroups.erinium.block.FusionStationCharlieBlock;
import fr.erinagroups.erinium.block.FusionStationBetaBlock;
import fr.erinagroups.erinium.block.FusionStationAlphaBlock;
import fr.erinagroups.erinium.block.DeltaMarquedBlock;
import fr.erinagroups.erinium.block.CharlieMarquedBlock;
import fr.erinagroups.erinium.block.BetaMarquedBlock;
import fr.erinagroups.erinium.block.AlphaMarquedBlock;
import fr.erinagroups.erinium.EriniumMod;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;

public class FusionStationBaseUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure FusionStationBaseUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure FusionStationBaseUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure FusionStationBaseUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure FusionStationBaseUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!((world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == FusionStationAlphaBlock.block
				|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == AlphaMarquedBlock.block)
				|| (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos(x + 2, y, z), AlphaMarquedBlock.block.getDefaultState(), 3);
		} else if (!((world.getBlockState(new BlockPos(x + 0, y, z + 2))).getBlock() == FusionStationBetaBlock.block
				|| (world.getBlockState(new BlockPos(x + 0, y, z + 2))).getBlock() == BetaMarquedBlock.block)
				|| (world.getBlockState(new BlockPos(x + 0, y, z + 2))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos(x + 0, y, z + 2), BetaMarquedBlock.block.getDefaultState(), 3);
		} else if (!((world.getBlockState(new BlockPos(x - 2, y, z + 0))).getBlock() == FusionStationCharlieBlock.block
				|| (world.getBlockState(new BlockPos(x - 2, y, z + 0))).getBlock() == CharlieMarquedBlock.block)
				|| (world.getBlockState(new BlockPos(x - 2, y, z + 0))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos(x - 2, y, z + 0), CharlieMarquedBlock.block.getDefaultState(), 3);
		} else if (!((world.getBlockState(new BlockPos(x - 0, y, z - 2))).getBlock() == FusionStationDeltaBlock.block
				|| (world.getBlockState(new BlockPos(x - 0, y, z - 2))).getBlock() == DeltaMarquedBlock.block)
				|| (world.getBlockState(new BlockPos(x - 0, y, z - 2))).getBlock() == Blocks.AIR) {
			world.setBlockState(new BlockPos(x - 0, y, z - 2), DeltaMarquedBlock.block.getDefaultState(), 3);
		}
	}
}
