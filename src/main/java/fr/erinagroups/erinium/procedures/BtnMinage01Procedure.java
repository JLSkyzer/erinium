package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BtnMinage01Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BtnMinage01!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!EriniumModVariables.MapVariables.get(world).maintenanceMinage01) {
			EriniumModVariables.MapVariables.get(world).maintenanceMinage01 = (true);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextMinage01 = "\u00A7cMinage 01";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		} else {
			EriniumModVariables.MapVariables.get(world).maintenanceMinage01 = (false);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextMinage01 = "\u00A7aMinage 01";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
