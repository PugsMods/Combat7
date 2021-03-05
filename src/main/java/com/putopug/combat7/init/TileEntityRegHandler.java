package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import com.putopug.combat7.objects.tileentity.CraftoxBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//
//@author PutoPug
//
public class TileEntityRegHandler {
    public static final DeferredRegister<TileEntityType<?>> TI = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, combat7.MOD_ID);


    public static void init(){
        TI.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TileEntityType<CraftoxBlockTileEntity>> CRAFTOX = TI.register("craftox", () -> TileEntityType.Builder.create(CraftoxBlockTileEntity::new, BlockRegistryHandler.CRAFTOX.get()).build(null));
}
