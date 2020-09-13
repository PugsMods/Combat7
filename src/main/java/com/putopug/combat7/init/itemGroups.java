package com.putopug.combat7.init;

import com.putopug.combat7.init.items.ItemRegistryHandler;
import net.minecraft.item.ItemStack;

public class itemGroups {
    public static final net.minecraft.item.ItemGroup TOOLS = new net.minecraft.item.ItemGroup("c7_tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistryHandler.FUNKY_GEM.get());
        }};
        public static final net.minecraft.item.ItemGroup BLOCKS = new net.minecraft.item.ItemGroup("c7_tools") {
            @Override
            public ItemStack createIcon() {
                return new ItemStack(ItemRegistryHandler.FUNKY_GEM.get());
            }};
        public static final net.minecraft.item.ItemGroup ITEMS = new net.minecraft.item.ItemGroup("c7_tools") {
           @Override
                public ItemStack createIcon() {
                    return new ItemStack(ItemRegistryHandler.FUNKY_GEM.get());
                }};
};
