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

import fr.erinagroups.erinium.world.inventory.RankMenu;
import fr.erinagroups.erinium.network.RankButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class RankScreen extends AbstractContainerScreen<RankMenu> {
	private final static HashMap<String, Object> guistate = RankMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ssbwiki;

	public RankScreen(RankMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 395;
		this.imageHeight = 220;
	}

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

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/gui_rank.png"), this.leftPos + -16, this.topPos + -10, 0, 0, 427, 240, 427, 240);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.rank.label_level"), 155, 53, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.rank.label_varintegerplayerlvl"), 155, 71, -16724941, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.rank.label_xp"), 155, 89, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.rank.label_varintegerplayerxp_100000"), 155, 107, -6750208, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_ssbwiki = Button.builder(Component.translatable("gui.erinium.rank.button_ssbwiki"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new RankButtonMessage(0, x, y, z));
				RankButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 155, this.topPos + 125, 45, 20).build();
		guistate.put("button:button_ssbwiki", button_ssbwiki);
		this.addRenderableWidget(button_ssbwiki);
	}
}
