package com.putopug.combat7.init.blocks;

import com.putopug.combat7.combat7;
import com.putopug.combat7.init.blocks.blockclass.FunkyBlock;
import com.putopug.combat7.init.blocks.blockitems.BlockItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, combat7.MOD_ID);


    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }



    //BLOCKS
    public static final RegistryObject<Block> FUNKY_BLOCK = BLOCKS.register("funky_block", FunkyBlock::new);
    public static final RegistryObject<Block> POOP_BLOCK = BLOCKS.register("poop_ruthikispoop", FunkyBlock::new);



    //BLOCK ITEMS
    public static final RegistryObject<Item> FUNKY_BLOCK_ITEM = ITEMS.register("funky_block", () -> new BlockItemBase(FUNKY_BLOCK.get()));
    public static final RegistryObject<Item> POOP_BLOCK_ITEM = ITEMS.register("poop_ruthikispoop", () -> new BlockItemBase(POOP_BLOCK.get()));
}
