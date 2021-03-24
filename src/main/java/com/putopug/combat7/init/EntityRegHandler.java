package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import com.putopug.combat7.objects.entities.HamsterEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
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
    public static final RegistryObject<EntityType<HamsterEntity>> HAMSTER = ENTITIES.register("hamster",() -> EntityType.Builder.create(HamsterEntity::new, EntityClassification.CREATURE).size(0.3F,0.3F).setShouldReceiveVelocityUpdates(true).build("hamster"));
}
