package com.putopug.combat7.init.items;

import com.putopug.combat7.init.BlockRegistryHandler;
import com.putopug.combat7.init.ItemRegistryHandler;
import com.putopug.combat7.init.ToolRegistryHandler;
import net.minecraft.item.ItemStack;

//
//@author PutoPug
//
public class itemGroups {
    public static final net.minecraft.item.ItemGroup TOOLS = new net.minecraft.item.ItemGroup("c7_tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ToolRegistryHandler.EMERALD_SWORD.get());
        }};

        public static final net.minecraft.item.ItemGroup BLOCKS = new net.minecraft.item.ItemGroup("c7_blocks") {
        @Override
            public ItemStack createIcon() {
                return new ItemStack(BlockRegistryHandler.FUNKY_BLOCK.get());
            }};

        public static final net.minecraft.item.ItemGroup ITEMS = new net.minecraft.item.ItemGroup("c7_items") {
        @Override
            public ItemStack createIcon() {
                    return new ItemStack(ItemRegistryHandler.FUNKY_GEM.get());
                }};
};
