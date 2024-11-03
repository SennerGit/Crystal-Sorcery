package net.sen.crystalsorcery.data.models;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sen.crystalsorcery.CrystalSorcery;

public abstract class ItemModelProviderHelper extends ItemModelProvider {
    public ItemModelProviderHelper(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrystalSorcery.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemModel();
        blockModel();
    }

    abstract void itemModel();
    abstract void blockModel();
}
