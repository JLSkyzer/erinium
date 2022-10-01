
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ChangeWonXpOverlayGuiWindow extends ContainerScreen<ChangeWonXpOverlayGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ChangeWonXpOverlayGui.guistate;
	TextFieldWidget inputX;
	TextFieldWidget inputY;

	public ChangeWonXpOverlayGuiWindow(ChangeWonXpOverlayGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/change_won_xp_overlay.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		inputX.render(ms, mouseX, mouseY, partialTicks);
		inputY.render(ms, mouseX, mouseY, partialTicks);
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
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (inputX.isFocused())
			return inputX.keyPressed(key, b, c);
		if (inputY.isFocused())
			return inputY.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		inputX.tick();
		inputY.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "x : " + (int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).rank_overlay_x) + "", 6, 16, -3407872);
		this.font.drawString(ms, "y : " + (int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).rank_overlay_y) + "", 6, 61, -3407872);
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
		inputX = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 34, 90, 20, new StringTextComponent(""));
		guistate.put("text:inputX", inputX);
		inputX.setMaxStringLength(32767);
		this.children.add(this.inputX);
		inputY = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 79, 90, 20, new StringTextComponent(""));
		guistate.put("text:inputY", inputY);
		inputY.setMaxStringLength(32767);
		this.children.add(this.inputY);
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 34, 45, 20, new StringTextComponent("Set X"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ChangeWonXpOverlayGui.ButtonPressedMessage(0, x, y, z));
				ChangeWonXpOverlayGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 79, 45, 20, new StringTextComponent("Set Y"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ChangeWonXpOverlayGui.ButtonPressedMessage(1, x, y, z));
				ChangeWonXpOverlayGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 133, 54, 20, new StringTextComponent("Test"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new ChangeWonXpOverlayGui.ButtonPressedMessage(2, x, y, z));
				ChangeWonXpOverlayGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
