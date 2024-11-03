package net.sen.crystalsorcery.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.crystalsorcery.CrystalSorcery;

import java.util.Collection;
import java.util.Locale;

public class CrystalSorceryCreativeModeTabs {
    private static final DeferredRegister TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalSorcery.MODID);

    public static final RegistryObject<CreativeModeTab> CRYSTAL_SORCERY_TAB = TABS.register("crystal_sorcery_tab", () -> {
return CreativeModeTab.builder()
        .icon(() -> new ItemStack(Items.STICK))
        .title(Component.translatable(generateName("crystal_sorcery_tab")))
        .displayItems(((itemDisplayParameters, output) -> {

        })).build();
    });

    private static String generateName(String id) {
        return ("itemgroup." + CrystalSorcery.MODID + "." + id).toLowerCase(Locale.ROOT);
    }

    public static void register(IEventBus eventBus) {
        eventBus.register(TABS);
    }
}
