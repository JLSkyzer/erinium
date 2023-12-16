package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class CmdTogglePvpProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PlayerIsAdminProcedure.execute(entity)) {
			if (EriniumModVariables.MapVariables.get(world).toggle_pvp) {
				EriniumModVariables.MapVariables.get(world).toggle_pvp = false;
				EriniumModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cMod pvp d\u00E9sactiv\u00E9"), false);
			} else {
				EriniumModVariables.MapVariables.get(world).toggle_pvp = true;
				EriniumModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cMod pvp activ\u00E9"), false);
			}
		}
	}
}
