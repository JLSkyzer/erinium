package fr.erinagroups.erinium.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class RankWonXpOverlayTestBtnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure RankWonXpOverlayTestBtn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		{
			double _setval = 60;
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.won_xp_overlay_cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "\u00A7aTest overlay !";
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.won_xp_message = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "\u00A74Test overlay ! (2)";
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.won_xp_message_2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
