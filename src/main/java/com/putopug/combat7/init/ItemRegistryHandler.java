package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
//import com.putopug.combat7.objects.items.SleepingBag;
//import com.putopug.combat7.objects.items.TestItem;
import com.putopug.combat7.init.items.ItemBase;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//
//@author PutoPug
//
public class ItemRegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Items
    public static final RegistryObject<Item> FUNKY_GEM = ITEMS.register("funky_gem", ItemBase::new);
    /*                                              DEPRICATED
        public static final RegistryObject<SleepingBag> GEM = ITEMS.register("gem", SleepingBag::new);
        public static final RegistryObject<TestItem> TESTITEM = ITEMS.register("test", TestiItem::new);
        public static final RegistryObject<Item> COMPRONIUM_BUS = ITEMS.register("compronium_bus", ItemBase::new);
        public static final RegistryObject<Item> SHIELDED_COMPRONIUM_BUS = ITEMS.register("shielded_compronium_bus", ItemBase::new);
        public static final RegistryObject<Item> REINFORCED_LEATHER = ITEMS.register("reinforced_leather", ItemBase::new);
        public static final RegistryObject<Item> LATCH = ITEMS.register("locking_latch", ItemBase::new);
        public static final RegistryObject<Item> BUS_CONNECTOR = ITEMS.register("bus_connector", ItemBase::new);
    */
}
