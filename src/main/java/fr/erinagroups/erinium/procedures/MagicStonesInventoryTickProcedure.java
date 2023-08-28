package fr.erinagroups.erinium.procedures;

import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Calendar;

import fr.erinagroups.erinium.EriniumMod;

public class MagicStonesInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				EriniumMod.LOGGER.warn("Failed to load dependency itemstack for procedure MagicStonesInventoryTick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("used")) {
			if (Calendar.getInstance().get(Calendar.YEAR) > itemstack.getOrCreateTag().getDouble("year")) {
				itemstack.getOrCreateTag().putBoolean("used", (false));
			} else {
				if (Calendar.getInstance().get(Calendar.MONTH) > itemstack.getOrCreateTag().getDouble("month")) {
					itemstack.getOrCreateTag().putBoolean("used", (false));
				} else {
					if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == itemstack.getOrCreateTag().getDouble("day") + 1) {
						if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= itemstack.getOrCreateTag().getDouble("hour")) {
							if (Calendar.getInstance().get(Calendar.MINUTE) >= itemstack.getOrCreateTag().getDouble("minute")) {
								itemstack.getOrCreateTag().putBoolean("used", (false));
							} else {
								itemstack.getOrCreateTag()
										.putString("lore",
												("\u00A7aAvailable in : \u00A7b" + Math.round(
														itemstack.getOrCreateTag().getDouble("minute") - Calendar.getInstance().get(Calendar.MINUTE))
														+ " minute(s)"));
							}
						} else {
							itemstack.getOrCreateTag().putString("lore",
									("\u00A7aAvailable in : \u00A7b"
											+ Math.round(
													itemstack.getOrCreateTag().getDouble("hour") - Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
											+ "h" + Math.round(60 - Calendar.getInstance().get(Calendar.MINUTE))));
						}
					} else if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > itemstack.getOrCreateTag().getDouble("day") + 1) {
						itemstack.getOrCreateTag().putBoolean("used", (false));
					} else {
						if (24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + itemstack.getOrCreateTag().getDouble("hour") >= 24) {
							itemstack.getOrCreateTag().putString("lore",
									("\u00A7aAvailable in : \u00A7b" + Math.round(
											24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + itemstack.getOrCreateTag().getDouble("hour"))
											+ "h"));
						} else {
							itemstack.getOrCreateTag().putString("lore", ("\u00A7aAvailable in : \u00A7b"
									+ Math.round(24 - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + itemstack.getOrCreateTag().getDouble("hour"))
									+ "h" + Math.round(60 - Calendar.getInstance().get(Calendar.MINUTE))));
						}
					}
				}
			}
		} else {
			itemstack.getOrCreateTag().putString("lore", "\u00A7aReady !");
		}
	}
}
