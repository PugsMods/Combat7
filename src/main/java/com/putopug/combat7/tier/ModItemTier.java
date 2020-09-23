package com.putopug.combat7.tier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;


public enum ModItemTier implements IItemTier {


    LAPIS(2, 1795, 8.0F, 7.0F,20, () -> {return Ingredient.fromItems(Items.LAPIS_LAZULI);}),
    EMERALD(8, 3098, 8.0F, 10.0F,30, () -> {return Ingredient.fromItems(Items.EMERALD);});

    private final int harvestLevel;

    private final int maxUses;

    private final float efficiency;

    private final float attackDamage;

    private final int enchantability;

    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
