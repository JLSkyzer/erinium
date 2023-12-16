
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import fr.erinagroups.erinium.fluid.types.HotWaterFluidType;
import fr.erinagroups.erinium.EriniumMod;

public class EriniumModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, EriniumMod.MODID);
	public static final RegistryObject<FluidType> HOT_WATER_TYPE = REGISTRY.register("hot_water", () -> new HotWaterFluidType());
}
