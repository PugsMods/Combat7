package com.putopug.combat7.init.items;

import com.putopug.combat7.init.itemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
/*
Author : PutoPug
 */

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(itemGroups.ITEMS));
    }
}
