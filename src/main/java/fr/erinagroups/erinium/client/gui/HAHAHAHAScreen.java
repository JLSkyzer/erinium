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

import fr.erinagroups.erinium.world.inventory.HAHAHAHAMenu;
import fr.erinagroups.erinium.network.HAHAHAHAButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class HAHAHAHAScreen extends AbstractContainerScreen<HAHAHAHAMenu> {
	private final static HashMap<String, Object> guistate = HAHAHAHAMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_heheha;

	public HAHAHAHAScreen(HAHAHAHAMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/hahahaha.png");

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
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_heheha = Button.builder(Component.translatable("gui.erinium.hahahaha.button_heheha"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new HAHAHAHAButtonMessage(0, x, y, z));
				HAHAHAHAButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 58, this.topPos + 71, 56, 20).build();
		guistate.put("button:button_heheha", button_heheha);
		this.addRenderableWidget(button_heheha);
	}
}
