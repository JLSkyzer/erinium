
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import fr.erinagroups.erinium.world.inventory.WorkbenchTier1WikiPage1Menu;
import fr.erinagroups.erinium.world.inventory.TtttMenu;
import fr.erinagroups.erinium.world.inventory.TourTradiGuiMenu;
import fr.erinagroups.erinium.world.inventory.TestGuiMenu;
import fr.erinagroups.erinium.world.inventory.TempMenu;
import fr.erinagroups.erinium.world.inventory.RankMenu;
import fr.erinagroups.erinium.world.inventory.ProfileMenuStatsMenu;
import fr.erinagroups.erinium.world.inventory.ProfileMenuRankMenu;
import fr.erinagroups.erinium.world.inventory.PresentationGuiMenu;
import fr.erinagroups.erinium.world.inventory.NetherStarGenGuiMenu;
import fr.erinagroups.erinium.world.inventory.NavDimensionMenu;
import fr.erinagroups.erinium.world.inventory.HAHAHAHAMenu;
import fr.erinagroups.erinium.world.inventory.GuiWorkbenchTier1Menu;
import fr.erinagroups.erinium.world.inventory.EggFactoryGuiMenu;
import fr.erinagroups.erinium.world.inventory.CraftMatrixIngotMenu;
import fr.erinagroups.erinium.world.inventory.CobbleVoidStationGuiMenu;
import fr.erinagroups.erinium.world.inventory.ChangeWonXpOverlayMenu;
import fr.erinagroups.erinium.world.inventory.BlockSellerGuiMenu;
import fr.erinagroups.erinium.world.inventory.BackupMenuMainMenu;
import fr.erinagroups.erinium.world.inventory.AstralMinerGuiMenu;
import fr.erinagroups.erinium.EriniumMod;

public class EriniumModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EriniumMod.MODID);
	public static final RegistryObject<MenuType<PresentationGuiMenu>> PRESENTATION_GUI = REGISTRY.register("presentation_gui", () -> IForgeMenuType.create(PresentationGuiMenu::new));
	public static final RegistryObject<MenuType<RankMenu>> RANK = REGISTRY.register("rank", () -> IForgeMenuType.create(RankMenu::new));
	public static final RegistryObject<MenuType<NetherStarGenGuiMenu>> NETHER_STAR_GEN_GUI = REGISTRY.register("nether_star_gen_gui", () -> IForgeMenuType.create(NetherStarGenGuiMenu::new));
	public static final RegistryObject<MenuType<TourTradiGuiMenu>> TOUR_TRADI_GUI = REGISTRY.register("tour_tradi_gui", () -> IForgeMenuType.create(TourTradiGuiMenu::new));
	public static final RegistryObject<MenuType<TestGuiMenu>> TEST_GUI = REGISTRY.register("test_gui", () -> IForgeMenuType.create(TestGuiMenu::new));
	public static final RegistryObject<MenuType<EggFactoryGuiMenu>> EGG_FACTORY_GUI = REGISTRY.register("egg_factory_gui", () -> IForgeMenuType.create(EggFactoryGuiMenu::new));
	public static final RegistryObject<MenuType<TtttMenu>> TTTT = REGISTRY.register("tttt", () -> IForgeMenuType.create(TtttMenu::new));
	public static final RegistryObject<MenuType<ChangeWonXpOverlayMenu>> CHANGE_WON_XP_OVERLAY = REGISTRY.register("change_won_xp_overlay", () -> IForgeMenuType.create(ChangeWonXpOverlayMenu::new));
	public static final RegistryObject<MenuType<GuiWorkbenchTier1Menu>> GUI_WORKBENCH_TIER_1 = REGISTRY.register("gui_workbench_tier_1", () -> IForgeMenuType.create(GuiWorkbenchTier1Menu::new));
	public static final RegistryObject<MenuType<HAHAHAHAMenu>> HAHAHAHA = REGISTRY.register("hahahaha", () -> IForgeMenuType.create(HAHAHAHAMenu::new));
	public static final RegistryObject<MenuType<ProfileMenuRankMenu>> PROFILE_MENU_RANK = REGISTRY.register("profile_menu_rank", () -> IForgeMenuType.create(ProfileMenuRankMenu::new));
	public static final RegistryObject<MenuType<ProfileMenuStatsMenu>> PROFILE_MENU_STATS = REGISTRY.register("profile_menu_stats", () -> IForgeMenuType.create(ProfileMenuStatsMenu::new));
	public static final RegistryObject<MenuType<BackupMenuMainMenu>> BACKUP_MENU_MAIN = REGISTRY.register("backup_menu_main", () -> IForgeMenuType.create(BackupMenuMainMenu::new));
	public static final RegistryObject<MenuType<TempMenu>> TEMP = REGISTRY.register("temp", () -> IForgeMenuType.create(TempMenu::new));
	public static final RegistryObject<MenuType<WorkbenchTier1WikiPage1Menu>> WORKBENCH_TIER_1_WIKI_PAGE_1 = REGISTRY.register("workbench_tier_1_wiki_page_1", () -> IForgeMenuType.create(WorkbenchTier1WikiPage1Menu::new));
	public static final RegistryObject<MenuType<CraftMatrixIngotMenu>> CRAFT_MATRIX_INGOT = REGISTRY.register("craft_matrix_ingot", () -> IForgeMenuType.create(CraftMatrixIngotMenu::new));
	public static final RegistryObject<MenuType<AstralMinerGuiMenu>> ASTRAL_MINER_GUI = REGISTRY.register("astral_miner_gui", () -> IForgeMenuType.create(AstralMinerGuiMenu::new));
	public static final RegistryObject<MenuType<NavDimensionMenu>> NAV_DIMENSION = REGISTRY.register("nav_dimension", () -> IForgeMenuType.create(NavDimensionMenu::new));
	public static final RegistryObject<MenuType<CobbleVoidStationGuiMenu>> COBBLE_VOID_STATION_GUI = REGISTRY.register("cobble_void_station_gui", () -> IForgeMenuType.create(CobbleVoidStationGuiMenu::new));
	public static final RegistryObject<MenuType<BlockSellerGuiMenu>> BLOCK_SELLER_GUI = REGISTRY.register("block_seller_gui", () -> IForgeMenuType.create(BlockSellerGuiMenu::new));
}
