package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class WaitXSecondProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7cHey ! you can't execute command now try in \u00A7e"
					+ new java.text.DecimalFormat("##.#").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).commanddelay / 20) + " second(s) !")), false);
	}
}
