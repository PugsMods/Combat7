package com.putopug.combat7.init.items;

import com.putopug.combat7.combat7;
import com.putopug.combat7.init.itemGroups;
import com.putopug.combat7.tier.ModItemTier;
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
    public static final RegistryObject<SwordItem> LAPIS_SWORD = ITEMS.register("lapis_sword", () -> new SwordItem(ModItemTier.LAPIS, 0, 3.0F, new Item.Properties().group(itemGroups.TOOLS)));
    public static final RegistryObject<SwordItem> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(ModItemTier.LAPIS, 0, -2.6F, new Item.Properties().group(itemGroups.TOOLS)));

}
