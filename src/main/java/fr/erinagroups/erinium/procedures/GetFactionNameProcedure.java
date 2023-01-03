package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class GetFactionNameProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure GetFactionName!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (true) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						("Le nom de faction est : " + (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).PresentationToggle)),
						(false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Le plugin n'est pas installer"), (false));
			}
		}
	}
}
