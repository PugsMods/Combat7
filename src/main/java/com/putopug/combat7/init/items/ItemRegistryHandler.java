package com.putopug.combat7.init.items;

import com.putopug.combat7.combat7;
import com.putopug.combat7.init.itemGroups;
import com.putopug.combat7.init.sound;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Items
    public static final RegistryObject<Item> FUNKY_GEM = ITEMS.register("funky_gem", ItemBase::new);
    public static final RegistryObject<Item> PUG_LOVE = ITEMS.register("pug_disc", () -> new ModMusicDisc(5, sound.PUG_LOVE,new Item.Properties().group(itemGroups.ITEMS).maxStackSize(1).rarity(Rarity.EPIC)));
}
