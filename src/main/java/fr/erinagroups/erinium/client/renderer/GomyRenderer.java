
package fr.erinagroups.erinium.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import fr.erinagroups.erinium.entity.GomyEntity;

public class GomyRenderer extends MobRenderer<GomyEntity, CowModel<GomyEntity>> {
	public GomyRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GomyEntity entity) {
		return new ResourceLocation("erinium:textures/entities/telecharge.png");
	}
}
