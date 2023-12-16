
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import fr.erinagroups.erinium.EriniumMod;

public class EriniumModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EriniumMod.MODID);
	public static final RegistryObject<SoundEvent> MAGAZINE_RELOAD = REGISTRY.register("magazine_reload", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "magazine_reload")));
	public static final RegistryObject<SoundEvent> SCARH_SHOOT = REGISTRY.register("scarh_shoot", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "scarh_shoot")));
	public static final RegistryObject<SoundEvent> NO_AMMO = REGISTRY.register("no_ammo", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "no_ammo")));
	public static final RegistryObject<SoundEvent> HITMARKER = REGISTRY.register("hitmarker", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "hitmarker")));
	public static final RegistryObject<SoundEvent> PRINTER = REGISTRY.register("printer", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "printer")));
	public static final RegistryObject<SoundEvent> EXPLOSION = REGISTRY.register("explosion", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "explosion")));
	public static final RegistryObject<SoundEvent> ERINIUM_BOSS_DEAD_1 = REGISTRY.register("erinium_boss_dead_1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("erinium", "erinium_boss_dead_1")));
}
