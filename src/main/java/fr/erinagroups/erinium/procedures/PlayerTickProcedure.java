package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

public class PlayerTickProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).PlayerHealth > 0) {
			if (!(new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.HEALTH_BOOST)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) 999999,
							(int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new EriniumModVariables.PlayerVariables())).PlayerHealth - 1),
							(false), (false)));
			}
		}
	}
}
