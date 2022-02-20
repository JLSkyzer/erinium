package fr.erinagroups.erinium.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class JobMenuOpenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure JobMenuOpen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).lvlFarmer);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lvlFarmer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).xpFarmer);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xpFarmer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).lvlHunter);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lvlHunter = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).xpHunter);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xpHunter = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).lvlMiner);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lvlMiner = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).xpMiner);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xpMiner = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).lvlAlchimiste);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.lvlAlchimiste = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).xpAlchimiste);
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.xpAlchimiste = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
