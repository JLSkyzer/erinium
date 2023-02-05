
package fr.erinagroups.erinium.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Channels;

import java.net.URL;

import java.io.FileOutputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import fr.erinagroups.erinium.EriniumModVariables;
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
import com.sk89q.worldedit.entity.Player;
import net.minecraftforge.server.permission.context.PlayerContext;

@OnlyIn(Dist.CLIENT)
public class ProfileMenuMainGuiWindow extends ContainerScreen<ProfileMenuMainGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ProfileMenuMainGui.guistate;
	private String PUUID = "";
	
	public ProfileMenuMainGuiWindow(ProfileMenuMainGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 427;
		this.ySize = 240;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/profile_menu_main.png");
	private static final ResourceLocation HOMEBTN = new ResourceLocation("erinium:textures/screens/home_button.png");
	private static final ResourceLocation RANKBTN = new ResourceLocation("erinium:textures/screens/rank_button.png");
	private static final ResourceLocation STATSBTN = new ResourceLocation("erinium:textures/screens/stats_button.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/main_menu_background.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 427, 240, 427, 240);

		PUUID = ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerUUID);
		/*PUUID = "9cc97115-8d4a-4133-b2fb-5c849ff93b8c";*/
		
		this.minecraft.getTextureManager().bindTexture(this.minecraft.player.connection.getPlayerInfo(UUID.fromString(PUUID)).getLocationSkin());
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 67, 67, 8, 8, 8, 8, 64, 64);
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
		this.font.drawString(ms, "Bienvenue : \u00A7e" + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).PlayerName) + "", 69, 4, -13382656);
		this.font.drawString(ms, "Serveur : \u00A7e" + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EriniumModVariables.PlayerVariables())).GetCurrentServer) + "", 69, 20, -1);
		this.font.drawString(ms,
				"Joueurs Connect\u00E9 : \u00A7e"
						+ (int) ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).GetCurrentServerPlayerCount)
						+ " / " + (int) (EriniumModVariables.MapVariables.get(world).MaxPlayerPerServer) + "",
				69, 35, -1);
		this.font.drawString(ms, "", 202, 79, -12829636);
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
		this.addButton(new ImageButton(this.guiLeft + 2, this.guiTop + 72, 108, 20, 0 /*decalage pixel*/, 0, 20, HOMEBTN, e -> {
         if(true) {
                EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuMainGui.ButtonPressedMessage(0, x, y, z));
				ProfileMenuMainGui.handleButtonAction(entity, 0, x, y, z); // button action = 0
         }
         	((ImageButton)e).setPosition(this.guiLeft + 2, this.guiTop + 72);
      	}));
		this.addButton(new ImageButton(this.guiLeft + 2, this.guiTop + 94, 108, 20, 0 /*decalage pixel*/, 0, 20, RANKBTN, e -> {
         if(true) {
                EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuMainGui.ButtonPressedMessage(1, x, y, z));
				ProfileMenuMainGui.handleButtonAction(entity, 1, x, y, z); // button action = 0
         }
         	((ImageButton)e).setPosition(this.guiLeft + 2, this.guiTop + 94);
      	}));
		this.addButton(new ImageButton(this.guiLeft + 2, this.guiTop + 116, 108, 20, 0 /*decalage pixel*/, 0, 20, STATSBTN, e -> {
         if(true) {
                EriniumMod.PACKET_HANDLER.sendToServer(new ProfileMenuMainGui.ButtonPressedMessage(2, x, y, z));
				ProfileMenuMainGui.handleButtonAction(entity, 2, x, y, z); // button action = 0
         }
         	((ImageButton)e).setPosition(this.guiLeft + 2, this.guiTop + 116);
      	}));
	}
}
