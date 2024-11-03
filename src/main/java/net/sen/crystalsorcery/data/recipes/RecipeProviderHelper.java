package net.sen.crystalsorcery.data.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public abstract class RecipeProviderHelper extends RecipeProvider implements IConditionBuilder {
    public RecipeProviderHelper(PackOutput pOutput) {
        super(pOutput);
    }
}
