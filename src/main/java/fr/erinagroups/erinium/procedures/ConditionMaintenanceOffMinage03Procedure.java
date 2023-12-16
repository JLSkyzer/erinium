package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class ConditionMaintenanceOffMinage03Procedure {
	public static boolean execute(LevelAccessor world) {
		if (!EriniumModVariables.MapVariables.get(world).maintenanceMinage03) {
			return true;
		}
		return false;
	}
}
