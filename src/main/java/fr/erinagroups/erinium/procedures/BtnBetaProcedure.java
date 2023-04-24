package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BtnBetaProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BtnBeta!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!EriniumModVariables.MapVariables.get(world).maintenanceBeta) {
			EriniumModVariables.MapVariables.get(world).maintenanceBeta = (true);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextBeta = "\u00A7cBeta";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		} else {
			EriniumModVariables.MapVariables.get(world).maintenanceBeta = (false);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextBeta = "\u00A7aBeta";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
