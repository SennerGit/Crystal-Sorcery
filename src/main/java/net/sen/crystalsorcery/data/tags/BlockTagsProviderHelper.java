package net.sen.crystalsorcery.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sen.crystalsorcery.CrystalSorcery;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public abstract class BlockTagsProviderHelper extends BlockTagsProvider {
    public BlockTagsProviderHelper(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrystalSorcery.MODID, existingFileHelper);
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
        return "Block Tags";
    }
}
