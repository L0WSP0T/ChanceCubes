package chanceCubes;

import chanceCubes.config.CCubesSettings;
import chanceCubes.worldgen.CCSurfaceFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static chanceCubes.CCubesCore.MODID;
import static net.minecraft.world.level.biome.Biome.BiomeCategory.NETHER;
import static net.minecraft.world.level.biome.Biome.BiomeCategory.THEEND;

@Mod.EventBusSubscriber(modid = MODID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        if (!CCubesSettings.generateInEnd.get() && event.getCategory() == THEEND) return;
        if (!CCubesSettings.generateInNether.get() && event.getCategory() == NETHER) return;
        CCSurfaceFeature.initGeneration(event);

    }
}