package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class ConditionMaintenanceOnBetaProcedure {
	public static boolean execute(LevelAccessor world) {
		if (EriniumModVariables.MapVariables.get(world).maintenanceBeta) {
			return true;
		}
		return false;
	}
}
