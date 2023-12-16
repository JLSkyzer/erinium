package fr.erinagroups.erinium.procedures;

import net.minecraft.world.item.ItemStack;

import java.util.Calendar;

public class MagicStonesInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("used")) {
			if (Calendar.getInstance().get(Calendar.YEAR) > itemstack.getOrCreateTag().getDouble("year")) {
				itemstack.getOrCreateTag().putBoolean("used", false);
			} else {
				if (Calendar.getInstance().get(Calendar.MONTH) > itemstack.getOrCreateTag().getDouble("month")) {
					itemstack.getOrCreateTag().putBoolean("used", false);
				} else {
					if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) >= itemstack.getOrCreateTag().getDouble("day")) {
						if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= itemstack.getOrCreateTag().getDouble("hour")) {
							if (Calendar.getInstance().get(Calendar.MINUTE) >= itemstack.getOrCreateTag().getDouble("minute")) {
								itemstack.getOrCreateTag().putBoolean("used", false);
							} else {
								itemstack.getOrCreateTag().putString("lore", ("\u00A7aAvailable in : \u00A7b" + Math.round(itemstack.getOrCreateTag().getDouble("minute") - Calendar.getInstance().get(Calendar.MINUTE)) + " minute(s)"));
							}
						} else {
							itemstack.getOrCreateTag().putString("lore",
									("\u00A7aAvailable in : \u00A7b" + Math.round(itemstack.getOrCreateTag().getDouble("hour") - Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) + "h" + Math.round(60 - Calendar.getInstance().get(Calendar.MINUTE))));
						}
					} else {
						if (24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + itemstack.getOrCreateTag().getDouble("hour") >= 24) {
							itemstack.getOrCreateTag().putString("lore", ("\u00A7aAvailable in : \u00A7b" + Math.round(24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + itemstack.getOrCreateTag().getDouble("hour")) + "h"));
						} else {
							itemstack.getOrCreateTag().putString("lore", ("\u00A7aAvailable in : \u00A7b" + Math.round(24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + itemstack.getOrCreateTag().getDouble("hour")) + "h"
									+ Math.round(60 - Calendar.getInstance().get(Calendar.MINUTE))));
						}
					}
				}
			}
		} else {
			itemstack.getOrCreateTag().putString("lore", "\u00A7aReady !");
		}
	}
}
