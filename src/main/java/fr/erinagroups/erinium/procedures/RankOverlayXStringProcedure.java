package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class RankOverlayXStringProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "x : " + new java.text.DecimalFormat("###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).rank_overlay_x);
	}
}
