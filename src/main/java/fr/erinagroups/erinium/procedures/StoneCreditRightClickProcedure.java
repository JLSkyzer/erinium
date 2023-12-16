package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.util.Calendar;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class StoneCreditRightClickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double random = 0;
		if (itemstack.getOrCreateTag().getBoolean("used") == false) {
			random = Mth.nextInt(RandomSource.create(), 500, 5000);
			{
				double _setval = (entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EriniumModVariables.PlayerVariables())).Credit + random;
				entity.getCapability(EriniumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Credit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A74[\u00A7cErinium \u00A7eCredit\u00A74] \u00A7a+" + Math.round(random) + " $")), false);
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
