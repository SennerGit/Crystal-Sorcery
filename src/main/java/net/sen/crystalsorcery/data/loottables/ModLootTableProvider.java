package net.sen.crystalsorcery.data.loottables;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(ModEntityLootTables::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(ModChestLootTables::new, LootContextParamSets.CHEST),
                new LootTableProvider.SubProviderEntry(ModArchaeologyLootTables::new, LootContextParamSets.ARCHAEOLOGY),
                new LootTableProvider.SubProviderEntry(ModFishingLootTables::new, LootContextParamSets.FISHING),
                new LootTableProvider.SubProviderEntry(ModSpecialLootTables::new, LootContextParamSets.EMPTY)
        ));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
        super.validate(map, validationcontext);
    }
}
