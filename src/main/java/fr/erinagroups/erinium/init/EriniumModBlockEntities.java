
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import fr.erinagroups.erinium.block.entity.NetherStarGenBlockEntity;
import fr.erinagroups.erinium.block.entity.FonderieBlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorEmptyBlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorBottleEmptyBlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorAmenine5BlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorAmenine4BlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorAmenine3BlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorAmenine2BlockEntity;
import fr.erinagroups.erinium.block.entity.ExtractorAmenine1BlockEntity;
import fr.erinagroups.erinium.block.entity.EnergySellerBlockEntity;
import fr.erinagroups.erinium.block.entity.EggFactoryBlockEntity;
import fr.erinagroups.erinium.block.entity.CobbleVoidStationBlockEntity;
import fr.erinagroups.erinium.block.entity.AstralMinerBlockEntity;
import fr.erinagroups.erinium.block.entity.AmenineLogsBlockEntity;
import fr.erinagroups.erinium.EriniumMod;

public class EriniumModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EriniumMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> AMENINE_LOGS = register("amenine_logs", EriniumModBlocks.AMENINE_LOGS, AmenineLogsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_EMPTY = register("extractor_empty", EriniumModBlocks.EXTRACTOR_EMPTY, ExtractorEmptyBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_BOTTLE_EMPTY = register("extractor_bottle_empty", EriniumModBlocks.EXTRACTOR_BOTTLE_EMPTY, ExtractorBottleEmptyBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_AMENINE_1 = register("extractor_amenine_1", EriniumModBlocks.EXTRACTOR_AMENINE_1, ExtractorAmenine1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_AMENINE_2 = register("extractor_amenine_2", EriniumModBlocks.EXTRACTOR_AMENINE_2, ExtractorAmenine2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_AMENINE_3 = register("extractor_amenine_3", EriniumModBlocks.EXTRACTOR_AMENINE_3, ExtractorAmenine3BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_AMENINE_4 = register("extractor_amenine_4", EriniumModBlocks.EXTRACTOR_AMENINE_4, ExtractorAmenine4BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EXTRACTOR_AMENINE_5 = register("extractor_amenine_5", EriniumModBlocks.EXTRACTOR_AMENINE_5, ExtractorAmenine5BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FONDERIE = register("fonderie", EriniumModBlocks.FONDERIE, FonderieBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> EGG_FACTORY = register("egg_factory", EriniumModBlocks.EGG_FACTORY, EggFactoryBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NETHER_STAR_GEN = register("nether_star_gen", EriniumModBlocks.NETHER_STAR_GEN, NetherStarGenBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ASTRAL_MINER = register("astral_miner", EriniumModBlocks.ASTRAL_MINER, AstralMinerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COBBLE_VOID_STATION = register("cobble_void_station", EriniumModBlocks.COBBLE_VOID_STATION, CobbleVoidStationBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENERGY_SELLER = register("energy_seller", EriniumModBlocks.ENERGY_SELLER, EnergySellerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
