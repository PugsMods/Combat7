package com.putopug.combat7.gui.container;

import com.putopug.combat7.init.BlockRegistryHandler;
import com.putopug.combat7.init.ContainerRegHandler;
import com.putopug.combat7.objects.ti.ItomeTI;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

//
//@author PutoPug
//
public class ItomeContainer extends Container {
    public final ItomeTI te;
    private final IWorldPosCallable canInteractWithCallable;
   public ItomeContainer(final int windowID, PlayerInventory playerInv, final ItomeTI te){
       super(ContainerRegHandler.ITOME_CONTAINER_TYPE.get(), windowID);
       this.te = te;
       this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(),te.getPos());

       //UI
       for (int row = 0 ; row< 3; row++){
           for (int col = 0; col < 9 ;col++){
                this.addSlot(new Slot(playerInv,col + row*9+9, 8+col*18, 166 - (4- row)*18-10));
           }
       }
       //Player hotbar
       for (int col = 0; col < 9 ;col++){
           this.addSlot(new Slot(playerInv,col,8+col*18,142));
       }
       //Ti
       this.addSlot(new Slot((IInventory) te,0,80,35));
   }

    public ItomeContainer(final int windowID, PlayerInventory playerInv, final PacketBuffer data){
        this(windowID,playerInv,getTi(playerInv, data));
   }
   private static ItomeTI getTi(final PlayerInventory playerInv,final PacketBuffer data){
       Objects.requireNonNull(playerInv,"ERROR: Player inventory cannot be NULL");
       Objects.requireNonNull(data,"ERROR: Packet Buffer cannot be NULL");
       final TileEntity te = playerInv.player.world.getTileEntity(data.readBlockPos());
       if (te instanceof ItomeTI){
           return (ItomeTI) te;
       }
       throw new IllegalStateException("ERROR: Tile entity is not an instance of ItomeTI");
   }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable,playerIn, BlockRegistryHandler.ITOME.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
       ItemStack stack = ItemStack.EMPTY;
       Slot slot = this.inventorySlots.get(index);
       if(slot != null && slot.getHasStack()){
           ItemStack s1 = slot.getStack();
           stack = s1.copy();
           if(index < ItomeTI.slts && !this.mergeItemStack(s1, ItomeTI.slts,this.inventorySlots.size(),true)) {
               return ItemStack.EMPTY;
           }
           if(!this.mergeItemStack(s1, 0,ItomeTI.slts,false)){
               return ItemStack.EMPTY;
           }
           if(s1.isEmpty()){
               slot.putStack(ItemStack.EMPTY);
           }
           else {
               slot.onSlotChanged();
           }
       }
        return stack;
    }
}
