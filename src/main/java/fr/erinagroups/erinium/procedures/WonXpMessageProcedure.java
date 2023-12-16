package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class WonXpMessageProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).won_xp_message;
	}
}
