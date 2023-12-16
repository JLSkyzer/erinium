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

import fr.erinagroups.erinium.world.inventory.BackupMenuMainMenu;
import fr.erinagroups.erinium.network.BackupMenuMainButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class BackupMenuMainScreen extends AbstractContainerScreen<BackupMenuMainMenu> {
	private final static HashMap<String, Object> guistate = BackupMenuMainMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_main;
	Button button_rank;
	Button button_stats;

	public BackupMenuMainScreen(BackupMenuMainMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 427;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/backup_menu_main.png");

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

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/main_menu_background.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 427, 240, 427, 240);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.backup_menu_main.label_bienvenue_ssevarplayername"), 69, 4, -13382656, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.backup_menu_main.label_serveur_ssevargetcurrentserve"), 69, 20, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.backup_menu_main.label_joueurs_connecte_ssevarintege"), 69, 35, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.backup_menu_main.label_empty"), 202, 79, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_main = Button.builder(Component.translatable("gui.erinium.backup_menu_main.button_main"), e -> {
		}).bounds(this.leftPos + 2, this.topPos + 72, 108, 20).build();
		guistate.put("button:button_main", button_main);
		this.addRenderableWidget(button_main);
		button_rank = Button.builder(Component.translatable("gui.erinium.backup_menu_main.button_rank"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new BackupMenuMainButtonMessage(1, x, y, z));
				BackupMenuMainButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 94, 108, 20).build();
		guistate.put("button:button_rank", button_rank);
		this.addRenderableWidget(button_rank);
		button_stats = Button.builder(Component.translatable("gui.erinium.backup_menu_main.button_stats"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new BackupMenuMainButtonMessage(2, x, y, z));
				BackupMenuMainButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 116, 108, 20).build();
		guistate.put("button:button_stats", button_stats);
		this.addRenderableWidget(button_stats);
	}
}
