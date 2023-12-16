package fr.erinagroups.erinium.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.Comparator;
import java.util.Calendar;

import java.io.File;

public class StonesDamageRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		File file = new File("");
		Entity current_player = null;
		if (itemstack.getOrCreateTag().getBoolean("used") == false) {
			current_player = entity;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == current_player)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 2);
					}
				}
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
