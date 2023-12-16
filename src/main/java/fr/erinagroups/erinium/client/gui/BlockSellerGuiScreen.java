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

import fr.erinagroups.erinium.world.inventory.BlockSellerGuiMenu;
import fr.erinagroups.erinium.procedures.GuiVarEnergySellerCostProcedure;
import fr.erinagroups.erinium.procedures.GuiVarCreditProcedure;
import fr.erinagroups.erinium.procedures.GuiBNBTCreditProcedure;
import fr.erinagroups.erinium.procedures.GUIBNBTErrorProcedure;
import fr.erinagroups.erinium.network.BlockSellerGuiButtonMessage;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class BlockSellerGuiScreen extends AbstractContainerScreen<BlockSellerGuiMenu> {
	private final static HashMap<String, Object> guistate = BlockSellerGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_get_credit;

	public BlockSellerGuiScreen(BlockSellerGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/block_seller_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.block_seller_gui.label_block_seller"), 57, 3, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.erinium.block_seller_gui.label_energy_500000"), 42, 14, -16724992, false);
		guiGraphics.drawString(this.font,

				GuiVarEnergySellerCostProcedure.execute(world), 2, 24, -205, false);
		guiGraphics.drawString(this.font,

				GuiVarCreditProcedure.execute(world, x, y, z), 2, 34, -12829636, false);
		guiGraphics.drawString(this.font,

				GuiBNBTCreditProcedure.execute(entity), 2, 44, -3407872, false);
		guiGraphics.drawString(this.font,

				GUIBNBTErrorProcedure.execute(world, x, y, z), 2, 153, -65536, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_get_credit = Button.builder(Component.translatable("gui.erinium.block_seller_gui.button_get_credit"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new BlockSellerGuiButtonMessage(0, x, y, z));
				BlockSellerGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 49, this.topPos + 58, 77, 20).build();
		guistate.put("button:button_get_credit", button_get_credit);
		this.addRenderableWidget(button_get_credit);
	}
}
