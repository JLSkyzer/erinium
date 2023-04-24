package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class ConditionMaintenanceOnAlphaProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure ConditionMaintenanceOnAlpha!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (EriniumModVariables.MapVariables.get(world).maintenanceAlpha) {
			return true;
		}
		return false;
	}
}
