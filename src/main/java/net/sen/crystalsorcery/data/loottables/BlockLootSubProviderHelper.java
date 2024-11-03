package net.sen.crystalsorcery.data.loottables;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.sen.crystalsorcery.CrystalSorcery;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public abstract class BlockLootSubProviderHelper extends BlockLootSubProvider {
    protected BlockLootSubProviderHelper() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.entrySet().stream().filter(e -> e.getKey().location().getNamespace().equals(CrystalSorcery.MODID)).map(Map.Entry::getValue).toList();
    }

    protected void dropSelf(Supplier<? extends Block> block) {
        this.dropSelf(block.get());
    }

    protected void ore(Supplier<? extends Block> block, Supplier<? extends Item> drop) {
        this.add(block.get(), (result) -> createOreDrop(result, drop.get()));
    }

    protected void ore(Supplier<? extends Block> block, Item drop) {
        this.add(block.get(), (result) -> createOreDrop(result, drop));
    }

    protected void woodGroup(Supplier<LeavesBlock> leaves, Supplier<Block> log, Supplier<Block> wood, Supplier<Block> stripped_log, Supplier<Block> stripped_wood, Supplier<Block> planks, Supplier<StairBlock> stairs, Supplier<SlabBlock> slabs, Supplier<FenceBlock> fence, Supplier<FenceGateBlock> fence_gate, Supplier<DoorBlock> door, Supplier<TrapDoorBlock> trapdoor, Supplier<PressurePlateBlock> pressurePlate, Supplier<ButtonBlock> button, Supplier<StandingSignBlock> sign, Supplier<WallSignBlock> wallSign, Supplier<CeilingHangingSignBlock> hangingSign, Supplier<WallHangingSignBlock> wallHangingSign, Supplier<Item> itemSign, Supplier<Item> itemHangingSign) {
        this.dropSelf(log);
        this.dropSelf(wood);
        this.dropSelf(stripped_log);
        this.dropSelf(stripped_wood);
//        this.dropSelf(sapling);
        this.dropSelf(planks);
        this.slab(slabs);
        this.dropSelf(stairs);
        this.dropSelf(pressurePlate);
        this.door(door);
        this.dropSelf(trapdoor);
        this.dropSelf(fence);
        this.dropSelf(fence_gate);
        this.dropSelf(button);
        this.leaves(leaves);
        this.sign(sign, wallSign, itemSign);
        this.wall_sign(hangingSign, wallHangingSign, itemHangingSign);
    }

    protected void slab(Supplier<? extends Block> slab) {
        this.add(slab.get(), this::createSlabItemTable);
    }

    protected void leaves(Supplier<? extends Block> leaves) {
        this.add(leaves.get(), block -> createLeavesDrops(block, leaves.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected void door(Supplier<? extends Block> door) {
        this.add(door.get(), this::createDoorTable);
    }

    protected void sign(Supplier<? extends Block> block_sign, Supplier<? extends Block> block_sign_wall, Supplier<? extends Item> item_sign) {
        this.add(block_sign.get(), block -> createSingleItemTable(item_sign.get()));
        this.add(block_sign_wall.get(), block -> createSingleItemTable(item_sign.get()));
    }

    protected void wall_sign(Supplier<? extends Block> block_hanging_sign, Supplier<? extends Block> block_hanging_sign_wall, Supplier<? extends Item> item_hanging_sign) {
        this.add(block_hanging_sign.get(), block -> createSingleItemTable(item_hanging_sign.get()));
        this.add(block_hanging_sign_wall.get(), block -> createSingleItemTable(item_hanging_sign.get()));
    }
}
