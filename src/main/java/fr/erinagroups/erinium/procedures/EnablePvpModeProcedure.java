package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.github.hexomod.worldeditcuife3.k;
import com.github.hexomod.worldeditcuife3.j;
import com.github.hexomod.worldeditcuife3.i;

public class EnablePvpModeProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				Entity immediatesourceentity = event.getSource().getImmediateSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("immediatesourceentity", immediatesourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure EnablePvpMode!");
			return;
		}
		if (dependencies.get("immediatesourceentity") == null) {
			if (!dependencies.containsKey("immediatesourceentity"))
				EriniumMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure EnablePvpMode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
		if (entity instanceof PlayerEntity && immediatesourceentity instanceof PlayerEntity
				|| entity instanceof ServerPlayerEntity && immediatesourceentity instanceof ServerPlayerEntity) {
			if ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).inPvpMode == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent("\u00A7c\u00A7lVous entrez en mode pvp, si vous vous deconnecter, vous perdrez votre stuff !"),
							(false));
				}
			} else if ((immediatesourceentity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).inPvpMode == false) {
				if (immediatesourceentity instanceof PlayerEntity && !immediatesourceentity.world.isRemote()) {
					((PlayerEntity) immediatesourceentity).sendStatusMessage(
							new StringTextComponent("\u00A7c\u00A7lVous entrez en mode pvp, si vous vous deconnecter, vous perdrez votre stuff !"),
							(false));
				}
			}
			{
				double _setval = 400;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.pvpModeTimer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 400;
				immediatesourceentity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.pvpModeTimer = _setval;
					capability.syncPlayerVariables(immediatesourceentity);
				});
			}
		}
	}
}
