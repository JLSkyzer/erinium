package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MinageDisableDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))
					|| (entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))
					|| (entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION, new ResourceLocation("erinium:deleted_mod_element")))) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (immediatesourceentity instanceof Player || immediatesourceentity instanceof ServerPlayer) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cYou can't pvp here"), false);
				}
			}
		}
	}
}
