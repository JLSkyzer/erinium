
package fr.erinagroups.erinium.world.structure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Mirror;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import fr.erinagroups.erinium.procedures.VolcanoRocksGen0OnStructureInstanceGeneratedProcedure;

import com.github.hexomod.worldeditcuife3.z;
import com.github.hexomod.worldeditcuife3.y;
import com.github.hexomod.worldeditcuife3.x;
import com.github.hexomod.worldeditcuife3.k;
import com.github.hexomod.worldeditcuife3.j;
import com.github.hexomod.worldeditcuife3.i;
import com.github.hexomod.worldeditcuife3.ck;
import com.github.hexomod.worldeditcuife3.ci;
import com.github.hexomod.worldeditcuife3.a;

@Mod.EventBusSubscriber
public class VolcanoRocksGen0Structure {
	private static Feature<NoFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class FeatureRegisterHandler {
		@SubscribeEvent
		public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
					int ci = (pos.getX() >> 4) << 4;
					int ck = (pos.getZ() >> 4) << 4;
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;
					if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("erinium:moon")))
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					if ((random.nextInt(1000000) + 1) <= 2500) {
						int count = random.nextInt(1) + 1;
						for (int a = 0; a < count; a++) {
							int i = ci + random.nextInt(16);
							int k = ck + random.nextInt(16);
							int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);
							j -= 1;
							Rotation rotation = Rotation.values()[random.nextInt(3)];
							Mirror mirror = Mirror.values()[random.nextInt(2)];
							BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
							int x = spawnTo.getX();
							int y = spawnTo.getY();
							int z = spawnTo.getZ();
							Template template = world.getWorld().getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("erinium", "volcano_rock_gen_0"));
							if (template == null)
								return false;
							template.func_237144_a_(world, spawnTo,
									new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
											.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
									random);

							VolcanoRocksGen0OnStructureInstanceGeneratedProcedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
					return true;
				}
			};
			configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
			event.getRegistry().register(feature.setRegistryName("volcano_rocks_gen_0"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("erinium:volcano_rocks_gen_0"), configuredFeature);
		}
	}

	@SubscribeEvent
	public static void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
	}
}