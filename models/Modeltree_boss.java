// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeltree_boss extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public Modeltree_boss() {
		textureWidth = 256;
		textureHeight = 256;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 80).addBox(-8.0F, -64.0F, -8.0F, 16.0F, 64.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-24.0F, -64.0F, -24.0F, 48.0F, 32.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(144, 0).addBox(-24.0F, -80.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(112, 128).addBox(8.0F, -80.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(112, 96).addBox(-8.0F, -80.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(64, 112).addBox(-8.0F, -80.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(64, 80).addBox(-8.0F, -80.0F, -24.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}