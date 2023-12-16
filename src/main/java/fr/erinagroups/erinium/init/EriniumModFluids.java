
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import fr.erinagroups.erinium.fluid.HotWaterFluid;
import fr.erinagroups.erinium.EriniumMod;

public class EriniumModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, EriniumMod.MODID);
	public static final RegistryObject<FlowingFluid> HOT_WATER = REGISTRY.register("hot_water", () -> new HotWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_HOT_WATER = REGISTRY.register("flowing_hot_water", () -> new HotWaterFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(HOT_WATER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_HOT_WATER.get(), RenderType.translucent());
		}
	}
}
