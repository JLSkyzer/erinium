
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import fr.erinagroups.erinium.EriniumMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EriniumModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EriniumMod.MODID);
	public static final RegistryObject<CreativeModeTab> ADMIN_ZONE = REGISTRY.register("admin_zone",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.erinium.admin_zone")).icon(() -> new ItemStack(EriniumModItems.WARNING_LOGO.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EriniumModItems.OP_TOOL.get());
				tabData.accept(EriniumModItems.ADMIN_STICK.get());
				tabData.accept(EriniumModBlocks.CUTOUTBLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.LINE_1_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.HOUSE_1_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.CALCULATOR.get().asItem());
				tabData.accept(EriniumModItems.ITEM_POS.get());
				tabData.accept(EriniumModItems.BOMB.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_DEBUG.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> ERINIUM_BLOCKS = REGISTRY.register("erinium_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.erinium.erinium_blocks")).icon(() -> new ItemStack(EriniumModBlocks.ERINIUM_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EriniumModBlocks.ERINIUM_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.SILICONE_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.DRANITE_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.COPPER_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.LEAD_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.SILVER_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_ORE_MOON.get().asItem());
				tabData.accept(EriniumModBlocks.SPECTRIUM_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_COAL_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_IRON_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_GOLD_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_REDSTONE_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_DIAMOND_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_LAPIS_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_EMERAL_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_ERINIUM_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_COPPER_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_SILVER_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_LEAD_ORE.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_OBSIDIAN.get().asItem());
				tabData.accept(EriniumModBlocks.SETANUM_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.CAVE_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.SCINING_SAND.get().asItem());
				tabData.accept(EriniumModBlocks.SCINING_SANDSTONE.get().asItem());
				tabData.accept(EriniumModBlocks.SCINING_CACTUS.get().asItem());
				tabData.accept(EriniumModBlocks.BUSH.get().asItem());
				tabData.accept(EriniumModBlocks.BLOCK_SETTER.get().asItem());
				tabData.accept(EriniumModBlocks.MOON_SAND.get().asItem());
				tabData.accept(EriniumModBlocks.MOON_STONE.get().asItem());
				tabData.accept(EriniumModBlocks.CLASSIC_LOOTBOX.get().asItem());
				tabData.accept(EriniumModBlocks.ULTIMATE_LOOTBOX.get().asItem());
				tabData.accept(EriniumModBlocks.SPECTRIUM_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_LOGS.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_LEAVES.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_PLANKS.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_FENCE.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_FENCE_GATE.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_STAIRS.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_SLAB.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_TRAPDOOR.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_PRESSURE_PLATE.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_BUTTON.get().asItem());
				tabData.accept(EriniumModBlocks.AMENINE_ROD.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_BOSS_SPAWNER.get().asItem());
				tabData.accept(EriniumModBlocks.WIZARD_BOSS_SPAWNER.get().asItem());
				tabData.accept(EriniumModBlocks.LEATHER_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.BLACK_BRICK.get().asItem());
				tabData.accept(EriniumModBlocks.BLACK_METAL.get().asItem());
				tabData.accept(EriniumModBlocks.BLACK_METAL_2.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_BAR.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_GRASS.get().asItem());
				tabData.accept(EriniumModBlocks.CHOCOLATE_DIRT.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_LOGS.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_LEAVES.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_PLANKS.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_SLAB.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_STAIRS.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_COBBLESTONE.get().asItem());
				tabData.accept(EriniumModBlocks.CANDY_STONE.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_COBWEB.get().asItem());
				tabData.accept(EriniumModBlocks.JL_SKYZER_PAINTING.get().asItem());
				tabData.accept(EriniumModBlocks.JL_SKYZER_PAINTING_2.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_BACKGROUND.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_LOGO.get().asItem());
				tabData.accept(EriniumModBlocks.SPECTRIUM_BATTERY.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_MATRIX_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.RED_JUNGLE_DIRT.get().asItem());
				tabData.accept(EriniumModBlocks.RED_JUNGLE_GRASS.get().asItem());
				tabData.accept(EriniumModBlocks.ROCK_VOLCANO.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> ERINIUM_TOOLS = REGISTRY.register("erinium_tools",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.erinium.erinium_tools")).icon(() -> new ItemStack(EriniumModItems.ERINIUM_SWORD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EriniumModItems.ERINIUM_SWORD.get());
				tabData.accept(EriniumModItems.ERINIUM_AXE.get());
				tabData.accept(EriniumModItems.ERINIUM_PICKAXE.get());
				tabData.accept(EriniumModItems.ERINIUM_HAMMER.get());
				tabData.accept(EriniumModItems.MAGIC_WAND.get());
				tabData.accept(EriniumModItems.SETANUM_SWORD.get());
				tabData.accept(EriniumModItems.SETANUM_PICKAXE.get());
				tabData.accept(EriniumModItems.SETANUM_AXE.get());
				tabData.accept(EriniumModItems.SETANUM_SHOVEL.get());
				tabData.accept(EriniumModItems.BEDROCK_STICK.get());
				tabData.accept(EriniumModItems.KNIFE.get());
				tabData.accept(EriniumModItems.KNIFE_TOOL.get());
				tabData.accept(EriniumModItems.BLOCK_REPLACER.get());
				tabData.accept(EriniumModItems.CHEST_FINDER.get());
				tabData.accept(EriniumModItems.DUNGEON_FINDER.get());
				tabData.accept(EriniumModItems.COBBLE_VOID.get());
				tabData.accept(EriniumModItems.HOME_TELEPORTER.get());
				tabData.accept(EriniumModItems.RAINBOW_SWORD.get());
				tabData.accept(EriniumModItems.RAINBOW_PICKAXE.get());
				tabData.accept(EriniumModItems.RAINBOW_AXE.get());
				tabData.accept(EriniumModItems.RAINBOW_SHOVEL.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_SWORD.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_PICKAXE.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_AXE.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> ERINIUM_ITEMS = REGISTRY.register("erinium_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.erinium.erinium_items")).icon(() -> new ItemStack(EriniumModItems.ERINIUM_INGOT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EriniumModItems.ERINIUM_INGOT.get());
				tabData.accept(EriniumModItems.FAKE_ERINIUM_INGOT.get());
				tabData.accept(EriniumModItems.SETANUM_INGOT.get());
				tabData.accept(EriniumModItems.COPPER_INGOT.get());
				tabData.accept(EriniumModItems.LEAD_INGOT.get());
				tabData.accept(EriniumModItems.SILVER_INGOT.get());
				tabData.accept(EriniumModItems.DRANITE_GEM.get());
				tabData.accept(EriniumModItems.RUBBER.get());
				tabData.accept(EriniumModItems.SPECTRIUM_GEM.get());
				tabData.accept(EriniumModItems.SILICONE_FRAGMENT.get());
				tabData.accept(EriniumModItems.TREE_BOSS_SHARD.get());
				tabData.accept(EriniumModItems.SETANUM_NUGGETS.get());
				tabData.accept(EriniumModItems.SKELETON_SHARD.get());
				tabData.accept(EriniumModItems.SKELETON_NUGGETS.get());
				tabData.accept(EriniumModItems.SCINING_GLASS_FRAGMENT.get());
				tabData.accept(EriniumModItems.SETANUM_SEEDS.get());
				tabData.accept(EriniumModItems.XP_ESSENCE.get());
				tabData.accept(EriniumModItems.EMPTY_BOTTLE.get());
				tabData.accept(EriniumModItems.EMPTY_LARGE_BOTTLE.get());
				tabData.accept(EriniumModItems.XP_LARGE_BOTTLE.get());
				tabData.accept(EriniumModItems.BLOOD_LARGE_BOTTLE.get());
				tabData.accept(EriniumModItems.SOUL_BOTTLE.get());
				tabData.accept(EriniumModItems.SOUL_BOTTLE_1.get());
				tabData.accept(EriniumModItems.SOUL_BOTTLE_2.get());
				tabData.accept(EriniumModItems.SOUL_BOTTLE_4.get());
				tabData.accept(EriniumModItems.SOUL_BOTTLE_3.get());
				tabData.accept(EriniumModItems.SOUL_BOTTLE_5.get());
				tabData.accept(EriniumModItems.AMENINE_LIQUID_1.get());
				tabData.accept(EriniumModItems.AMENINE_LIQUID_2.get());
				tabData.accept(EriniumModItems.AMENINE_LIQUID_3.get());
				tabData.accept(EriniumModItems.AMENINE_LIQUID_4.get());
				tabData.accept(EriniumModItems.AMENINE_LIQUID_5.get());
				tabData.accept(EriniumModItems.MAGIC_STICK.get());
				tabData.accept(EriniumModItems.ERINIUM_STICK.get());
				tabData.accept(EriniumModItems.AMENINE_STICK.get());
				tabData.accept(EriniumModItems.FORTUNE_MODIFIER.get());
				tabData.accept(EriniumModItems.CARDBOARD.get());
				tabData.accept(EriniumModItems.CARDBOARD_ROLL.get());
				tabData.accept(EriniumModItems.FABRIC_ROLL.get());
				tabData.accept(EriniumModItems.PRINTED_CIRCUIT_BOARD.get());
				tabData.accept(EriniumModItems.EMPTY_BOARD.get());
				tabData.accept(EriniumModItems.SCREEN.get());
				tabData.accept(EriniumModItems.WIRING_KIT.get());
				tabData.accept(EriniumModItems.MAGIC_ORB.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_INVISIBILITY.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_TELEPORTATION.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_HEAL.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_REGENERATION.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_DAMAGE.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_XP.get());
				tabData.accept(EriniumModItems.MAGIC_STONES_CREDIT.get());
				tabData.accept(EriniumModItems.PURE_GEM.get());
				tabData.accept(EriniumModItems.GEM_INVISIBILITY.get());
				tabData.accept(EriniumModItems.GEM_TELEPORT.get());
				tabData.accept(EriniumModItems.GEM_HEAL.get());
				tabData.accept(EriniumModItems.GEM_REGENERATION.get());
				tabData.accept(EriniumModItems.GEM_DAMAGE.get());
				tabData.accept(EriniumModItems.GEM_XP.get());
				tabData.accept(EriniumModItems.GEM_CREDIT.get());
				tabData.accept(EriniumModItems.ALMONIE_GEM.get());
				tabData.accept(EriniumModItems.ALMONIE_PAPER.get());
				tabData.accept(EriniumModItems.ALMONIE_CARD.get());
				tabData.accept(EriniumModItems.TIER_1_CRAFTING_BENCH.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_INGOT.get());
				tabData.accept(EriniumModItems.HACKED_USB_KEY.get());
				tabData.accept(EriniumModBlocks.ICY_MUSHROOM.get().asItem());
				tabData.accept(EriniumModBlocks.LANTERN_PLANT.get().asItem());
				tabData.accept(EriniumModItems.HOT_WATER_BUCKET.get());
				tabData.accept(EriniumModItems.LASER_DRILL.get());
				tabData.accept(EriniumModItems.ASTRAL_MINER_FOOT.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> ERINIUM_MACHINES = REGISTRY.register("erinium_machines",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.erinium.erinium_machines")).icon(() -> new ItemStack(EriniumModBlocks.EGG_FACTORY.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EriniumModBlocks.PRINTER.get().asItem());
				tabData.accept(EriniumModBlocks.SPATIAL_TELEPORTER_BLOCK.get().asItem());
				tabData.accept(EriniumModBlocks.TOUR_TRADI.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_EMPTY.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_BOTTLE_EMPTY.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_AMENINE_1.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_AMENINE_2.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_AMENINE_3.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_AMENINE_4.get().asItem());
				tabData.accept(EriniumModBlocks.EXTRACTOR_AMENINE_5.get().asItem());
				tabData.accept(EriniumModBlocks.FRAISAGE_NUMERIQUE.get().asItem());
				tabData.accept(EriniumModBlocks.FONDERIE.get().asItem());
				tabData.accept(EriniumModBlocks.EGG_FACTORY.get().asItem());
				tabData.accept(EriniumModBlocks.NETHER_STAR_GEN.get().asItem());
				tabData.accept(EriniumModBlocks.ERINIUM_WORKBENCH_TIER_1.get().asItem());
				tabData.accept(EriniumModBlocks.ASTRAL_MINER.get().asItem());
				tabData.accept(EriniumModBlocks.COBBLE_VOID_STATION.get().asItem());
				tabData.accept(EriniumModBlocks.ENERGY_SELLER.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> ERINIUM_ARMORS = REGISTRY.register("erinium_armors",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.erinium.erinium_armors")).icon(() -> new ItemStack(EriniumModItems.ERINIUM_TAB_ANIMATION.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EriniumModItems.ERINIUM_ARMOR_HELMET.get());
				tabData.accept(EriniumModItems.ERINIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(EriniumModItems.ERINIUM_ARMOR_LEGGINGS.get());
				tabData.accept(EriniumModItems.ERINIUM_ARMOR_BOOTS.get());
				tabData.accept(EriniumModItems.SETANUM_HELMET.get());
				tabData.accept(EriniumModItems.SETANUM_CHESTPLATE.get());
				tabData.accept(EriniumModItems.SETANUM_LEGGINGS.get());
				tabData.accept(EriniumModItems.SETANUM_BOOTS.get());
				tabData.accept(EriniumModItems.TREE_BOSS_ARMOR_HELMET.get());
				tabData.accept(EriniumModItems.TREE_BOSS_ARMOR_CHESTPLATE.get());
				tabData.accept(EriniumModItems.TREE_BOSS_ARMOR_LEGGINGS.get());
				tabData.accept(EriniumModItems.TREE_BOSS_ARMOR_BOOTS.get());
				tabData.accept(EriniumModItems.SPECTIUM_ARMOR_HELMET.get());
				tabData.accept(EriniumModItems.SPECTIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(EriniumModItems.SPECTIUM_ARMOR_LEGGINGS.get());
				tabData.accept(EriniumModItems.SPECTIUM_ARMOR_BOOTS.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_ARMOR_HELMET.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_ARMOR_CHESTPLATE.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_ARMOR_LEGGINGS.get());
				tabData.accept(EriniumModItems.ERINIUM_MATRIX_ARMOR_BOOTS.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(EriniumModBlocks.ERINIUM_BUSH.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(EriniumModItems.MAGIC_WAND_COBWEB.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(EriniumModItems.GOMY_SPAWN_EGG.get());
			tabData.accept(EriniumModItems.ERINIUM_SKELETON_BOSS_SPAWN_EGG.get());
			tabData.accept(EriniumModItems.USINAGE.get());
			tabData.accept(EriniumModItems.FRAISAGE.get());
			tabData.accept(EriniumModItems.WIZARD_SPAWN_EGG.get());
			tabData.accept(EriniumModItems.TREE_BOSS_SPAWN_EGG.get());
			tabData.accept(EriniumModItems.ASTRAL_MINER_LASER_MODULE.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(EriniumModItems.BLOOD_ORB.get());
		}
	}
}
