package fr.erinagroups.erinium.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class BtnCharlieProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure BtnCharlie!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!EriniumModVariables.MapVariables.get(world).maintenanceCharlie) {
			EriniumModVariables.MapVariables.get(world).maintenanceCharlie = (true);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextCharlie = "\u00A7cCharlie";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		} else {
			EriniumModVariables.MapVariables.get(world).maintenanceCharlie = (false);
			EriniumModVariables.MapVariables.get(world).syncData(world);
			EriniumModVariables.MapVariables.get(world).maintenanceTextCharlie = "\u00A7aCharlie";
			EriniumModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
