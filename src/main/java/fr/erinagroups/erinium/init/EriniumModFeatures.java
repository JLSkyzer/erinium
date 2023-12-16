
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import fr.erinagroups.erinium.world.features.plants.LanternPlantFeature;
import fr.erinagroups.erinium.world.features.plants.IcyMushroomFeature;
import fr.erinagroups.erinium.world.features.plants.CandyBarFeature;
import fr.erinagroups.erinium.world.features.ores.SpectriumOreFeature;
import fr.erinagroups.erinium.world.features.ores.SilverOreFeature;
import fr.erinagroups.erinium.world.features.ores.SiliconeOreFeature;
import fr.erinagroups.erinium.world.features.ores.SciningCactusFeature;
import fr.erinagroups.erinium.world.features.ores.LeadOreFeature;
import fr.erinagroups.erinium.world.features.ores.EriniumOreMoonFeature;
import fr.erinagroups.erinium.world.features.ores.EriniumOreFeature;
import fr.erinagroups.erinium.world.features.ores.EriniumBushFeature;
import fr.erinagroups.erinium.world.features.ores.DraniteOreFeature;
import fr.erinagroups.erinium.world.features.ores.CopperOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandySilverOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyRedstoneOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyLeadOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyLapisOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyIronOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyGoldOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyEriniumOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyEmeralOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyDiamondOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyCopperOreFeature;
import fr.erinagroups.erinium.world.features.ores.CandyCoalOreFeature;
import fr.erinagroups.erinium.world.features.ores.BushFeature;
import fr.erinagroups.erinium.world.features.WizardTowerFeature;
import fr.erinagroups.erinium.world.features.VolcanoRockGenFeature;
import fr.erinagroups.erinium.world.features.TestStructureFeature;
import fr.erinagroups.erinium.world.features.StructureHouse1Feature;
import fr.erinagroups.erinium.world.features.MoonVillageFeature;
import fr.erinagroups.erinium.world.features.MoonCaveFeature;
import fr.erinagroups.erinium.world.features.JungleStonePillarFeature;
import fr.erinagroups.erinium.world.features.JungleMansionFeature;
import fr.erinagroups.erinium.world.features.JungleLongTree4Feature;
import fr.erinagroups.erinium.world.features.JungleLongTree3Feature;
import fr.erinagroups.erinium.world.features.JungleLongTree2Feature;
import fr.erinagroups.erinium.world.features.JungleLongTree1Feature;
import fr.erinagroups.erinium.world.features.JungleBush2Feature;
import fr.erinagroups.erinium.world.features.JungleBush1Feature;
import fr.erinagroups.erinium.world.features.JungleBigTree2Feature;
import fr.erinagroups.erinium.world.features.JungleBigTree1Feature;
import fr.erinagroups.erinium.world.features.HotWaterFeatureFeature;
import fr.erinagroups.erinium.world.features.Dungeon1Feature;
import fr.erinagroups.erinium.world.features.CandyDungeons1Feature;
import fr.erinagroups.erinium.EriniumMod;

@Mod.EventBusSubscriber
public class EriniumModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, EriniumMod.MODID);
	public static final RegistryObject<Feature<?>> ERINIUM_ORE = REGISTRY.register("erinium_ore", EriniumOreFeature::new);
	public static final RegistryObject<Feature<?>> SILICONE_ORE = REGISTRY.register("silicone_ore", SiliconeOreFeature::new);
	public static final RegistryObject<Feature<?>> DRANITE_ORE = REGISTRY.register("dranite_ore", DraniteOreFeature::new);
	public static final RegistryObject<Feature<?>> COPPER_ORE = REGISTRY.register("copper_ore", CopperOreFeature::new);
	public static final RegistryObject<Feature<?>> LEAD_ORE = REGISTRY.register("lead_ore", LeadOreFeature::new);
	public static final RegistryObject<Feature<?>> SILVER_ORE = REGISTRY.register("silver_ore", SilverOreFeature::new);
	public static final RegistryObject<Feature<?>> ERINIUM_ORE_MOON = REGISTRY.register("erinium_ore_moon", EriniumOreMoonFeature::new);
	public static final RegistryObject<Feature<?>> SPECTRIUM_ORE = REGISTRY.register("spectrium_ore", SpectriumOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_COAL_ORE = REGISTRY.register("candy_coal_ore", CandyCoalOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_IRON_ORE = REGISTRY.register("candy_iron_ore", CandyIronOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_GOLD_ORE = REGISTRY.register("candy_gold_ore", CandyGoldOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_REDSTONE_ORE = REGISTRY.register("candy_redstone_ore", CandyRedstoneOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_DIAMOND_ORE = REGISTRY.register("candy_diamond_ore", CandyDiamondOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_LAPIS_ORE = REGISTRY.register("candy_lapis_ore", CandyLapisOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_EMERAL_ORE = REGISTRY.register("candy_emeral_ore", CandyEmeralOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_ERINIUM_ORE = REGISTRY.register("candy_erinium_ore", CandyEriniumOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_COPPER_ORE = REGISTRY.register("candy_copper_ore", CandyCopperOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_SILVER_ORE = REGISTRY.register("candy_silver_ore", CandySilverOreFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_LEAD_ORE = REGISTRY.register("candy_lead_ore", CandyLeadOreFeature::new);
	public static final RegistryObject<Feature<?>> SCINING_CACTUS = REGISTRY.register("scining_cactus", SciningCactusFeature::new);
	public static final RegistryObject<Feature<?>> BUSH = REGISTRY.register("bush", BushFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_BAR = REGISTRY.register("candy_bar", CandyBarFeature::new);
	public static final RegistryObject<Feature<?>> ERINIUM_BUSH = REGISTRY.register("erinium_bush", EriniumBushFeature::new);
	public static final RegistryObject<Feature<?>> TEST_STRUCTURE = REGISTRY.register("test_structure", TestStructureFeature::new);
	public static final RegistryObject<Feature<?>> STRUCTURE_HOUSE_1 = REGISTRY.register("structure_house_1", StructureHouse1Feature::new);
	public static final RegistryObject<Feature<?>> DUNGEON_1 = REGISTRY.register("dungeon_1", Dungeon1Feature::new);
	public static final RegistryObject<Feature<?>> MOON_VILLAGE = REGISTRY.register("moon_village", MoonVillageFeature::new);
	public static final RegistryObject<Feature<?>> WIZARD_TOWER = REGISTRY.register("wizard_tower", WizardTowerFeature::new);
	public static final RegistryObject<Feature<?>> MOON_CAVE = REGISTRY.register("moon_cave", MoonCaveFeature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_STONE_PILLAR = REGISTRY.register("jungle_stone_pillar", JungleStonePillarFeature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_BUSH_1 = REGISTRY.register("jungle_bush_1", JungleBush1Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_BUSH_2 = REGISTRY.register("jungle_bush_2", JungleBush2Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_LONG_TREE_1 = REGISTRY.register("jungle_long_tree_1", JungleLongTree1Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_LONG_TREE_2 = REGISTRY.register("jungle_long_tree_2", JungleLongTree2Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_LONG_TREE_3 = REGISTRY.register("jungle_long_tree_3", JungleLongTree3Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_LONG_TREE_4 = REGISTRY.register("jungle_long_tree_4", JungleLongTree4Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_BIG_TREE_1 = REGISTRY.register("jungle_big_tree_1", JungleBigTree1Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_BIG_TREE_2 = REGISTRY.register("jungle_big_tree_2", JungleBigTree2Feature::new);
	public static final RegistryObject<Feature<?>> JUNGLE_MANSION = REGISTRY.register("jungle_mansion", JungleMansionFeature::new);
	public static final RegistryObject<Feature<?>> CANDY_DUNGEONS_1 = REGISTRY.register("candy_dungeons_1", CandyDungeons1Feature::new);
	public static final RegistryObject<Feature<?>> ICY_MUSHROOM = REGISTRY.register("icy_mushroom", IcyMushroomFeature::new);
	public static final RegistryObject<Feature<?>> LANTERN_PLANT = REGISTRY.register("lantern_plant", LanternPlantFeature::new);
	public static final RegistryObject<Feature<?>> VOLCANO_ROCK_GEN = REGISTRY.register("volcano_rock_gen", VolcanoRockGenFeature::new);
	public static final RegistryObject<Feature<?>> HOT_WATER_FEATURE = REGISTRY.register("hot_water_feature", HotWaterFeatureFeature::new);
}
