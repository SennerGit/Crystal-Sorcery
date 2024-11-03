package net.sen.crystalsorcery.data;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sen.crystalsorcery.CrystalSorcery;
import net.sen.crystalsorcery.data.language.EnUsLanguageProvider;
import net.sen.crystalsorcery.data.loottables.ModLootTableProvider;
import net.sen.crystalsorcery.data.models.ModBlockStateProvider;
import net.sen.crystalsorcery.data.models.ModItemModelProvider;
import net.sen.crystalsorcery.data.recipes.ModRecipeProvider;
import net.sen.crystalsorcery.data.tags.ModBiomeTagsProvider;
import net.sen.crystalsorcery.data.tags.ModBlockTagsProvider;
import net.sen.crystalsorcery.data.tags.ModEntityTagsProvider;
import net.sen.crystalsorcery.data.tags.ModItemTagsProvider;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CrystalSorcery.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        //Automating stuff
        addArmorTrims(helper);

        //Client
        generator.addProvider(event.includeClient(), new EnUsLanguageProvider(output));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, helper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, helper));

        //Server
        DatapackBuiltinEntriesProvider datapackProvider = new ModRegistriesProvider(output, event.getLookupProvider());
        CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();

        generator.addProvider(event.includeServer(), datapackProvider);
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(output));

        //Tags
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new ModEntityTagsProvider(output, lookupProvider, helper));
        generator.addProvider(event.includeServer(), new ModBiomeTagsProvider(output, lookupProvider, helper));

        //pack.meta
        generator.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.literal("Resources for Crystal Sorcery"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
                Map.of(PackType.CLIENT_RESOURCES, Integer.MAX_VALUE))
        ));
    }

    private static void addArmorTrims(ExistingFileHelper existingFileHelper) {
        addTrimToArmor(existingFileHelper, "boots_trim_");
        addTrimToArmor(existingFileHelper, "chestplate_trim_");
        addTrimToArmor(existingFileHelper, "helmet_trim_");
        addTrimToArmor(existingFileHelper, "leggings_trim_");
    }

    private static void addTrimToArmor(ExistingFileHelper existingFileHelper, String armorPiece) {
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.QUARTZ.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.IRON.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.NETHERITE.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.REDSTONE.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.COPPER.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.GOLD.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.EMERALD.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.DIAMOND.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.LAPIS.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
        existingFileHelper.trackGenerated(new ResourceLocation(armorPiece + TrimMaterials.AMETHYST.location().getPath()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
    }
}
