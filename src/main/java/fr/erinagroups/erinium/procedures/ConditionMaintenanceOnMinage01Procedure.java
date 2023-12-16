package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class ConditionMaintenanceOnMinage01Procedure {
	public static boolean execute(LevelAccessor world) {
		if (EriniumModVariables.MapVariables.get(world).maintenanceMinage01) {
			return true;
		}
		return false;
	}
}
