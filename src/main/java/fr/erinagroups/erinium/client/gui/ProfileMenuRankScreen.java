package fr.erinagroups.erinium.client.gui;

import fr.erinagroups.erinium.procedures.ReturnPlayerCapXpProcedure;
import fr.erinagroups.erinium.procedures.ReturnPlayerXpProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;

import java.util.HashMap;

import fr.erinagroups.erinium.world.inventory.ProfileMenuRankMenu;
import fr.erinagroups.erinium.procedures.MenuRankXpStringProcedure;
import fr.erinagroups.erinium.procedures.MenuRankLevelStringProcedure;
import fr.erinagroups.erinium.network.ProfileMenuRankButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class ProfileMenuRankScreen extends AbstractContainerScreen<ProfileMenuRankMenu> {
	private final static HashMap<String, Object> guistate = ProfileMenuRankMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_main;
	Button button_rank;
	Button button_stats;

	public ProfileMenuRankScreen(ProfileMenuRankMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 427;
		this.imageHeight = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/profile_menu_rank.png");

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

		double bar = (248 / ReturnPlayerCapXpProcedure.execute(entity)) * ReturnPlayerXpProcedure.execute(entity);

		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/rank_background.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/rank_bar_empty.png"), this.leftPos + 88, this.topPos + 140, 0, 0, 250, 6, 250, 6);

		guiGraphics.blit(new ResourceLocation("erinium:textures/screens/rank_bar_fill.png"), this.leftPos + 89, this.topPos + 141, 0, 0, (int) bar, 4, 248, 4);

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
		Font fontrender;
		fontrender = Minecraft.getInstance().font;

		String textLevel = MenuRankLevelStringProcedure.execute(entity);
		String textXp = MenuRankXpStringProcedure.execute(entity);

		int x1 = (250 - fontrender.width(textLevel)) / 2;
		int x2 = (250 - fontrender.width(textXp)) / 2;

		guiGraphics.drawString(this.font, textLevel, 88 + x1, 112, -1);
		guiGraphics.drawString(this.font, textXp, 88 + x2, 127, -1);

		/*guiGraphics.drawString(this.font,

				MenuRankLevelStringProcedure.execute(entity), 180, 112, -1, false);*/
		/*guiGraphics.drawString(this.font,

				MenuRankXpStringProcedure.execute(entity), 179, 127, -1, false);*/
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.profile_menu_rank.label_rank"), 198, 0, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_main = Button.builder(Component.translatable("gui.erinium.profile_menu_rank.button_main"), e -> {
		}).bounds(this.leftPos + 2, this.topPos + 175, 108, 20).build();
		guistate.put("button:button_main", button_main);
		this.addRenderableWidget(button_main);
		button_rank = Button.builder(Component.translatable("gui.erinium.profile_menu_rank.button_rank"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuRankButtonMessage(1, x, y, z));
				ProfileMenuRankButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 197, 108, 20).build();
		guistate.put("button:button_rank", button_rank);
		this.addRenderableWidget(button_rank);
		button_stats = Button.builder(Component.translatable("gui.erinium.profile_menu_rank.button_stats"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuRankButtonMessage(2, x, y, z));
				ProfileMenuRankButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 219, 108, 20).build();
		guistate.put("button:button_stats", button_stats);
		this.addRenderableWidget(button_stats);
	}
}
