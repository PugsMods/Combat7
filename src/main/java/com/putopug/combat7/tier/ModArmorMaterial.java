package com.putopug.combat7.tier;

import com.putopug.combat7.combat7;
import com.putopug.combat7.init.items.ArmRegHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.ArmorDyeRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    LAPIS(combat7.MOD_ID + ":lapis", 25, new int[] {3,8,7,3}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.1F, () -> { return Ingredient.fromItems(Items.LAPIS_LAZULI); },0.1F),
    REDSTONE(combat7.MOD_ID + ":redstone", 25, new int[] {4,7,9,4}, 11,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.1F, () -> { return Ingredient.fromItems(Items.LAPIS_LAZULI); },0.1F),
    EMERALD(combat7.MOD_ID + ":emerald", 25, new int[] {6,9,11,6}, 69,
    SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.1F, () -> { return Ingredient.fromItems(Items.LAPIS_LAZULI); },0.1F);


    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor; //Durability, Iron=15, Diamond=33, Gold=7, Leather=5
    private final int[] damageReductionAmountArray; //Armor Bar Protection, 1 = 1/2 armor bar
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness; //Increases Protection, 0.0F=Iron/Gold/Leather, 2.0F=Diamond, 3.0F=Netherite
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance; //1.0F=No Knockback, 0.0F=Disabled

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
                     SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
