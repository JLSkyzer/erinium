
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import fr.erinagroups.erinium.entity.WizardEntity;
import fr.erinagroups.erinium.entity.TreeBossProjectileEntity;
import fr.erinagroups.erinium.entity.TreeBossEntity;
import fr.erinagroups.erinium.entity.MagicalWandEntity;
import fr.erinagroups.erinium.entity.MagicWandCobwebEntity;
import fr.erinagroups.erinium.entity.GomyEntity;
import fr.erinagroups.erinium.entity.EriniumSkeletonBossEntity;
import fr.erinagroups.erinium.entity.BombEntity;
import fr.erinagroups.erinium.EriniumMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EriniumModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EriniumMod.MODID);
	public static final RegistryObject<EntityType<BombEntity>> BOMB = register("projectile_bomb",
			EntityType.Builder.<BombEntity>of(BombEntity::new, MobCategory.MISC).setCustomClientFactory(BombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GomyEntity>> GOMY = register("gomy",
			EntityType.Builder.<GomyEntity>of(GomyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GomyEntity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<EriniumSkeletonBossEntity>> ERINIUM_SKELETON_BOSS = register("erinium_skeleton_boss", EntityType.Builder.<EriniumSkeletonBossEntity>of(EriniumSkeletonBossEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EriniumSkeletonBossEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WizardEntity>> WIZARD = register("wizard",
			EntityType.Builder.<WizardEntity>of(WizardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WizardEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TreeBossEntity>> TREE_BOSS = register("tree_boss",
			EntityType.Builder.<TreeBossEntity>of(TreeBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TreeBossEntity::new)

					.sized(1f, 4f));
	public static final RegistryObject<EntityType<MagicWandCobwebEntity>> MAGIC_WAND_COBWEB = register("projectile_magic_wand_cobweb", EntityType.Builder.<MagicWandCobwebEntity>of(MagicWandCobwebEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MagicWandCobwebEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MagicalWandEntity>> MAGICAL_WAND = register("projectile_magical_wand",
			EntityType.Builder.<MagicalWandEntity>of(MagicalWandEntity::new, MobCategory.MISC).setCustomClientFactory(MagicalWandEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TreeBossProjectileEntity>> TREE_BOSS_PROJECTILE = register("projectile_tree_boss_projectile", EntityType.Builder.<TreeBossProjectileEntity>of(TreeBossProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TreeBossProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GomyEntity.init();
			EriniumSkeletonBossEntity.init();
			WizardEntity.init();
			TreeBossEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GOMY.get(), GomyEntity.createAttributes().build());
		event.put(ERINIUM_SKELETON_BOSS.get(), EriniumSkeletonBossEntity.createAttributes().build());
		event.put(WIZARD.get(), WizardEntity.createAttributes().build());
		event.put(TREE_BOSS.get(), TreeBossEntity.createAttributes().build());
	}
}
