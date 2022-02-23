package fr.erinagroups.erinium.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.erinagroups.erinium.EriniumMod;

public class SciningCactusEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure SciningCactusEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
