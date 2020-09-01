package com.putopug.combat7.init.items;

import com.putopug.combat7.combat7;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolRegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //SWORDDEL
    public static final RegistryObject<SwordItem> FUNKY_SWORD = ITEMS.register("funky_sword", () ->
            new SwordItem(ItemTier.NETHERITE, 10000, 0.0F, new Item.Properties().group(ItemGroup.REDSTONE)));
    public static final RegistryObject<SwordItem> FUNfgbKY_SWORD = ITEMS.register("funkydgb_sword", () ->
            new SwordItem(ItemTier.NETHERITE, 100, 0.0F, new Item.Properties().group(ItemGroup.REDSTONE)));
}
