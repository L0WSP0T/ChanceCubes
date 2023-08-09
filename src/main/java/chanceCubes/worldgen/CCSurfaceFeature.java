package chanceCubes.worldgen;

import chanceCubes.blocks.CCubesBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class CCSurfaceFeature {

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CHANCE_CUBE =
            FeatureUtils.register("chance_cube", Feature.FLOWER,
                    new RandomPatchConfiguration(1, 1, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(CCubesBlocks.CHANCE_CUBE)))));


    public static final Holder<PlacedFeature> CHANCE_CUBE_PLACED = PlacementUtils.register("chance_cube_placed",
            CHANCE_CUBE, RarityFilter.onAverageOnceEvery(135),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());

    public static void initGeneration(BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);
        base.add(CHANCE_CUBE_PLACED);
    }


}
