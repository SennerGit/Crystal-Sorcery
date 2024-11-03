package net.sen.crystalsorcery.common.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.crystalsorcery.CrystalSorcery;

import java.util.Locale;

public class CrystalSorceryBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CrystalSorcery.MODID);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrystalSorcery.MODID);

    private static RegistryObject<Block> createBlock(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name.toLowerCase(Locale.ROOT), () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
        createBlockItem(name.toLowerCase(Locale.ROOT), toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> createBlock(String name, BlockBehaviour.Properties properties) {
        RegistryObject<Block> toReturn = BLOCKS.register(name.toLowerCase(Locale.ROOT), () -> new Block(properties));
        createBlockItem(name.toLowerCase(Locale.ROOT), toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> createBlock(String name, RotatedPillarBlock block) {
        return createBlock(name, block);
    }

    private static <T extends Block> RegistryObject<T> createBlock(String name, RegistryObject<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name.toLowerCase(Locale.ROOT), block);
        createBlockItem(name.toLowerCase(Locale.ROOT), toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> createBlockItem(String name, RegistryObject<T> block) {
        return BLOCK_ITEMS.register(name.toLowerCase(Locale.ROOT), () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        eventBus.register(BLOCKS);
        eventBus.register(BLOCK_ITEMS);
    }
}
