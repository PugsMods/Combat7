package com.putopug.combat7.world.dimension;

import com.putopug.combat7.combat7;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

/*
 * @author: PutoPug
 */
public class Combat7Dimensions {
    public static final RegistryKey<DimensionType> FUNKY_TYPE = RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(combat7.MOD_ID,"funky_world"));
    public static final RegistryKey<World> FUNKY_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(combat7.MOD_ID,"funky_world"));
}
