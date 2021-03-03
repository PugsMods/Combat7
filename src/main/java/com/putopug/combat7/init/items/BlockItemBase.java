package com.putopug.combat7.init.items;

import com.putopug.combat7.init.items.itemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

//
//@author PutoPug
//
public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(itemGroups.BLOCKS));
    }
}