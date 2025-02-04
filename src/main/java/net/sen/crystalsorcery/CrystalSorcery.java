package net.sen.crystalsorcery;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.crystalsorcery.client.CrystalSorceryClient;
import net.sen.crystalsorcery.common.config.Config;
import net.sen.crystalsorcery.common.registries.CrystalSorceryBlocks;
import net.sen.crystalsorcery.common.registries.CrystalSorceryCreativeModeTabs;
import net.sen.crystalsorcery.common.registries.CrystalSorceryItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CrystalSorcery.MODID)
public class CrystalSorcery
{
    public static final String MODID = "crystalsorcery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CrystalSorcery(IEventBus eventBus, ModContainer container, Dist dist)
    {
        if (dist.isClient()) {
            CrystalSorceryClient.CrystalSorceryClientRegistry(eventBus);
        }

        eventBus.addListener(this::commonSetup);

        CrystalSorceryBlocks.register(eventBus);
        CrystalSorceryItems.register(eventBus);
        CrystalSorceryCreativeModeTabs.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
