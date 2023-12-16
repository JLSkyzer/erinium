package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import fr.erinagroups.erinium.init.EriniumModEntities;
import fr.erinagroups.erinium.entity.TreeBossProjectileEntity;

public class TreeBossOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		random = Math.round(Mth.nextInt(RandomSource.create(), 1, 10));
		if (entity.getPersistentData().getDouble("attacked") > 0) {
			entity.getPersistentData().putDouble("attacked", (entity.getPersistentData().getDouble("attacked") - 1));
		}
		if (entity.getPersistentData().getDouble("cooldown") > 0) {
			entity.getPersistentData().putDouble("cooldown", (entity.getPersistentData().getDouble("cooldown") - 1));
		} else {
			if (entity.getPersistentData().getDouble("attacked") > 0) {
				if (random == 1) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (x + Mth.nextInt(RandomSource.create(), -5, 5)), y, (z + Mth.nextInt(RandomSource.create(), -5, 5)), 2, Level.ExplosionInteraction.NONE);
					entity.getPersistentData().putDouble("cooldown", 140);
				} else if (random == 5) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					entity.getPersistentData().putDouble("cooldown", 140);
				} else if (random == 10) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new TreeBossProjectileEntity(EriniumModEntities.TREE_BOSS_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									entityToSpawn.setCritArrow(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 4, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					entity.getPersistentData().putDouble("cooldown", 140);
				}
			}
		}
	}
}
