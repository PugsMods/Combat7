package com.putopug.combat7.recipe;

import com.putopug.combat7.combat7;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;

//
//@author PutoPug
//
public interface ICraftoxRecipe extends IRecipe<RecipeWrapper> {
    ResourceLocation RTID = new ResourceLocation(combat7.MOD_ID, "craftox");

    @Nonnull
    @Override
    default IRecipeType<?> getType() {
        return Registry.RECIPE_TYPE.getOrDefault(RTID);
    }

    @Override
    default boolean canFit(int width, int height){
        return false;
    }
    Ingredient getInput();
}
