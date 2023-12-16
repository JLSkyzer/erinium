package fr.erinagroups.erinium.client.gui;

import fr.erinagroups.erinium.procedures.ReturnEnergyProcedure;
import fr.erinagroups.erinium.procedures.ReturnMaxEnergyProcedure;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import fr.erinagroups.erinium.world.inventory.AstralMinerGuiMenu;
import fr.erinagroups.erinium.procedures.AstralMinerGuiValueProcedure;
import fr.erinagroups.erinium.procedures.AstralMinerGuiPercentTextProcedure;

import com.mojang.blaze3d.systems.RenderSystem;

public class AstralMinerGuiScreen extends AbstractContainerScreen<AstralMinerGuiMenu> {
	private final static HashMap<String, Object> guistate = AstralMinerGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AstralMinerGuiScreen(AstralMinerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/astral_miner_bg.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 132 && mouseX < leftPos + 168 && mouseY > topPos + 7 && mouseY < topPos + 70)
			guiGraphics.renderTooltip(font, Component.literal(AstralMinerGuiValueProcedure.execute(world, x, y, z)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		double bar = (500000 / ReturnMaxEnergyProcedure.execute(world, x, y, z)) * ReturnEnergyProcedure.execute(world, x, y, z);

		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/energy_bar_empty.png"), this.leftPos + 132, this.topPos + 7, 0, 0, 32, 64, 32, 64);

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/energy_bar_fill.png"), this.leftPos + 132, this.topPos + 7, 0, 0, 32, (int) bar, 32, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.astral_miner_gui.label_astral_miner"), 2, 3, -16777216, false);
		guiGraphics.drawString(this.font,

				AstralMinerGuiPercentTextProcedure.execute(world, x, y, z), 78, 43, -16724992, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
