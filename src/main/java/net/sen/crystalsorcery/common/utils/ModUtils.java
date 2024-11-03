package net.sen.crystalsorcery.common.utils;

import net.minecraft.resources.ResourceLocation;
import net.sen.crystalsorcery.CrystalSorcery;

import java.util.Locale;

public class ModUtils {
    public static String getMinecraftId() {
        return "minecraft".toLowerCase(Locale.ROOT);
    }
    public static ResourceLocation getModPath(String name) {
        return new ResourceLocation(CrystalSorcery.MODID.toLowerCase(Locale.ROOT), name.toLowerCase(Locale.ROOT));
    }
    public static ResourceLocation getMinecraftPath(String name) {
        return new ResourceLocation(getMinecraftId(), name.toLowerCase(Locale.ROOT));
    }}
