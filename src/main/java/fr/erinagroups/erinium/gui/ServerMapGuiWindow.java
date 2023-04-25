
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
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.item.ItemStack;

import java.util.HashMap;

import fr.erinagroups.erinium.EriniumMod;

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
import io.netty.util.internal.MathUtil;

@OnlyIn(Dist.CLIENT)
public class ServerMapGuiWindow extends ContainerScreen<ServerMapGui.GuiContainerMod>{
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ServerMapGui.guistate;

	public ServerMapGuiWindow(ServerMapGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 427;
		this.ySize = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/server_map.png");
	private static final ResourceLocation ALPHABTN = new ResourceLocation("erinium:textures/screens/alpha_btn.png");
	private static final ResourceLocation BETABTN = new ResourceLocation("erinium:textures/screens/beta_btn.png");
	private static final ResourceLocation CHARLIEBTN = new ResourceLocation("erinium:textures/screens/charlie_btn.png");
	private static final ResourceLocation MINAGE01BTN = new ResourceLocation("erinium:textures/screens/minage01_btn.png");
	private static final ResourceLocation MINAGE02BTN = new ResourceLocation("erinium:textures/screens/minage02_btn.png");
	private static final ResourceLocation MINAGE03BTN = new ResourceLocation("erinium:textures/screens/minage03_btn.png");

	private String tooltipText = "";

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);

		if (isMouseOverAlpha(mouseX, mouseY)) {
		    tooltipText = "§1Serveur §lAlpha";
		} else if(isMouseOverBeta(mouseX, mouseY)){
			tooltipText = "§aServeur §lBeta";
		}else if(isMouseOverCharlie(mouseX, mouseY)){
			tooltipText = "§eServeur §lCharlie";
		}else if(isMouseOverMinage01(mouseX, mouseY)){
			tooltipText = "§6Serveur §lMinage01";
		}else if(isMouseOverMinage02(mouseX, mouseY)){
			tooltipText = "§4Serveur §lMinage02";
		}else if(isMouseOverMinage03(mouseX, mouseY)){
			tooltipText = "§5Serveur §lMinage03";
		}else {
		    tooltipText = "";
			}
		if (!tooltipText.isEmpty()) {
		    renderTooltip(ms, new StringTextComponent(tooltipText), mouseX, mouseY);
		}


	}

	private boolean isMouseOverAlpha(int mouseX, int mouseY) {
	    return mouseX >= this.guiLeft + 28 && mouseY >= this.guiTop + 157 && mouseX < this.guiLeft + 92 && mouseY < this.guiTop + 221;
	}
	private boolean isMouseOverBeta(int mouseX, int mouseY) {
	    return mouseX >= this.guiLeft + 34 && mouseY >= this.guiTop + 7 && mouseX < this.guiLeft + 98 && mouseY < this.guiTop + 71;
	}
	private boolean isMouseOverCharlie(int mouseX, int mouseY) {
	    return mouseX >= this.guiLeft + 141 && mouseY >= this.guiTop + 115 && mouseX < this.guiLeft + 205 && mouseY < this.guiTop + 179;
	}
	private boolean isMouseOverMinage01(int mouseX, int mouseY) {
	    return mouseX >= this.guiLeft + 224 && mouseY >= this.guiTop + 30 && mouseX < this.guiLeft + 288 && mouseY < this.guiTop + 94;
	}
	private boolean isMouseOverMinage02(int mouseX, int mouseY) {
	    return mouseX >= this.guiLeft + 337 && mouseY >= this.guiTop + 60 && mouseX < this.guiLeft + 401 && mouseY < this.guiTop + 124;
	}
	private boolean isMouseOverMinage03(int mouseX, int mouseY) {
	    return mouseX >= this.guiLeft + 292 && mouseY >= this.guiTop + 157 && mouseX < this.guiLeft + 356 && mouseY < this.guiTop + 221;
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/background.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 427, 240, 427, 240);

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
		ItemStack stack;
		/*if(MathUtil.isMouseIntoSquare(this.guiLeft + 28, this.guiTop + 157, 64, 64, mouseX, mouseY)) {
            this.renderTooltip(stack, new StringTextComponent("Test"), mouseX, mouseY);

        }*/
        
	
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new ImageButton(this.guiLeft + 28, this.guiTop + 157, 64, 64, 0 /*decalage pixel*/, 0, 64, ALPHABTN, e -> {
			if(true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ServerMapGui.ButtonPressedMessage(0, x, y, z));
				ServerMapGui.handleButtonAction(entity, 0, x, y, z); } // button action = 0
			((ImageButton)e).setPosition(this.guiLeft + 28, this.guiTop + 157);
		}));
		this.addButton(new ImageButton(this.guiLeft + 34, this.guiTop + 7, 64, 64, 0 /*decalage pixel*/, 0, 64, BETABTN, e -> {
			if(true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ServerMapGui.ButtonPressedMessage(1, x, y, z));
				ServerMapGui.handleButtonAction(entity, 1, x, y, z); } // button action = 0
			((ImageButton)e).setPosition(this.guiLeft + 34, this.guiTop + 7);
		}));
		this.addButton(new ImageButton(this.guiLeft + 141, this.guiTop + 115, 64, 64, 0 /*decalage pixel*/, 0, 64, CHARLIEBTN, e -> {
			if(true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ServerMapGui.ButtonPressedMessage(2, x, y, z));
				ServerMapGui.handleButtonAction(entity, 2, x, y, z); } // button action = 0
			((ImageButton)e).setPosition(this.guiLeft + 141, this.guiTop + 115);
		}));
		this.addButton(new ImageButton(this.guiLeft + 224, this.guiTop + 30, 64, 64, 0 /*decalage pixel*/, 0, 64, MINAGE01BTN, e -> {
			if(true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ServerMapGui.ButtonPressedMessage(3, x, y, z));
				ServerMapGui.handleButtonAction(entity, 3, x, y, z); } // button action = 0
			((ImageButton)e).setPosition(this.guiLeft + 224, this.guiTop + 30);
		}));
		this.addButton(new ImageButton(this.guiLeft + 337, this.guiTop + 60, 64, 64, 0 /*decalage pixel*/, 0, 64, MINAGE02BTN, e -> {
			if(true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ServerMapGui.ButtonPressedMessage(4, x, y, z));
				ServerMapGui.handleButtonAction(entity, 4, x, y, z); } // button action = 0
			((ImageButton)e).setPosition(this.guiLeft + 337, this.guiTop + 60);
		}));
		this.addButton(new ImageButton(this.guiLeft + 292, this.guiTop + 157, 64, 64, 0 /*decalage pixel*/, 0, 64, MINAGE03BTN, e -> {
			if(true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ServerMapGui.ButtonPressedMessage(5, x, y, z));
				ServerMapGui.handleButtonAction(entity, 5, x, y, z); } // button action = 0
			((ImageButton)e).setPosition(this.guiLeft + 292, this.guiTop + 157);
		}));
	}
}
