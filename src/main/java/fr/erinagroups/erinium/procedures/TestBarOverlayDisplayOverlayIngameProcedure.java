package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class TestBarOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).testBarre < 60;
	}
}
