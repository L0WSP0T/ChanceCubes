package chanceCubes.listeners;

public class WorldGen
{
//	//I have no idea what I'm doing. Please help me...
//	private static ConfiguredFeature<BlockClusterFeatureConfig, ?> CHANCE_CUBE_SURFACE_FEATURE;
//	public static ConfiguredFeature<OreFeatureConfig, ?> CHANCE_CUBE_ORE_FEATURE;
//
//	public static void initWorldGen()
//	{
//		Registry<ConfiguredFeature<?, ?>> r = WorldGenRegistries.CONFIGURED_FEATURE;
//		CHANCE_CUBE_SURFACE_FEATURE = Feature.RANDOM_PATCH.withConfiguration(
//				(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CCubesBlocks.CHANCE_CUBE.getDefaultState()), new SimpleBlockPlacer()))
//						.tries(1)
//						.xSpread(16)
//						.ySpread(0)
//						.zSpread(16)
//						.build());
//		CHANCE_CUBE_ORE_FEATURE = Feature.ORE.withConfiguration(
//				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, CCubesBlocks.CHANCE_CUBE.getDefaultState(), 1)
//		);
//		Registry.register(r, new ResourceLocation(CCubesCore.MODID, "chance_cube_surface"), CHANCE_CUBE_SURFACE_FEATURE);
//		Registry.register(r, new ResourceLocation(CCubesCore.MODID, "chance_cube_ore"), CHANCE_CUBE_ORE_FEATURE);
//	}
//
//	@SubscribeEvent
//	public void onBiomeLoadingEvent(BiomeLoadingEvent event)
//	{
//		System.out.println("here");
//		if(CCubesSettings.surfaceGeneration.get())
//			event.getGeneration().withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, CHANCE_CUBE_SURFACE_FEATURE);
//		if(CCubesSettings.oreGeneration.get())
//			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, CHANCE_CUBE_ORE_FEATURE);
//	}
}