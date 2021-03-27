package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import com.putopug.combat7.objects.entities.hamster.HamsterEntity;
import com.putopug.combat7.objects.entities.pug.PugEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
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
    public static final RegistryObject<EntityType<PugEntity>> PUG = ENTITIES
            .register("pug",() -> EntityType.Builder.<PugEntity>create(PugEntity::new, EntityClassification.CREATURE)
                    .size(0.5f,0.9f)
                    .build(new ResourceLocation(combat7.MOD_ID, "pug").toString()));
    public static final RegistryObject<EntityType<HamsterEntity>> HAMSTER = ENTITIES
            .register("hamster",() -> EntityType.Builder.<HamsterEntity>create(HamsterEntity::new, EntityClassification.CREATURE)
                    .size(0.2f,0.25f)
                    .build(new ResourceLocation(combat7.MOD_ID, "hamster").toString()));
}
