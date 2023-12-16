
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import fr.erinagroups.erinium.client.gui.WorkbenchTier1WikiPage1Screen;
import fr.erinagroups.erinium.client.gui.TtttScreen;
import fr.erinagroups.erinium.client.gui.TourTradiGuiScreen;
import fr.erinagroups.erinium.client.gui.TestGuiScreen;
import fr.erinagroups.erinium.client.gui.TempScreen;
import fr.erinagroups.erinium.client.gui.RankScreen;
import fr.erinagroups.erinium.client.gui.ProfileMenuStatsScreen;
import fr.erinagroups.erinium.client.gui.ProfileMenuRankScreen;
import fr.erinagroups.erinium.client.gui.PresentationGuiScreen;
import fr.erinagroups.erinium.client.gui.NetherStarGenGuiScreen;
import fr.erinagroups.erinium.client.gui.NavDimensionScreen;
import fr.erinagroups.erinium.client.gui.HAHAHAHAScreen;
import fr.erinagroups.erinium.client.gui.GuiWorkbenchTier1Screen;
import fr.erinagroups.erinium.client.gui.EggFactoryGuiScreen;
import fr.erinagroups.erinium.client.gui.CraftMatrixIngotScreen;
import fr.erinagroups.erinium.client.gui.CobbleVoidStationGuiScreen;
import fr.erinagroups.erinium.client.gui.ChangeWonXpOverlayScreen;
import fr.erinagroups.erinium.client.gui.BlockSellerGuiScreen;
import fr.erinagroups.erinium.client.gui.BackupMenuMainScreen;
import fr.erinagroups.erinium.client.gui.AstralMinerGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EriniumModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EriniumModMenus.PRESENTATION_GUI.get(), PresentationGuiScreen::new);
			MenuScreens.register(EriniumModMenus.RANK.get(), RankScreen::new);
			MenuScreens.register(EriniumModMenus.NETHER_STAR_GEN_GUI.get(), NetherStarGenGuiScreen::new);
			MenuScreens.register(EriniumModMenus.TOUR_TRADI_GUI.get(), TourTradiGuiScreen::new);
			MenuScreens.register(EriniumModMenus.TEST_GUI.get(), TestGuiScreen::new);
			MenuScreens.register(EriniumModMenus.EGG_FACTORY_GUI.get(), EggFactoryGuiScreen::new);
			MenuScreens.register(EriniumModMenus.TTTT.get(), TtttScreen::new);
			MenuScreens.register(EriniumModMenus.CHANGE_WON_XP_OVERLAY.get(), ChangeWonXpOverlayScreen::new);
			MenuScreens.register(EriniumModMenus.GUI_WORKBENCH_TIER_1.get(), GuiWorkbenchTier1Screen::new);
			MenuScreens.register(EriniumModMenus.HAHAHAHA.get(), HAHAHAHAScreen::new);
			MenuScreens.register(EriniumModMenus.PROFILE_MENU_RANK.get(), ProfileMenuRankScreen::new);
			MenuScreens.register(EriniumModMenus.PROFILE_MENU_STATS.get(), ProfileMenuStatsScreen::new);
			MenuScreens.register(EriniumModMenus.BACKUP_MENU_MAIN.get(), BackupMenuMainScreen::new);
			MenuScreens.register(EriniumModMenus.TEMP.get(), TempScreen::new);
			MenuScreens.register(EriniumModMenus.WORKBENCH_TIER_1_WIKI_PAGE_1.get(), WorkbenchTier1WikiPage1Screen::new);
			MenuScreens.register(EriniumModMenus.CRAFT_MATRIX_INGOT.get(), CraftMatrixIngotScreen::new);
			MenuScreens.register(EriniumModMenus.ASTRAL_MINER_GUI.get(), AstralMinerGuiScreen::new);
			MenuScreens.register(EriniumModMenus.NAV_DIMENSION.get(), NavDimensionScreen::new);
			MenuScreens.register(EriniumModMenus.COBBLE_VOID_STATION_GUI.get(), CobbleVoidStationGuiScreen::new);
			MenuScreens.register(EriniumModMenus.BLOCK_SELLER_GUI.get(), BlockSellerGuiScreen::new);
		});
	}
}
