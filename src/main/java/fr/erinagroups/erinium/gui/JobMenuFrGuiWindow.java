
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

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class JobMenuFrGuiWindow extends ContainerScreen<JobMenuFrGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = JobMenuFrGui.guistate;

	public JobMenuFrGuiWindow(JobMenuFrGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 350;
		this.ySize = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/job_menu_fr.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/job_menu.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 350, 220, 350, 220);

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
		this.font.drawString(ms, "Farmer", 71, 0, -6750208);
		this.font.drawString(ms, "\u00A7cNiveau: \u00A7a" + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).lvlFarmer) + "", 17, 18, -1);
		this.font.drawString(ms, "\u00A7cXp: \u00A7a" + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).xpFarmer) + " / 50 000", 17, 36, -1);
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
		this.addButton(new Button(this.guiLeft + 53, this.guiTop + 54, 72, 20, new StringTextComponent("§bComment xp?"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new JobMenuFrGui.ButtonPressedMessage(0, x, y, z));
				JobMenuFrGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 53, this.guiTop + 72, 72, 20, new StringTextComponent("§bCraft"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new JobMenuFrGui.ButtonPressedMessage(1, x, y, z));
				JobMenuFrGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -18, this.guiTop + 0, 18, 20, new StringTextComponent("X"), e -> {
			if (true) {
				EriniumMod.PACKET_HANDLER.sendToServer(new JobMenuFrGui.ButtonPressedMessage(2, x, y, z));
				JobMenuFrGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
