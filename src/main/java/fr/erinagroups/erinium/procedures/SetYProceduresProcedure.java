package fr.erinagroups.erinium.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class SetYProceduresProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			double _setval = Math.round(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:inputY") ? ((EditBox) guistate.get("text:inputY")).getValue() : ""));
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.rank_overlay_y = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
