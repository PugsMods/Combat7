package com.putopug.combat7.init;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.putopug.combat7.combat7.MOD_ID;

//
//@author PutoPug
//
public class BiomeDummyHolder {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MOD_ID);
    public static void init(){
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // Dummy biomes to reserve the numeric ID safely for the json biomes to overwrite.
    // No static variable to hold as these dummy biomes should NOT be held and referenced elsewhere.
    static {
        createBiome("funky_land", BiomeMaker::makeSavannaPlateauBiome);
        createBiome("moziac", BiomeMaker::makeJungleHillsBiome);
    }
    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) {
        return BIOMES.register(name, biome);
    }
}