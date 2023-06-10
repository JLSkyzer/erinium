
package fr.erinagroups.erinium.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import java.util.HashMap;

import fr.erinagroups.erinium.EriniumModVariables;
import fr.erinagroups.erinium.EriniumMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import java.text.DecimalFormat;

@OnlyIn(Dist.CLIENT)
public class ProfileMenuRankGuiWindow extends ContainerScreen<ProfileMenuRankGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ProfileMenuRankGui.guistate;

	public ProfileMenuRankGuiWindow(ProfileMenuRankGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 427;
		this.ySize = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/profile_menu_rank.png");
	private static final ResourceLocation HOMEBTN = new ResourceLocation("erinium:textures/screens/home_button.png");
	private static final ResourceLocation RANKBTN = new ResourceLocation("erinium:textures/screens/rank_button.png");
	private static final ResourceLocation STATSBTN = new ResourceLocation("erinium:textures/screens/stats_button.png");
	private FontRenderer fontRenderer;

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

		TileEntity tileEntity = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
		double barre = (248 / ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).cap_xp)) * ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/rank_background.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 427, 240, 427, 240);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/rank_bar_empty.png"));
		this.blit(ms, this.guiLeft + 88, this.guiTop + 140, 0, 0, 250, 6, 250, 6);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/rank_bar_fill.png"));
		this.blit(ms, this.guiLeft + 89, this.guiTop + 141, 0, 0, (int) barre, 4, 248, 4);

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
		this.fontRenderer = Minecraft.getInstance().fontRenderer;
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		String textlevel = "Level : \u00A7a" + decimalFormat.format((int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerLvl)) + "";
		String textxp = "Xp : \u00A7a" + decimalFormat.format((int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerXp)) + " \u00A7r/ \u00A7e" + decimalFormat.format((int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).cap_xp));
		int levelwidth = fontRenderer.getStringWidth(textlevel);
		int x1 = (250 - levelwidth) / 2;
		int xpwidth = fontRenderer.getStringWidth(textxp);
		int x2 = (250 - xpwidth) / 2;
	
		fontRenderer.drawStringWithShadow(ms, textlevel, 88 + x1, 112, 0xFFFFFF);
		fontRenderer.drawStringWithShadow(ms, textxp, 88 + x2, 127, 0xFFFFFF);
		/*this.font.drawString(ms, "Level : \u00A7a" + (int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerLvl) + "", 180, 112, -1);
		this.font.drawString(ms, "Xp : \u00A7a" + (int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " \u00A7r/ \u00A7e" + (int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).cap_xp), 179, 127, -1);*/
		this.font.drawString(ms, "Rank", 198, 0, -1);
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
		this.addButton(new ImageButton(this.guiLeft + 2, this.guiTop + 175, 108, 20, 0 /*decalage pixel*/, 0, 20, HOMEBTN, e -> {
         if(true) {
                EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuRankGui.ButtonPressedMessage(0, x, y, z));
				ProfileMenuRankGui.handleButtonAction(entity, 0, x, y, z); // button action = 0
         }
         	((ImageButton)e).setPosition(this.guiLeft + 2, this.guiTop + 175);
      	}));
		this.addButton(new ImageButton(this.guiLeft + 2, this.guiTop + 197, 108, 20, 0 /*decalage pixel*/, 0, 20, RANKBTN, e -> {
         if(true) {
                EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuRankGui.ButtonPressedMessage(1, x, y, z));
				ProfileMenuRankGui.handleButtonAction(entity, 1, x, y, z); // button action = 0
         }
         	((ImageButton)e).setPosition(this.guiLeft + 2, this.guiTop + 197);
      	}));
		this.addButton(new ImageButton(this.guiLeft + 2, this.guiTop + 219, 108, 20, 0 /*decalage pixel*/, 0, 20, STATSBTN, e -> {
         if(true) {
                EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuRankGui.ButtonPressedMessage(2, x, y, z));
				ProfileMenuRankGui.handleButtonAction(entity, 2, x, y, z); // button action = 0
         }
         	((ImageButton)e).setPosition(this.guiLeft + 2, this.guiTop + 219);
      	}));
	}
}
