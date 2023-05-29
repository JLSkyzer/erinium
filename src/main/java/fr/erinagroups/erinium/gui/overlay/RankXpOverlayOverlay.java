
package fr.erinagroups.erinium.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import fr.erinagroups.erinium.procedures.RankXpOverlayDisplayOverlayIngameProcedure;
import fr.erinagroups.erinium.EriniumModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.text2speech.Text2Speech;

@Mod.EventBusSubscriber
public class RankXpOverlayOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;

			FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
			String text1 = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).won_xp_message));
			int text1Width = fontRenderer.getStringWidth(text1);
			int x1 = (120 - text1Width) / 2;
			String text2 = (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).won_xp_message_2));
			int text2Width = fontRenderer.getStringWidth(text2);
			int x2 = (120 - text2Width) / 2;
			
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (RankXpOverlayDisplayOverlayIngameProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {

				double screenX = posX + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).rank_overlay_x);
				double screenY = posY + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).rank_overlay_y);
				double barre = 2 * ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EriniumModVariables.PlayerVariables())).won_xp_overlay_cooldown);
					
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/won_xp_overlay_screen.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), (int) screenX, (int) screenY, 0, 0, 120, 40, 120, 40);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/barre_3_seconds.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), (int) screenX, (int) screenY + 40, 0, 0, (int) barre, 2, 120, 4);

				/*Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).won_xp_message) + "",
						(int) screenX + 2, (int) screenY + 2, -1);*/
				fontRenderer.drawStringWithShadow(event.getMatrixStack(), text1, (int) screenX + x1, (int) screenY + 10, 0xFFFFFF);
				fontRenderer.drawStringWithShadow(event.getMatrixStack(), text2, (int) screenX + x2, (int) screenY + 22, 0xFFFFFF);
				/*Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EriniumModVariables.PlayerVariables())).won_xp_message_2) + "",
						(int) screenX + 2, (int) screenY + 16, -1);*/
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
