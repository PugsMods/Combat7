package com.putopug.combat7.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

//
//@author PutoPug
//
public class SpeedBlock extends Block {
    public SpeedBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(7.0F,7.0F)
                .jumpFactor(1.0F)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(8)
                .setRequiresTool()
                .slipperiness(1.5F)
        );
    }
}
