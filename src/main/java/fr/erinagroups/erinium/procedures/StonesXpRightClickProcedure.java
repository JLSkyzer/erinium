package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.Calendar;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class StonesXpRightClickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double random = 0;
		if (itemstack.getOrCreateTag().getBoolean("used") == false) {
			random = Mth.nextInt(RandomSource.create(), 1000, 10000);
			{
				double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp + random;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerXp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "\u00A7a+" + Math.round(random) + " xp ";
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.won_xp_message = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = new java.text.DecimalFormat("### ###").format((entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).playerXp) + " / \u00A74100 000";
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.won_xp_message_2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 60;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.won_xp_overlay_cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			itemstack.getOrCreateTag().putBoolean("used", true);
			if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1 == 1) {
				itemstack.getOrCreateTag().putDouble("month", (Calendar.getInstance().get(Calendar.MONTH) + 1));
			} else {
				itemstack.getOrCreateTag().putDouble("month", Calendar.getInstance().get(Calendar.MONTH));
			}
			if (itemstack.getOrCreateTag().getDouble("month") == 1) {
				itemstack.getOrCreateTag().putDouble("year", (Calendar.getInstance().get(Calendar.YEAR) + 1));
			} else {
				itemstack.getOrCreateTag().putDouble("year", Calendar.getInstance().get(Calendar.YEAR));
			}
			itemstack.getOrCreateTag().putDouble("day", (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1));
			itemstack.getOrCreateTag().putDouble("hour", Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
			itemstack.getOrCreateTag().putDouble("minute", Calendar.getInstance().get(Calendar.MINUTE));
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cYou can't use this item for the moment, \u00A7bsee the cooldown in the item's lore"), false);
		}
	}
}
