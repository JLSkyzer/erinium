
package fr.erinagroups.erinium.client.screens;

import fr.erinagroups.erinium.procedures.RankOverlayCooldownProcedure;
import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;

import fr.erinagroups.erinium.procedures.WonXpMessageProcedure;
import fr.erinagroups.erinium.procedures.WonXpMessage2Procedure;
import fr.erinagroups.erinium.procedures.RankXpOverlayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class RankXpOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);

		Font fontrender;
		fontrender = Minecraft.getInstance().font;

		String message1 = WonXpMessageProcedure.execute(entity);
		String message2 = WonXpMessage2Procedure.execute(entity);

		int x1 = (120 - fontrender.width(message1)) / 2;
		int x2 = (120 - fontrender.width(message2)) / 2;

		double bar = (120 / 60) * RankOverlayCooldownProcedure.execute(entity);

		if (RankXpOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("erinium:textures/screens/won_xp_overlay_screen.png"), posX + 72, posY + -98, 0, 0, 120, 40, 120, 40);

			event.getGuiGraphics().blit(new ResourceLocation("erinium:textures/screens/barre_3_seconds.png"), posX + 72, posY + -58, 0, 0, (int) bar, 4, 120, 4);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					WonXpMessageProcedure.execute(entity), posX + 72 + x1, posY + -92, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					WonXpMessage2Procedure.execute(entity), posX + 72 + x2, posY + -74, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
