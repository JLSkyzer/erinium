package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BtnAlphaProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BtnAlpha!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!EriniumModVariables.MapVariables.get(world).maintenanceAlpha) {
			EriniumModVariables.MapVariables.get(world).maintenanceAlpha = (true);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextAlpha = "\u00A7cAlpha";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		} else {
			EriniumModVariables.MapVariables.get(world).maintenanceAlpha = (false);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextAlpha = "\u00A7aAlpha";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
