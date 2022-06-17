package fr.erinagroups.erinium.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class TestbarCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure TestbarCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = 0;
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.testBarre = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
