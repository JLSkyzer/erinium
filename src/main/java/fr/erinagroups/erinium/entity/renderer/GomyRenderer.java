
package fr.erinagroups.erinium.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import fr.erinagroups.erinium.entity.GomyEntity;

@OnlyIn(Dist.CLIENT)
public class GomyRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GomyEntity.entity,
					renderManager -> new MobRenderer(renderManager, new CowModel(), 0.5f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("erinium:textures/entities/telecharge.png");
						}
					});
		}
	}
}
