
package fr.erinagroups.erinium.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import fr.erinagroups.erinium.entity.EriniumSkeletonBossEntity;

public class EriniumSkeletonBossRenderer extends HumanoidMobRenderer<EriniumSkeletonBossEntity, HumanoidModel<EriniumSkeletonBossEntity>> {
	public EriniumSkeletonBossRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new EyesLayer<EriniumSkeletonBossEntity, HumanoidModel<EriniumSkeletonBossEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("erinium:textures/entities/erinium_skeleton_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EriniumSkeletonBossEntity entity) {
		return new ResourceLocation("erinium:textures/entities/erinium_skeleton.png");
	}
}
