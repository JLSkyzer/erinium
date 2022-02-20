package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Calendar;

import fr.erinagroups.erinium.EriniumMod;

public class Test2CmdProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure Test2Cmd!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent(("Demain : " + (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1))), (false));
		}
	}
}
