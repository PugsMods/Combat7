package com.putopug.combat7.objects.blocks;

import com.putopug.combat7.combat7;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

//
//@author PutoPug
//
public class FunkyPortal extends Block {

    public FunkyPortal() {
        super(Properties.create(Material.IRON));
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);
        //entityIn.changeDimension(DimensionType.);
    }
}
