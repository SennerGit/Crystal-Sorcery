package net.sen.crystalsorcery.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.sen.crystalsorcery.CrystalSorcery;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModRegistriesProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();
//            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
//            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
//            .add(Registries.BIOME, ModBiomes::bootstrap)
//            .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
//            .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
//            .add(Registries.NOISE_SETTINGS, ModDimensions::bootstrapNoise)
//            .add(Registries.DENSITY_FUNCTION, ModDimensions::bootstrapDensityFunctions)
//            .add(Registries.CONFIGURED_CARVER, ModConfiguredCarvers::bootstrap)
//            .add(Registries.STRUCTURE, ModStructureGenerator::bootstrapStructures)
//            .add(Registries.STRUCTURE_SET, ModStructureGenerator::bootstrapStructureSets)
//            .add(Registries.TEMPLATE_POOL, ModStructureGenerator::bootstrapStructureTemplatePools)
//            .add(Registries.PROCESSOR_LIST, ModStructureGenerator::bootstrapProcessors)
//            .add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, ModDimensions::bootstrapNoiseBiomeSourceParameterList);
//            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap);

    public ModRegistriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CrystalSorcery.MODID));
    }
}
