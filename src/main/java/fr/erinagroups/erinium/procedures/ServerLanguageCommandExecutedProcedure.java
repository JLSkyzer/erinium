package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.HashMap;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class ServerLanguageCommandExecutedProcedure {
	public static void execute(Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("FR")) {
			{
				String _setval = "FR";
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.serverLanguage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A74[\u00A7bErinium\u00A74] \u00A7eLa langue du serveur est mis en Fran\u00E7ais !"), false);
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("EN")) {
			{
				String _setval = "EN";
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.serverLanguage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A74[\u00A7bErinium\u00A74] \u00A7eThe server language is now set to English !"), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c/serverlanguage <EN, FR>"), false);
		}
	}
}
