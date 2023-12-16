package fr.erinagroups.erinium.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class EmojiList1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + "@a" + (" [{\"text\":\"" + "\u00A7a===== \u00A73Liste des emojis \u00A7a=====" + "\"}]")));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + "@a" + (" [{\"text\":\"" + "\u00A7b- \u00A7e:erinium: = \u00A7f\\uE001" + "\"}]")));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + "@a" + (" [{\"text\":\"" + "\u00A7b- \u00A7e:Membre: = \u00A7f\\uE002\\uF801\\uE003\\uF801\\uE004\\uF801\\uE005" + "\"}]")));
		} else if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + "@a" + (" [{\"text\":\"" + "\u00A7a===== \u00A73Emoji list \u00A7a=====" + "\"}]")));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + "@a" + (" [{\"text\":\"" + "\u00A7b- \u00A7e:erinium: = \u00A7f\\uE001" + "\"}]")));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + "@a" + (" [{\"text\":\"" + "\u00A7b- \u00A7e:Membre: = \u00A7f\\uE002\\uF801\\uE003\\uF801\\uE004\\uF801\\uE005" + "\"}]")));
		}
	}
}
