package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class ConditionMaintenanceOffAlphaProcedure {
	public static boolean execute(LevelAccessor world) {
		if (!EriniumModVariables.MapVariables.get(world).maintenanceAlpha) {
			return true;
		}
		return false;
	}
}
