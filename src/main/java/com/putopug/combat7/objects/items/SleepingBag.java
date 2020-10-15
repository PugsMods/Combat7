package com.putopug.combat7.objects.items;

import com.putopug.combat7.init.itemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
/*
Author : PutoPug
 */

public class SleepingBag extends Item {
    public SleepingBag() {
        super(new Item.Properties().group(itemGroups.ITEMS).rarity(Rarity.RARE));
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, ServerPlayerEntity serverPlayerEntity, Hand handIn) {
        // FIXME: 9/17/2020
        //Here I Go To bed & Cry Cause I Need Mappings
        // BTW It Is 3 AM For Me
        serverPlayerEntity.setBedPosition(BlockPos.ZERO);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
