package fr.erinagroups.erinium.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import fr.erinagroups.erinium.world.inventory.ChangeWonXpOverlayMenu;
import fr.erinagroups.erinium.procedures.RankOverlayYStringProcedure;
import fr.erinagroups.erinium.procedures.RankOverlayXStringProcedure;
import fr.erinagroups.erinium.network.ChangeWonXpOverlayButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChangeWonXpOverlayScreen extends AbstractContainerScreen<ChangeWonXpOverlayMenu> {
	private final static HashMap<String, Object> guistate = ChangeWonXpOverlayMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox inputX;
	EditBox inputY;
	Button button_set_x;
	Button button_set_y;
	Button button_test;

	public ChangeWonXpOverlayScreen(ChangeWonXpOverlayMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/change_won_xp_overlay.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputX.render(guiGraphics, mouseX, mouseY, partialTicks);
		inputY.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (inputX.isFocused())
			return inputX.keyPressed(key, b, c);
		if (inputY.isFocused())
			return inputY.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		inputX.tick();
		inputY.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				RankOverlayXStringProcedure.execute(entity), 6, 16, -3407872, false);
		guiGraphics.drawString(this.font,

				RankOverlayYStringProcedure.execute(entity), 6, 61, -3407872, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		inputX = new EditBox(this.font, this.leftPos + 6, this.topPos + 34, 90, 20, Component.translatable("gui.erinium.change_won_xp_overlay.inputX"));
		inputX.setMaxLength(32767);
		guistate.put("text:inputX", inputX);
		this.addWidget(this.inputX);
		inputY = new EditBox(this.font, this.leftPos + 6, this.topPos + 79, 90, 20, Component.translatable("gui.erinium.change_won_xp_overlay.inputY"));
		inputY.setMaxLength(32767);
		guistate.put("text:inputY", inputY);
		this.addWidget(this.inputY);
		button_set_x = Button.builder(Component.translatable("gui.erinium.change_won_xp_overlay.button_set_x"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ChangeWonXpOverlayButtonMessage(0, x, y, z));
				ChangeWonXpOverlayButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 105, this.topPos + 34, 45, 20).build();
		guistate.put("button:button_set_x", button_set_x);
		this.addRenderableWidget(button_set_x);
		button_set_y = Button.builder(Component.translatable("gui.erinium.change_won_xp_overlay.button_set_y"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ChangeWonXpOverlayButtonMessage(1, x, y, z));
				ChangeWonXpOverlayButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 105, this.topPos + 79, 45, 20).build();
		guistate.put("button:button_set_y", button_set_y);
		this.addRenderableWidget(button_set_y);
		button_test = Button.builder(Component.translatable("gui.erinium.change_won_xp_overlay.button_test"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ChangeWonXpOverlayButtonMessage(2, x, y, z));
				ChangeWonXpOverlayButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 133, 54, 20).build();
		guistate.put("button:button_test", button_test);
		this.addRenderableWidget(button_test);
	}
}
