package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import com.putopug.combat7.init.items.itemGroups;
import com.putopug.combat7.tier.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//
//@author PutoPug
//
public class ArmRegHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);


    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

                    //LAPIS
    public static final RegistryObject<ArmorItem> LAPIS_BOOTS = ITEMS.register("lapis_boots",
            () -> new ArmorItem(ModArmorMaterial.LAPIS, EquipmentSlotType.FEET,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
    public static final RegistryObject<ArmorItem> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",
            () -> new ArmorItem(ModArmorMaterial.LAPIS, EquipmentSlotType.LEGS,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
    public static final RegistryObject<ArmorItem> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate",
            () -> new ArmorItem(ModArmorMaterial.LAPIS, EquipmentSlotType.CHEST,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
    public static final RegistryObject<ArmorItem> LAPIS_HELMET = ITEMS.register("lapis_helmet",
            () -> new ArmorItem(ModArmorMaterial.LAPIS, EquipmentSlotType.HEAD,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));

            //REDSTONE
    public static final RegistryObject<ArmorItem> REDSTONE_BOOTS = ITEMS.register("redstone_boots",
            () -> new ArmorItem(ModArmorMaterial.REDSTONE, EquipmentSlotType.FEET,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
    public static final RegistryObject<ArmorItem> REDSTONE_LEGGINGS = ITEMS.register("redstone_leggings",
            () -> new ArmorItem(ModArmorMaterial.REDSTONE, EquipmentSlotType.LEGS,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
    public static final RegistryObject<ArmorItem> REDSTONE_CHESTPLATE = ITEMS.register("redstone_chestplate",
            () -> new ArmorItem(ModArmorMaterial.REDSTONE, EquipmentSlotType.CHEST,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
    public static final RegistryObject<ArmorItem> REDSTONE_HELMET = ITEMS.register("redstone_helmet",
            () -> new ArmorItem(ModArmorMaterial.REDSTONE, EquipmentSlotType.HEAD,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(1150)));
        //EMERALD
    public static final RegistryObject<ArmorItem> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(3069)));
    public static final RegistryObject<ArmorItem> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(3069)));
    public static final RegistryObject<ArmorItem> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(3069)));
    public static final RegistryObject<ArmorItem> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(3069)));
    //DIRT
    public static final RegistryObject<ArmorItem> DIRT_BOOTS = ITEMS.register("dirt_boots",
            () -> new ArmorItem(ModArmorMaterial.DIRT, EquipmentSlotType.FEET,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(69)));
    public static final RegistryObject<ArmorItem> DIRT_LEGGINGS = ITEMS.register("dirt_leggings",
            () -> new ArmorItem(ModArmorMaterial.DIRT, EquipmentSlotType.LEGS,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(69)));
    public static final RegistryObject<ArmorItem> DIRT_CHESTPLATE = ITEMS.register("dirt_chestplate",
            () -> new ArmorItem(ModArmorMaterial.DIRT, EquipmentSlotType.CHEST,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(69)));
    public static final RegistryObject<ArmorItem> DIRT_HELMET = ITEMS.register("dirt_helmet",
            () -> new ArmorItem(ModArmorMaterial.DIRT, EquipmentSlotType.HEAD,
                    new Item.Properties().group(itemGroups.TOOLS).maxDamage(69)));




}
