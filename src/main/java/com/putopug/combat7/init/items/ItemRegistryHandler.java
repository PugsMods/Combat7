package com.putopug.combat7.init.items;

import com.putopug.combat7.combat7;
import com.putopug.combat7.objects.items.SleepingBag;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
/*
Author : PutoPug
 */

public class ItemRegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Items
    public static final RegistryObject<Item> FUNKY_GEM = ITEMS.register("funky_gem", ItemBase::new);
    /*                                              DEPRICATED
    ////////public static final RegistryObject<SleepingBag> GEM = ITEMS.register("gem", SleepingBag::new);

    */
}
