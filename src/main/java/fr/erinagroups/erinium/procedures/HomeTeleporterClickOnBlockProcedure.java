package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModBlocks;

public class HomeTeleporterClickOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EriniumModBlocks.BLOCK_SETTER.get()) {
			if (x != 0 && y != 0 && z != 0) {
				if ((world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD) == Level.OVERWORLD) {
					{
						String _setval = "Overworld";
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Home_dim = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = x;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.h_x = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = y;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.h_y = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = z;
						entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.h_z = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7aHome is set, do \u00A7e/gohome"), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cError : Dimension interdite"), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c Error : you cannot set a home setter in x 0 / y 0 / z 0"), false);
			}
		}
	}
}
