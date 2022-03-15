package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class ToggleXpOverlayCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure ToggleXpOverlayCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).toggle_wonxp_overlay == false) {
			{
				boolean _setval = (true);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.toggle_wonxp_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aSet to TRUE"), (false));
			}
		} else {
			{
				boolean _setval = (false);
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.toggle_wonxp_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aSet to FALSE"), (false));
			}
		}
	}
}
