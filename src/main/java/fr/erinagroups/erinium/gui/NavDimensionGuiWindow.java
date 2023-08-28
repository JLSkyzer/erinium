
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

import java.util.HashMap;

import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NavDimensionGuiWindow extends ContainerScreen<NavDimensionGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = NavDimensionGui.guistate;

	public NavDimensionGuiWindow(NavDimensionGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 186;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/nav_dimension.png");

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
		this.font.drawString(ms, "Dimensions Navigation", 33, 8, -16777216);
		this.font.drawString(ms, "Rank Level : ", 51, 17, -16751104);
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
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 35, 90, 20, new StringTextComponent("0"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new NavDimensionGui.ButtonPressedMessage(0, x, y, z));
				NavDimensionGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 62, 90, 20, new StringTextComponent("5"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new NavDimensionGui.ButtonPressedMessage(1, x, y, z));
				NavDimensionGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 89, 90, 20, new StringTextComponent("10"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new NavDimensionGui.ButtonPressedMessage(2, x, y, z));
				NavDimensionGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 116, 90, 20, new StringTextComponent("15"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new NavDimensionGui.ButtonPressedMessage(3, x, y, z));
				NavDimensionGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 143, 90, 20, new StringTextComponent("20"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new NavDimensionGui.ButtonPressedMessage(4, x, y, z));
				NavDimensionGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}