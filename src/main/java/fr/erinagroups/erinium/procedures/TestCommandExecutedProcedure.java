package fr.erinagroups.erinium.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class TestCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure TestCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack Item_1 = ItemStack.EMPTY;
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + (entity
					.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).Credit)),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent(("" + Math.round((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EriniumModVariables.PlayerVariables())).Credit))),
					(false));
		}
	}
}
