package com.putopug.combat7.init.blocks.blockclass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


/*
Author : PutoPug
 */

public class FunkyBlock extends Block {
    public FunkyBlock() {

        super(Properties.create(Material.IRON)
        .hardnessAndResistance(6.0F,6.0F)
        .jumpFactor(10.0F)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(4)
        .func_235838_a_((lightLevel) -> 10)
        .func_235861_h_()



        );

    }
}
