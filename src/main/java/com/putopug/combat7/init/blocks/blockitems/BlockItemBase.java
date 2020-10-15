package com.putopug.combat7.init.blocks.blockitems;

import com.putopug.combat7.combat7;
import com.putopug.combat7.init.itemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
/*
Author : PutoPug
 */

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(itemGroups.BLOCKS));
    }
}