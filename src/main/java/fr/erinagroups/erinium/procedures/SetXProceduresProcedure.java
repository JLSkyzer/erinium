package fr.erinagroups.erinium.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class SetXProceduresProcedure {
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
			}.convert(guistate.containsKey("text:inputX") ? ((EditBox) guistate.get("text:inputX")).getValue() : ""));
			entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.rank_overlay_x = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
