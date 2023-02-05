package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Channels;

import java.net.URL;

import java.io.FileOutputStream;

import fr.erinagroups.erinium.EriniumMod;

import com.github.hexomod.worldeditcuife3.e;

public class DownloadFileProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure DownloadFile!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			try {
				URL url = new URL(("https://minotar.net/avatar/" + entity.getDisplayName().getString() + "/100.png"));
				ReadableByteChannel rbc = Channels.newChannel(url.openStream());
				FileOutputStream fos = new FileOutputStream((FMLPaths.GAMEDIR.get().toString() + "/skins/skin.png"));
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
				rbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
