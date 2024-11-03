package net.sen.crystalsorcery.data.language;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.sen.crystalsorcery.CrystalSorcery;

public abstract class LanguageProviderHelper extends LanguageProvider {
    public LanguageProviderHelper(PackOutput output, String locale) {
        super(output, CrystalSorcery.MODID, locale);
    }
}
