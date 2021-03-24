/*
 ____                                    ___    ___              __
/\  _`\                                 /\_ \  /\_ \            /\ \
\ \ \/\_\     __      ___     ___     __\//\ \ \//\ \      __   \_\ \
 \ \ \/_/_  /'__`\  /' _ `\  /'___\ /'__`\\ \ \  \ \ \   /'__`\ /'_` \
  \ \ \L\ \/\ \L\.\_/\ \/\ \/\ \__//\  __/ \_\ \_ \_\ \_/\  __//\ \L\ \
   \ \____/\ \__/.\_\ \_\ \_\ \____\ \____\/\____\/\____\ \____\ \___,_\
    \/___/  \/__/\/_/\/_/\/_/\/____/\/____/\/____/\/____/\/____/\/__,_ /


 ____                ____           __
/\  _`\             /\  _`\        /\ \__
\ \ \L\ \  __  __   \ \ \L\ \__  __\ \ ,_\   ___   _____   __  __     __
 \ \  _ <'/\ \/\ \   \ \ ,__/\ \/\ \\ \ \/  / __`\/\ '__`\/\ \/\ \  /'_ `\
  \ \ \L\ \ \ \_\ \   \ \ \/\ \ \_\ \\ \ \_/\ \L\ \ \ \L\ \ \ \_\ \/\ \L\ \
   \ \____/\/`____ \   \ \_\ \ \____/ \ \__\ \____/\ \ ,__/\ \____/\ \____ \
    \/___/  `/___/> \   \/_/  \/___/   \/__/\/___/  \ \ \/  \/___/  \/___L\ \
               /\___/                                \ \_\            /\____/
               \/__/                                  \/_/            \_/__/

package com.putopug.combat7.objects.items;


import com.putopug.combat7.init.items.itemGroups;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import com.putopug.combat7.util.helpers.keyboardhelper;

import java.util.List;

//
//@author PutoPug
//
public class TestItem extends Item {

    // FIXME: 9/9/2020

    public TestItem()
    {
        super(new Item.Properties().group(itemGroups.BLOCKS));
    }
    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (keyboardhelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("Makes It Rain :-("));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold"+"\u00A7e"+" SHIFT "+"\u00A77"+"For More Information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRaining())
                    worldIn.setRainStrength(0.0f);

        else

                worldIn.setRainStrength(1.0f);




        playerIn.getCooldownTracker().setCooldown(this, 20);



        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    }
*/
