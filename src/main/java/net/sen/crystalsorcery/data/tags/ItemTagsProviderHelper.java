package net.sen.crystalsorcery.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sen.crystalsorcery.CrystalSorcery;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public abstract class ItemTagsProviderHelper extends ItemTagsProvider {
    public ItemTagsProviderHelper(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, blockTags, CrystalSorcery.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        ModTags();
        VanillaTags();
        ForgeTags();
    }

    abstract void ModTags();
    abstract void VanillaTags();
    abstract void ForgeTags();

    @Override
    public String getName() {
        return "Item Tags";
    }
}
