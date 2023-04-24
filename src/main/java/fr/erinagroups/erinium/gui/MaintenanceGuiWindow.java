
package fr.erinagroups.erinium.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.widget.button.ImageButton;

import java.awt.*;
import java.util.Collections;
import java.util.Map;


import java.util.HashMap;

import fr.erinagroups.erinium.EriniumMod;
import fr.erinagroups.erinium.EriniumModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;
import com.github.hexomod.worldeditcuife3.l;
import com.github.hexomod.worldeditcuife3.k;
import com.github.hexomod.worldeditcuife3.e;
import com.github.hexomod.worldeditcuife3.c;
import com.github.hexomod.worldeditcuife3.b;
import com.mojang.text2speech.Text2Speech;
import net.minecraft.client.gui.fonts.Font;

@OnlyIn(Dist.CLIENT)
public class MaintenanceGuiWindow extends ContainerScreen<MaintenanceGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MaintenanceGui.guistate;

	public MaintenanceGuiWindow(MaintenanceGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 428;
		this.ySize = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/maintenance.png");
	private static final ResourceLocation MYIMAGE = new ResourceLocation("erinium:textures/screens/maintenance_btn.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/maintenance_screen.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 428, 240, 428, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		MatrixStack matrixStack = new MatrixStack();
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		
		String text1 = (EriniumModVariables.MapVariables.get(world).maintenanceTextMinage01);
		String Text2 = (EriniumModVariables.MapVariables.get(world).maintenanceTextMinage02);
		String text3 = (EriniumModVariables.MapVariables.get(world).maintenanceTextMinage03);
		String text4 = (EriniumModVariables.MapVariables.get(world).maintenanceTextAlpha);
		String text5 = (EriniumModVariables.MapVariables.get(world).maintenanceTextBeta);
		String text6 = (EriniumModVariables.MapVariables.get(world).maintenanceTextCharlie);

		int textWidth = fontRenderer.getStringWidth(text1);
		int textWidth1 = fontRenderer.getStringWidth(text4);
		int textWidth2 = fontRenderer.getStringWidth(text5);
		int textWidth3 = fontRenderer.getStringWidth(text6);
		int x1 = (120 - textWidth) / 2;
		int x2 = (120 - textWidth1) / 2;
		int x3 = (120 - textWidth2) / 2;
		int x4 = (120 - textWidth3) / 2;
		
		// Minage
		fontRenderer.drawStringWithShadow(ms, text1, 82 + x1, 74, 0xFFFFFF);
		fontRenderer.drawStringWithShadow(ms, Text2, 82 + x1, 117, 0xFFFFFF);
		fontRenderer.drawStringWithShadow(ms, text3, 82 + x1, 158, 0xFFFFFF);
		// Faction
		fontRenderer.drawStringWithShadow(ms, text4, 226 + x2, 74, 0xFFFFFF);
		fontRenderer.drawStringWithShadow(ms, text5, 226 + x3, 117, 0xFFFFFF);
		fontRenderer.drawStringWithShadow(ms, text6, 226 + x4, 158, 0xFFFFFF);
		}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}
	/* 
		Explanation of ImageButton parameters:
		ImageButton(PosX, PosY, WidthImg, HeightImg, nbPixelImageX, nbPixelImageY, SautEnPixelImageSurvol , IMAGE LOCATION, Action)
		PosX = position of the button starting from the left of the GUI
		PosY = position of the button starting from the top of the GUI
		WidthImg = image width
		HeightImg = image height
		nbPixelImageX = offset in x of the origin of the image
		nbPixelImageY = offset in y of the origin of the image
		SautEnPixelImageSurvol = hover image y offset
		IMAGE LOCATION = location of the image (see point 4)
		Action = action when button is clicked
	*/

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new ImageButton(this.guiLeft + 48, this.guiTop + 62, 32, 32, 0 /*decalage pixel*/, 0, 32, MYIMAGE, e -> {
	         if(true) {
	                EriniumMod.PACKET_HANDLER.sendToServer(new MaintenanceGui.ButtonPressedMessage(0, x, y, z));
	                MaintenanceGui.handleButtonAction(entity, 0, x, y, z); } // button action = 0
	         ((ImageButton)e).setPosition(this.guiLeft + 48, this.guiTop + 62);
	      }));
		this.addButton(new ImageButton(this.guiLeft + 48, this.guiTop + 104, 32, 32, 0 /*decalage pixel*/, 0, 32, MYIMAGE, e -> {
	         if(true) {
	                EriniumMod.PACKET_HANDLER.sendToServer(new MaintenanceGui.ButtonPressedMessage(1, x, y, z));
	                MaintenanceGui.handleButtonAction(entity, 1, x, y, z); } // button action = 0
	         ((ImageButton)e).setPosition(this.guiLeft + 48, this.guiTop + 104);
	      }));
		this.addButton(new ImageButton(this.guiLeft + 48, this.guiTop + 146, 32, 32, 0 /*decalage pixel*/, 0, 32, MYIMAGE, e -> {
	         if(true) {
	                EriniumMod.PACKET_HANDLER.sendToServer(new MaintenanceGui.ButtonPressedMessage(2, x, y, z));
	                MaintenanceGui.handleButtonAction(entity, 2, x, y, z); } // button action = 0
	         ((ImageButton)e).setPosition(this.guiLeft + 48, this.guiTop + 146);
	      }));
	      this.addButton(new ImageButton(this.guiLeft + 348, this.guiTop + 62, 32, 32, 0 /*decalage pixel*/, 0, 32, MYIMAGE, e -> {
	         if(true) {
	                EriniumMod.PACKET_HANDLER.sendToServer(new MaintenanceGui.ButtonPressedMessage(3, x, y, z));
	                MaintenanceGui.handleButtonAction(entity, 3, x, y, z); } // button action = 0
	         ((ImageButton)e).setPosition(this.guiLeft + 348, this.guiTop + 62);
	      }));
	      this.addButton(new ImageButton(this.guiLeft + 348, this.guiTop + 104, 32, 32, 0 /*decalage pixel*/, 0, 32, MYIMAGE, e -> {
	         if(true) {
	                EriniumMod.PACKET_HANDLER.sendToServer(new MaintenanceGui.ButtonPressedMessage(4, x, y, z));
	                MaintenanceGui.handleButtonAction(entity, 4, x, y, z); } // button action = 0
	         ((ImageButton)e).setPosition(this.guiLeft + 348, this.guiTop + 104);
	      }));
	      this.addButton(new ImageButton(this.guiLeft + 348, this.guiTop + 146, 32, 32, 0 /*decalage pixel*/, 0, 32, MYIMAGE, e -> {
	         if(true) {
	                EriniumMod.PACKET_HANDLER.sendToServer(new MaintenanceGui.ButtonPressedMessage(5, x, y, z));
	                MaintenanceGui.handleButtonAction(entity, 5, x, y, z); } // button action = 0
	         ((ImageButton)e).setPosition(this.guiLeft + 348, this.guiTop + 146);
	      }));
	}
}
