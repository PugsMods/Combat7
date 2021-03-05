package com.putopug.combat7.objects.tileentity;

import com.putopug.combat7.init.TileEntityRegHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

//
//@author PutoPug
//
public class CraftoxBlockTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    public CraftoxBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public CraftoxBlockTileEntity {
        this(TileEntityRegHandler.CRAFTOX.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.combat7.craftox");
    }

    @Nullable
    @Override
    public Container createMenu(int windowID, PlayerInventory playerInv, PlayerEntity playerIn) {
        return new CraftoxContainer(windowID,playerIn,this);
    }

    @Override
    public void tick() {

    }

    @Override
    public TileEntity getTileEntity() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {

    }

    @Override
    public void deserializeNBT(BlockState state, CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT serializeNBT() {
        return null;
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {

    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {

    }

    @Override
    public void onChunkUnloaded() {

    }

    @Override
    public void onLoad() {

    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return null;
    }

    @Override
    public void requestModelDataUpdate() {

    }

    @Nonnull
    @Override
    public IModelData getModelData() {
        return null;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        return null;
    }
}
