package net.sen.crystalsorcery.data.models;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sen.crystalsorcery.CrystalSorcery;

public abstract class BlockStateProviderHelper extends BlockStateProvider {
    public BlockStateProviderHelper(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrystalSorcery.MODID, exFileHelper);
    }
}
