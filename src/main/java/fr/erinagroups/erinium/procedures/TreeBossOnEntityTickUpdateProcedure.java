package fr.erinagroups.erinium.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.MathHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import fr.erinagroups.erinium.item.TreeBossProjectileItem;
import fr.erinagroups.erinium.EriniumMod;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;

public class TreeBossOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				EriniumMod.LOGGER.warn("Failed to load dependency world for procedure TreeBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				EriniumMod.LOGGER.warn("Failed to load dependency x for procedure TreeBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				EriniumMod.LOGGER.warn("Failed to load dependency y for procedure TreeBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				EriniumMod.LOGGER.warn("Failed to load dependency z for procedure TreeBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EriniumMod.LOGGER.warn("Failed to load dependency entity for procedure TreeBossOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		random = Math.round(MathHelper.nextInt(new Random(), 1, 10));
		if (entity.getPersistentData().getDouble("attacked") > 0) {
			entity.getPersistentData().putDouble("attacked", (entity.getPersistentData().getDouble("attacked") - 1));
		}
		if (entity.getPersistentData().getDouble("cooldown") > 0) {
			entity.getPersistentData().putDouble("cooldown", (entity.getPersistentData().getDouble("cooldown") - 1));
		} else {
			if (entity.getPersistentData().getDouble("attacked") > 0) {
				if (random == 1) {
					if (world instanceof World && !((World) world).isRemote) {
						((World) world).createExplosion(null, (int) (x + MathHelper.nextInt(new Random(), -5, 5)), (int) y,
								(int) (z + MathHelper.nextInt(new Random(), -5, 5)), (float) 2, Explosion.Mode.NONE);
					}
					entity.getPersistentData().putDouble("cooldown", 140);
				} else if (random == 5) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new ZombieEntity(EntityType.ZOMBIE, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new SkeletonEntity(EntityType.SKELETON, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					entity.getPersistentData().putDouble("cooldown", 140);
				} else if (random == 10) {
					{
						Entity _shootFrom = entity;
						World projectileLevel = _shootFrom.world;
						if (!projectileLevel.isRemote()) {
							ProjectileEntity _entityToSpawn = new Object() {
								public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrowEntity entityToSpawn = new TreeBossProjectileItem.ArrowCustomEntity(TreeBossProjectileItem.arrow,
											world);
									entityToSpawn.setShooter(shooter);
									entityToSpawn.setDamage(damage);
									entityToSpawn.setKnockbackStrength(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);

									entityToSpawn.setIsCritical(true);

									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 4, 0, (byte) 1);
							_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
							_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
							projectileLevel.addEntity(_entityToSpawn);
						}
					}
					entity.getPersistentData().putDouble("cooldown", 140);
				}
			}
		}
	}
}
