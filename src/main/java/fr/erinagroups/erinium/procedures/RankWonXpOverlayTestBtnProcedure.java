package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class RankWonXpOverlayTestBtnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			double _setval = 60;
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.won_xp_overlay_cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "\u00A7aTest overlay !";
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.won_xp_message = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "\u00A74Test overlay ! (2)";
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.won_xp_message_2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
