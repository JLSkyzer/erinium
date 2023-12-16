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

import fr.erinagroups.erinium.world.inventory.GuiWorkbenchTier1Menu;
import fr.erinagroups.erinium.network.GuiWorkbenchTier1ButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuiWorkbenchTier1Screen extends AbstractContainerScreen<GuiWorkbenchTier1Menu> {
	private final static HashMap<String, Object> guistate = GuiWorkbenchTier1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_x1;
	Button button_max;
	Button button_empty;

	public GuiWorkbenchTier1Screen(GuiWorkbenchTier1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 188;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/gui_workbench_tier_1.png");

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

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/tier_1_workbench_panel.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 188, 176, 188);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.gui_workbench_tier_1.label_erinium_workbench_tier_1"), 6, 4, -10092442, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_x1 = Button.builder(Component.translatable("gui.erinium.gui_workbench_tier_1.button_x1"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new GuiWorkbenchTier1ButtonMessage(0, x, y, z));
				GuiWorkbenchTier1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 31, 36, 20).build();
		guistate.put("button:button_x1", button_x1);
		this.addRenderableWidget(button_x1);
		button_max = Button.builder(Component.translatable("gui.erinium.gui_workbench_tier_1.button_max"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new GuiWorkbenchTier1ButtonMessage(1, x, y, z));
				GuiWorkbenchTier1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 58, 36, 20).build();
		guistate.put("button:button_max", button_max);
		this.addRenderableWidget(button_max);
		button_empty = Button.builder(Component.translatable("gui.erinium.gui_workbench_tier_1.button_empty"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new GuiWorkbenchTier1ButtonMessage(2, x, y, z));
				GuiWorkbenchTier1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 153, this.topPos + 2, 20, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
