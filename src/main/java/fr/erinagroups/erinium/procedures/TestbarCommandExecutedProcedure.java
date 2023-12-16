package fr.erinagroups.erinium.procedures;

import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class TestbarCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.testBarre = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
