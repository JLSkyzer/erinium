package fr.erinagroups.erinium.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class ScarHProjectileHitsPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				EriniumMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ScarHProjectileHitsPlayer!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		{
			Entity _ent = sourceentity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"playsound erinium:hitmarker player @p");
			}
		}
	}
}
