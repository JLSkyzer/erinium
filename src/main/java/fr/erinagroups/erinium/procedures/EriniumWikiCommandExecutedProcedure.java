package fr.erinagroups.erinium.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class EriniumWikiCommandExecutedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("/tellraw "
					+ entity.getDisplayName().getString() + " " + "[\"\",{\"text\":\"\u00A7b\u00A7n> Erinium Wiki <\",\"underlined\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://jlskyzer-home.netlify.app/wiki/\"}}]"));
	}
}
