
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import fr.erinagroups.erinium.client.renderer.WizardRenderer;
import fr.erinagroups.erinium.client.renderer.TreeBossRenderer;
import fr.erinagroups.erinium.client.renderer.GomyRenderer;
import fr.erinagroups.erinium.client.renderer.EriniumSkeletonBossRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EriniumModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EriniumModEntities.BOMB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.GOMY.get(), GomyRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.ERINIUM_SKELETON_BOSS.get(), EriniumSkeletonBossRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.WIZARD.get(), WizardRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.TREE_BOSS.get(), TreeBossRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.MAGIC_WAND_COBWEB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.MAGICAL_WAND.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EriniumModEntities.TREE_BOSS_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}
