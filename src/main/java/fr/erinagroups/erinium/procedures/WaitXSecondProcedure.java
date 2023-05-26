package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class WaitXSecondProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure WaitXSecond!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A7cHey ! you can't execute command now try in \u00A7e"
					+ new java.text.DecimalFormat("##.#").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).commanddelay / 20)
					+ " second(s) !")), (false));
		}
	}
}
