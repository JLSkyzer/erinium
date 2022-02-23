package fr.erinagroups.erinium.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import fr.erinagroups.erinium.EriniumMod;

public class TestsendmessageProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onChat(ServerChatEvent event) {
			ServerPlayerEntity entity = event.getPlayer();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("text", event.getMessage());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure Testsendmessage!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure Testsendmessage!");
			return;
		}
		if (dependencies.get("text") == null) {
			if (!dependencies.containsKey("text"))
				EriniumMod.LOGGER.warn("Failed to load dependency text for procedure Testsendmessage!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		String text = (String) dependencies.get("text");
		String temp = "";
		if (dependencies.get("event") != null) {
			Object _obj = dependencies.get("event");
			if (_obj instanceof Event) {
				Event _evt = (Event) _obj;
				if (_evt.isCancelable())
					_evt.setCanceled(true);
			}
		}
		temp = (text);
		temp = (temp.replace(":e:", "\uE001"));
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent((entity.getDisplayName().getString() + " : " + temp)), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
	}
}
