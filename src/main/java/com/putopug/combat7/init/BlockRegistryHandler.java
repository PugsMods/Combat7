package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import com.putopug.combat7.objects.blocks.CraftoxBlock;
import com.putopug.combat7.objects.blocks.DirteeBlock;
import com.putopug.combat7.objects.blocks.FunkyBlock;
import com.putopug.combat7.init.items.BlockItemBase;
import com.putopug.combat7.objects.blocks.SpeedBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//
//@author PutoPug
//
public class BlockRegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, combat7.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, combat7.MOD_ID);


    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }



    //BLOCKS
    public static final RegistryObject<Block> FUNKY_BLOCK = BLOCKS.register("funky_block", FunkyBlock::new);
    public static final RegistryObject<Block> SPEED_BLOCK = BLOCKS.register("speed_block", SpeedBlock::new);
    public static final RegistryObject<Block> DIRTEE_BLOCK = BLOCKS.register("dirtee_block", DirteeBlock::new);
    public static final RegistryObject<CraftoxBlock> CRAFTOX = BLOCKS.register("craftox", CraftoxBlock::new);

    //BLOCK ITEMS
    public static final RegistryObject<Item> FUNKY_BLOCK_ITEM = ITEMS.register("funky_block", () -> new BlockItemBase(FUNKY_BLOCK.get()));
    public static final RegistryObject<Item> SPEED_BLOCK_ITEM = ITEMS.register("speed_block", () -> new BlockItemBase(SPEED_BLOCK.get()));
    public static final RegistryObject<Item> CRAFTOX_ITEM = ITEMS.register("craftox", () -> new BlockItemBase(CRAFTOX.get()));
}
