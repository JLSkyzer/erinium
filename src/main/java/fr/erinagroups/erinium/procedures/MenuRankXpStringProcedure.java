package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class MenuRankXpStringProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Xp : \u00A7a" + new java.text.DecimalFormat("#,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " \u00A7r/ \u00A7e"
				+ new java.text.DecimalFormat("#,###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp);
	}
}
