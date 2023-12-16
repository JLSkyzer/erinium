
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import fr.erinagroups.erinium.EriniumMod;

public class EriniumModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, EriniumMod.MODID);
	public static final RegistryObject<SimpleParticleType> CANDY_LEAVES_PARTICLE = REGISTRY.register("candy_leaves_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> AQUA_PARTICLE = REGISTRY.register("aqua_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DARK_BLUE_PARTICLE = REGISTRY.register("dark_blue_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> RED_PARTICLE = REGISTRY.register("red_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PURPLE_PARTICLE = REGISTRY.register("purple_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DARK_RED_PARTICLE = REGISTRY.register("dark_red_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GREEN_PARTICLE = REGISTRY.register("green_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CYAN_PARTICLE = REGISTRY.register("cyan_particle", () -> new SimpleParticleType(true));
}
