package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BtnMinage02Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BtnMinage02!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!EriniumModVariables.MapVariables.get(world).maintenanceMinage02) {
			EriniumModVariables.MapVariables.get(world).maintenanceMinage02 = (true);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextMinage02 = "\u00A7cMinage 02";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		} else {
			EriniumModVariables.MapVariables.get(world).maintenanceMinage02 = (false);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextMinage02 = "\u00A7aMinage 02";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
