package com.putopug.combat7.init;

import com.putopug.combat7.combat7;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class sound {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, combat7.MOD_ID);
    public static void init(){
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
    public static final Lazy<SoundEvent> LAZY_PUG_LOVE = Lazy.of(() -> new SoundEvent(new ResourceLocation(combat7.MOD_ID, "disc.puglove")));
    public static final RegistryObject<SoundEvent> PUG_LOVE = SOUNDS.register("pug_love", LAZY_PUG_LOVE);
}
