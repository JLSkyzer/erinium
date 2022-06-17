package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.ArrayList;

import fr.erinagroups.erinium.EriniumMod;

public class TestListCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure TestListCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ArrayList test = new ArrayList();
		test.clear();
		test.add("Alpha");
		test.add("Beta");
		test.add("Charlie");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + test)), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("The size : " + test.size())), (false));
		}
	}
}
