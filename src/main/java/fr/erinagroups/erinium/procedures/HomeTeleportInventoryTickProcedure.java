package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import fr.erinagroups.erinium.network.EriniumModVariables;
import fr.erinagroups.erinium.init.EriniumModItems;

public class HomeTeleportInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_x == 0
				&& (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_y == 0
				&& (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).h_z == 0) {
			itemstack.setHoverName(Component.literal(("\u00A7cNo home \u00A7a" + new ItemStack(EriniumModItems.HOME_TELEPORTER.get()).getDisplayName().getString())));
		} else {
			itemstack.setHoverName(Component.literal(("\u00A7cHome set \u00A7a" + new ItemStack(EriniumModItems.HOME_TELEPORTER.get()).getDisplayName().getString())));
		}
	}
}
