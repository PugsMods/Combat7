package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/*
 * @author: PutoPug
 */
public class EntityRegHandler {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, combat7.MOD_ID);


    public static void init(){
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
