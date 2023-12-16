package fr.erinagroups.erinium.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import fr.erinagroups.erinium.world.inventory.NavDimensionMenu;

import com.mojang.blaze3d.systems.RenderSystem;

public class NavDimensionScreen extends AbstractContainerScreen<NavDimensionMenu> {
	private final static HashMap<String, Object> guistate = NavDimensionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_0_5;
	Button button_6_10;
	Button button_11_15;
	Button button_16_20;

	public NavDimensionScreen(NavDimensionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/nav_dimension.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.nav_dimension.label_dimensions_navigation"), 33, 7, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.nav_dimension.label_rank_level"), 51, 25, -16751104, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_0_5 = Button.builder(Component.translatable("gui.erinium.nav_dimension.button_0_5"), e -> {
		}).bounds(this.leftPos + 42, this.topPos + 43, 90, 20).build();
		guistate.put("button:button_0_5", button_0_5);
		this.addRenderableWidget(button_0_5);
		button_6_10 = Button.builder(Component.translatable("gui.erinium.nav_dimension.button_6_10"), e -> {
		}).bounds(this.leftPos + 42, this.topPos + 70, 90, 20).build();
		guistate.put("button:button_6_10", button_6_10);
		this.addRenderableWidget(button_6_10);
		button_11_15 = Button.builder(Component.translatable("gui.erinium.nav_dimension.button_11_15"), e -> {
		}).bounds(this.leftPos + 42, this.topPos + 97, 90, 20).build();
		guistate.put("button:button_11_15", button_11_15);
		this.addRenderableWidget(button_11_15);
		button_16_20 = Button.builder(Component.translatable("gui.erinium.nav_dimension.button_16_20"), e -> {
		}).bounds(this.leftPos + 42, this.topPos + 124, 90, 20).build();
		guistate.put("button:button_16_20", button_16_20);
		this.addRenderableWidget(button_16_20);
	}
}
