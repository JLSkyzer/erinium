
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import fr.erinagroups.erinium.network.SpaceupdateOverlayKeyMessage;
import fr.erinagroups.erinium.EriniumMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EriniumModKeyMappings {
	public static final KeyMapping SPACEUPDATE_OVERLAY_KEY = new KeyMapping("key.erinium.spaceupdate_overlay_key", GLFW.GLFW_KEY_K, "key.categories.eriniumcontrols") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EriniumMod.PACKET_HANDLER.sendToServer(new SpaceupdateOverlayKeyMessage(0, 0));
				SpaceupdateOverlayKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SPACEUPDATE_OVERLAY_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SPACEUPDATE_OVERLAY_KEY.consumeClick();
			}
		}
	}
}
