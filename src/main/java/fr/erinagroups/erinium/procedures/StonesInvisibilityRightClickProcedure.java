package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import java.util.Calendar;

public class StonesInvisibilityRightClickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("used") == false) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1, false, false));
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
