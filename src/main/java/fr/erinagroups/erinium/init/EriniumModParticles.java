
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.erinagroups.erinium.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import fr.erinagroups.erinium.client.particle.RedParticleParticle;
import fr.erinagroups.erinium.client.particle.PurpleParticleParticle;
import fr.erinagroups.erinium.client.particle.GreenParticleParticle;
import fr.erinagroups.erinium.client.particle.DarkRedParticleParticle;
import fr.erinagroups.erinium.client.particle.DarkBlueParticleParticle;
import fr.erinagroups.erinium.client.particle.CyanParticleParticle;
import fr.erinagroups.erinium.client.particle.CandyLeavesParticleParticle;
import fr.erinagroups.erinium.client.particle.AquaParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EriniumModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(EriniumModParticleTypes.CANDY_LEAVES_PARTICLE.get(), CandyLeavesParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.AQUA_PARTICLE.get(), AquaParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.DARK_BLUE_PARTICLE.get(), DarkBlueParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.RED_PARTICLE.get(), RedParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.PURPLE_PARTICLE.get(), PurpleParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.DARK_RED_PARTICLE.get(), DarkRedParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.GREEN_PARTICLE.get(), GreenParticleParticle::provider);
		event.registerSpriteSet(EriniumModParticleTypes.CYAN_PARTICLE.get(), CyanParticleParticle::provider);
	}
}
