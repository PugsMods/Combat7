package com.putopug.combat7.objects.ti;

import com.putopug.combat7.init.TileEntityRegHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import com.putopug.combat7.gui.container.ItomeContainer;

//
//@author PutoPug
//
public class ItomeTI extends LockableLootTileEntity {
    protected ItomeTI(TileEntityType<?> typeIn) {
        super(typeIn);
    }
    public ItomeTI() {
        this(TileEntityRegHandler.ITOME_TI_TYPE.get());
    }
    public static final int slts = 1;
    protected NonNullList<ItemStack> items = NonNullList.withSize(slts,ItemStack.EMPTY);
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("conatiner.combat7.itome");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new ItomeContainer(id,player,this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    @Override
    public int getSizeInventory() {
        return slts;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if(!this.checkLootAndWrite(compound)){
            ItemStackHelper.saveAllItems(compound, this.items);
        }
        return compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        if(!this.checkLootAndRead(nbt)){
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
    }
}
