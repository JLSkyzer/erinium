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

import fr.erinagroups.erinium.world.inventory.WorkbenchTier1WikiPage1Menu;
import fr.erinagroups.erinium.network.WorkbenchTier1WikiPage1ButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class WorkbenchTier1WikiPage1Screen extends AbstractContainerScreen<WorkbenchTier1WikiPage1Menu> {
	private final static HashMap<String, Object> guistate = WorkbenchTier1WikiPage1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_previous_page;
	Button button_next_page;

	public WorkbenchTier1WikiPage1Screen(WorkbenchTier1WikiPage1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 427;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/workbench_tier_1_wiki_page_1.png");

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

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/tier_1_wiki_page.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 427, 240, 427, 240);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.workbench_tier_1_wiki_page_1.label_page_1"), 189, 228, -3355648, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.erinium.workbench_tier_1_wiki_page_1.button_empty"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new WorkbenchTier1WikiPage1ButtonMessage(0, x, y, z));
				WorkbenchTier1WikiPage1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 2, 21, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_previous_page = Button.builder(Component.translatable("gui.erinium.workbench_tier_1_wiki_page_1.button_previous_page"), e -> {
		}).bounds(this.leftPos + 2, this.topPos + 218, 72, 20).build();
		guistate.put("button:button_previous_page", button_previous_page);
		this.addRenderableWidget(button_previous_page);
		button_next_page = Button.builder(Component.translatable("gui.erinium.workbench_tier_1_wiki_page_1.button_next_page"), e -> {
		}).bounds(this.leftPos + 353, this.topPos + 218, 72, 20).build();
		guistate.put("button:button_next_page", button_next_page);
		this.addRenderableWidget(button_next_page);
	}
}
