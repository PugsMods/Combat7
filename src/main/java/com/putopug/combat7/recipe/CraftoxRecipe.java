package com.putopug.combat7.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

//
//@author PutoPug
//
public class CraftoxRecipe implements ICraftoxRecipe{
    private final ResourceLocation id;
    private Ingredient input_1;
    private Ingredient input_2;
    private Ingredient input_3;
    private Ingredient input_4;
    private Ingredient input_5;
    private Ingredient input_6;
    private Ingredient input_7;
    private Ingredient input_8;
    private Ingredient input_9;
    private Ingredient input_10;
    private Ingredient input_11;
    private Ingredient input_12;
    private Ingredient input_13;
    private Ingredient input_14;
    private Ingredient input_15;
    private ItemStack output;
    public CraftoxRecipe(ResourceLocation id, Ingredient input_1, Ingredient input_2, Ingredient input_3, Ingredient input_4, Ingredient input_5, Ingredient input_6, Ingredient input_7, Ingredient input_8, Ingredient input_9, Ingredient input_10, Ingredient input_11, Ingredient input_12, Ingredient input_13, Ingredient input_14, Ingredient input_15,ItemStack output){
        this.id = id;
        this.input_1 = input_1;
        this.input_2 = input_2;
        this.input_3 = input_3;
        this.input_4 = input_4;
        this.input_5 = input_5;
        this.input_6 = input_6;
        this.input_7 = input_7;
        this.input_8 = input_8;
        this.input_9 = input_9;
        this.input_10 = input_10;
        this.input_11 = input_11;
        this.input_12 = input_12;
        this.input_13 = input_13;
        this.input_14 = input_14;
        this.input_15 = input_15;
        this.output = output;
    }

    @Override
    public Ingredient getInput() {
        //TODO : 3-7-21
        return null;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        if(this.input_1.test(inv.getStackInSlot(0)) && this.input_2.test(inv.getStackInSlot(1)) && this.input_3.test(inv.getStackInSlot(2))&&this.input_4.test(inv.getStackInSlot(3))&&this.input_5.test(inv.getStackInSlot(4))&&this.input_6.test(inv.getStackInSlot(5))&&this.input_7.test(inv.getStackInSlot(6))&&this.input_8.test(inv.getStackInSlot(7))&&this.input_9.test(inv.getStackInSlot(8))&&this.input_10.test(inv.getStackInSlot(9))&&this.input_11.test(inv.getStackInSlot(10))&&this.input_12.test(inv.getStackInSlot(11))&&this.input_13.test(inv.getStackInSlot(12))&&this.input_14.test(inv.getStackInSlot(13))&&this.input_15.test(inv.getStackInSlot(14))) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return null;//RecipeSerializers.CRAFTOX_SERIALIZER.get();
    }
}
