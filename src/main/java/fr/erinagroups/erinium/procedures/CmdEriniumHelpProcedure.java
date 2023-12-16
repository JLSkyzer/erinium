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

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CmdEriniumHelpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("FR")) {
			if (DoubleArgumentType.getDouble(arguments, "page") == 1) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/alchemistsell" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/alchemistsell\"}},{\"text\":\" "
							+ "Vend toutes vos bouteilles d'amenine pour gagner de l'xp" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit\"}},{\"text\":\" " + "Pour connaitre votre cr\u00E9dit"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit-to-ftb-money"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit-to-ftb-money <amount>\"}},{\"text\":\" "
							+ "Converti votre cr\u00E9dit en money du mod FTB money" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credittomoney"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credittomoney\"}},{\"text\":\" "
							+ "Converti votre cr\u00E9dit en money du plugin essentialsX si il est activer sur le serveur" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/wiki"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/wiki\"}},{\"text\":\" " + "Donne le lien du wiki d'erinium"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 1"
							+ "\"}},{\"text\":\" " + "Page 1" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 2"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 2) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/getdim" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/getdim\"}},{\"text\":\" " + "Pour connaitre la dimension ou vous \u00EAtes"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/gohome"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/gohome\"}},{\"text\":\" "
							+ "Pour vous t\u00E9l\u00E9porter au spawn ou a l'endroit ou vous avez mis votre block de home" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/nether"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/nether\"}},{\"text\":\" " + "Pour vous t\u00E9l\u00E9porter au nether"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/map"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/map\"}},{\"text\":\" " + "Pour ouvrir la map pour changer de serveur !"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/profile"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/profile\"}},{\"text\":\" "
							+ "Ouvre le menu de profile ou vous pouvez trouvez quelques informations personnel comme le serveur, le rank, etc.."
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 1"
							+ "\"}},{\"text\":\" " + "Page 2" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 3"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 3) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/rank" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/rank\"}},{\"text\":\" " + "Ouvre le menu de rank"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/rankoverlaysettings"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/rankoverlaysettings\"}},{\"text\":\" "
							+ "Change les param\u00E8tres de l'overlay quand vous gagnez de l'xp" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/rtpdim"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/rtpdim\"}},{\"text\":\" "
							+ "Vous t\u00E9l\u00E9porte \u00E0 un endoit al\u00E9atoire dans le map si la commande est activ\u00E9e sur le serveur "
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/serverlanguage"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/serverlanguage <FR/EN>\"}},{\"text\":\" "
							+ "Pour changer la langue du serveur, les messages que le mod vous enverra sera traduit par la langue choisi" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/maintenance" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/maintenance\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bOuvre le menu de maintenance"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 2"
							+ "\"}},{\"text\":\" " + "Page 3" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 4"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 4) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/nethermaintenance" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/nethermaintenance\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bOuvre le menu de maintenance pour le nether" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/setnetherspawn"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/setnetherspawn\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bPour changer le spawn du nether"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/toggleessential"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/toggleessential\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bActive la relation avec le plugin EssentialsX si il est activer" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/enablecustomchat"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/enablecustomchat <FR/EN>\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bActive le chat custom"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/EriniumRank"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/EriniumRank\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bChange les valeurs du rank d'un joueur selon les param\u00E8tres"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 3"
							+ "\"}},{\"text\":\" " + "Page 4" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 5"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 5) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/eriniumreloadvariables" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/eriniumreloadvariables\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bMet \u00E0 jour les variables si vous avez modifier le config.json dans le dossier de config Erinium"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/listplayer"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/listplayer\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bDonne la liste des joueurs dans diff\u00E9rents serveurs" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/reloadmaxplayer"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/reloadmaxplayer\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bModifie le nombre de joueurs maximum par serveurs apr\u00E8s avoir modifier le fichier de config erinium"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/enablecustomchat"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/enablecustomchat\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bActive le chat custom"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/setserverspawn"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/setserverspawn\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bChange le point de spawn pour les serveurs (alpha, beta, charlie, minage01, minage02, minage03)"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 4"
							+ "\"}},{\"text\":\" " + "Page 5" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 6"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 6) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/swapserver" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/swapserver\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bPermet de changer de serveurs sans la contrainte de la maintenance ou du nombre de joueurs"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/togglemoddedfeatures"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/togglemoddedfeatures\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bActives les items/blocks r\u00E9server a la partie minecraft modd\u00E9" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/debugitem"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/debugitem\"}},{\"text\":\" "
							+ "\u00A74OP \u00A7bPermet d'avoir des informations de l'item dans la main" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/eriniumgemme"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/eriniumgemme\"}},{\"text\":\" " + "\u00A74OP \u00A7bPermet de modifier le nombre de gemme d'un joueur"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/AucuneCommande"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/nothing\"}},{\"text\":\" " + "Y a rien ici parce que askip y a rien"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 5"
							+ "\"}},{\"text\":\" " + "Page 6" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 6"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/alchemistsell" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/alchemistsell\"}},{\"text\":\" "
							+ "Vend toutes vos bouteilles d'amenine pour gagner de l'xp" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit\"}},{\"text\":\" " + "Pour connaitre votre cr\u00E9dit"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit-to-ftb-money"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit-to-ftb-money <amount>\"}},{\"text\":\" "
							+ "Converti votre cr\u00E9dit en money du mod FTB money" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credittomoney"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credittomoney\"}},{\"text\":\" "
							+ "Converti votre cr\u00E9dit en money du plugin essentialsX si il est activer sur le serveur" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/wiki"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/wiki\"}},{\"text\":\" " + "Donne le lien du wiki d'erinium"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 1"
							+ "\"}},{\"text\":\" " + "Page 1" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 2"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			}
		} else if (((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).serverLanguage).equals("EN")) {
			if (DoubleArgumentType.getDouble(arguments, "page") == 1) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/alchemistsell" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/alchemistsell\"}},{\"text\":\" "
							+ "Sell \u200B\u200Ball your bottles of amenine to earn xp" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit\"}},{\"text\":\" " + "To know your credit"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit-to-ftb-money"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit-to-ftb-money <amount>\"}},{\"text\":\" " + "Convert your credit into FTB money mod money"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credittomoney"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credittomoney\"}},{\"text\":\" "
							+ "Convert your credit into essentialsX plugin currency if activated on the server" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/wiki"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/wiki\"}},{\"text\":\" " + "Give the link of the erinium wiki"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 1"
							+ "\"}},{\"text\":\" " + "Page 1" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 2"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 2) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/getdim" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/getdim\"}},{\"text\":\" " + "To know the size where you are"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/gohome"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/gohome\"}},{\"text\":\" " + "To teleport to the spawn or where you put your home block"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/nether"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/nether\"}},{\"text\":\" " + "To teleport you to the nether"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/map"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/map\"}},{\"text\":\" " + "To open the map to change server!"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/profile"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/profile\"}},{\"text\":\" "
							+ "Opens the profile menu where you can find some personal information like server, rank, etc."
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 1"
							+ "\"}},{\"text\":\" " + "Page 2" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 3"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 3) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/rank" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/rank\"}},{\"text\":\" " + "Open the rank menu"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/rankoverlaysettings"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/rankoverlaysettings\"}},{\"text\":\" " + "Change overlay settings when gaining xp"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/rtpdim"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/rtpdim\"}},{\"text\":\" "
							+ "Teleports you to a random place in the map if the command is activated on the server" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/serverlanguage"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/serverlanguage <FR/EN>\"}},{\"text\":\" "
							+ "To change the language of the server, the messages that the mod will send you will be translated by the chosen language"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/maintenance"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/maintenance\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bOpens the maintenance menu"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 2"
							+ "\"}},{\"text\":\" " + "Page 3" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 4"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 4) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/nethermaintenance" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/nethermaintenance\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bOpens the maintenance menu for the nether" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/setnetherspawn"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/setnetherspawn\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bTo change the nether spawn"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/toggleessential"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/toggleessential\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bActivates the relationship with the EssentialsX plugin if it is activated" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/enablecustomchat" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/enablecustomchat <FR/EN>\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bEnable custom chat" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/EriniumRank"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/EriniumRank\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bChange a player's rank values \u200B\u200Baccording to settings"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 3"
							+ "\"}},{\"text\":\" " + "Page 4" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 5"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 5) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/eriniumreloadvariables" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/eriniumreloadvariables\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bUpdate variables if you have modified the config.json in the Erinium config folder" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/listplayer" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/listplayer\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bGives the list of players in different servers" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/reloadmaxplayer"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/reloadmaxplayer\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bModifies the maximum number of players per server after modifying the erinium config file"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/enablecustomchat"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/enablecustomchat <FR/EN>\"}},{\"text\":\" " + "\u00A74ADMIN \u00A7bEnable custom chat"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/setserverspawn"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/setserverspawn\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bChange spawn point for servers (alpha, beta, charlie, minage01, minage02, minage03)"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 4"
							+ "\"}},{\"text\":\" " + "Page 5" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 6"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else if (DoubleArgumentType.getDouble(arguments, "page") == 6) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/swapserver" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/swapserver\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bAllows you to change servers without the constraint of maintenance or the number of players"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/togglemoddedfeatures"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/togglemoddedfeatures\"}},{\"text\":\" "
							+ "\u00A74ADMIN \u00A7bActivate the items/blocks reserved for the modded minecraft part" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/debugitem"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/debugitem\"}},{\"text\":\" " + "\u00A74OP \u00A7bAllows to have item information in hand"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/eriniumgemme"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/eriniumgemme\"}},{\"text\":\" "
							+ "\u00A74OP \u00A7bAllows you to modify the number of gems of a player" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/AucuneCommande"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/nothing\"}},{\"text\":\" " + "There is nothing here because askip there is nothing"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 5"
							+ "\"}},{\"text\":\" " + "Page 6" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 6"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tellraw "
							+ entity.getDisplayName().getString()
							+ " [\"\",{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\" Erinium Help \",\"bold\":true,\"color\":\"#BB0410\"},{\"text\":\"==========\",\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\""
							+ "/alchemistsell" + "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/alchemistsell\"}},{\"text\":\" "
							+ "Sell \u200B\u200Ball your bottles of amenine to earn xp" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit\"}},{\"text\":\" " + "To know your credit"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credit-to-ftb-money"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credit-to-ftb-money <amount>\"}},{\"text\":\" " + "Convert your credit into FTB money mod money"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/credittomoney"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/credittomoney\"}},{\"text\":\" "
							+ "Convert your credit into essentialsX plugin currency if activated on the server" + "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"-\",\"color\":\"gold\"},{\"text\":\" \"},{\"text\":\"" + "/wiki"
							+ "\",\"bold\":true,\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/wiki\"}},{\"text\":\" " + "Give the link of the erinium wiki"
							+ "\",\"color\":\"aqua\"},{\"text\":\"\\n\"},{\"text\":\"========== \",\"color\":\"yellow\"},{\"text\":\"<<\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 1"
							+ "\"}},{\"text\":\" " + "Page 1" + "\",\"color\":\"green\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\">>\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + "/eriniumhelp 2"
							+ "\"}},{\"text\":\" ==========\",\"color\":\"yellow\"}]"));
			}
		}
	}
}
