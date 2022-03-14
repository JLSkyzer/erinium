package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CommandEvent;

import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class ExecuteCommandProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onCommand(CommandEvent event) {
			Entity entity = event.getParseResults().getContext().getSource().getEntity();
			if (entity != null) {
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				String command = event.getParseResults().getReader().getString();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", entity.world);
				dependencies.put("entity", entity);
				dependencies.put("command", command);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {

	}
}
