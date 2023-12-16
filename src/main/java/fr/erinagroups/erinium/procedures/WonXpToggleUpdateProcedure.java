package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import fr.erinagroups.erinium.network.EriniumModVariables;

@Mod.EventBusSubscriber
public class WonXpToggleUpdateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).won_xp_overlay_cooldown > 0) {
			{
				boolean _setval = true;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.toggle_wonxp_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).won_xp_overlay_cooldown - 1;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.won_xp_overlay_cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.toggle_wonxp_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
