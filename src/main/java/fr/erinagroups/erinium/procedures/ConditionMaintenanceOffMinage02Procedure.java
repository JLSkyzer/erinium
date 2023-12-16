package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class ConditionMaintenanceOffMinage02Procedure {
	public static boolean execute(LevelAccessor world) {
		if (!EriniumModVariables.MapVariables.get(world).maintenanceMinage02) {
			return true;
		}
		return false;
	}
}
