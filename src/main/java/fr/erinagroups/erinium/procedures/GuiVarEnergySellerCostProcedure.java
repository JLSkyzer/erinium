package fr.erinagroups.erinium.procedures;

import net.minecraft.world.level.LevelAccessor;

import fr.erinagroups.erinium.network.EriniumModVariables;

public class GuiVarEnergySellerCostProcedure {
	public static String execute(LevelAccessor world) {
		return "Info: 1k FE = " + EriniumModVariables.MapVariables.get(world).energysellercost;
	}
}
