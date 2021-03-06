
package com.putopug.combat7.objects.blocks;

import com.putopug.combat7.init.items.itemGroups;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IWorld;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.NetworkManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import javax.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Collections;
import java.util.stream.Stream;

import io.netty.buffer.Unpooled;

import com.putopug.combat7.gui.CraftoxUIGui;
import com.putopug.combat7.Combat7Stuff;

@Combat7Stuff.ModElement.Tag
public class CraftoxBlock extends Combat7Stuff.ModElement {
    @ObjectHolder("combat7:craftox")
    public static final Block block = null;
    @ObjectHolder("combat7:craftox")
    public static final TileEntityType<CraftoxTI> tileEntityType = null;
    public CraftoxBlock(Combat7Stuff instance) {
        super(instance, 5);
        FMLJavaModLoadingContext.get().getModEventBus().register(new CraftoxTIRegHandler());
    }

    @Override
    public void initElements() {
        elements.blocks.add(() -> new BlockCus());
        elements.items.add(() -> new BlockItem(block, new Item.Properties().group(itemGroups.BLOCKS)).setRegistryName(block.getRegistryName()));
    }
    private static class CraftoxTIRegHandler {
        @SubscribeEvent
        public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(CraftoxTI::new, block).build(null).setRegistryName("craftox"));
        }
    }

    public static class BlockCus extends Block {
        public static final DirectionProperty HOR_FACE = BlockStateProperties.HORIZONTAL_FACING;
        protected  static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction,VoxelShape>();

        public BlockCus() {
            super(Block.Properties.create(Material.WOOD).sound(SoundType.CHAIN).hardnessAndResistance(1.05f, 10.5f).setLightLevel(s -> 1)
                    .harvestLevel(1).harvestTool(ToolType.AXE).slipperiness(0.7f));
            setRegistryName("craftox");
            this.setDefaultState(this.stateContainer.getBaseState().with(HOR_FACE, Direction.NORTH));
            runCalc(Stream.of(
                    Block.makeCuboidShape(0, 14, 0, 16, 17, 16),
                    Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
                    Block.makeCuboidShape(13, 1, 0, 16, 14, 3),
                    Block.makeCuboidShape(0, 1, 0, 3, 14, 3),
                    Block.makeCuboidShape(0, 1, 13, 3, 14, 16),
                    Block.makeCuboidShape(13, 1, 13, 16, 14, 16)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get());

        }
        @SuppressWarnings("deprecation")
        @Override
        public BlockState mirror(BlockState state, Mirror mirrorIn) {
            return state.rotate(mirrorIn.toRotation(state.get(HOR_FACE)));
        }

        @Override
        public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
            return state.with(HOR_FACE, direction.rotate(state.get(HOR_FACE)));
        }

        @Nullable
        @Override
        public BlockState getStateForPlacement(BlockItemUseContext context) {
            return this.getDefaultState().with(HOR_FACE, context.getPlacementHorizontalFacing().getOpposite());
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            super.fillStateContainer(builder);
            builder.add(HOR_FACE);
        }

        @Override
        public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
            return SHAPES.get(state.get(HOR_FACE));
        }
        protected static void calculateShapes(Direction to, VoxelShape shape) {
            VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };

            int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
            for (int i = 0; i < times; i++) {
                buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
                        VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
                buffer[0] = buffer[1];
                buffer[1] = VoxelShapes.empty();
            }

            SHAPES.put(to, buffer[0]);
        }

        protected void runCalc(VoxelShape shape) {
            for (Direction direction : Direction.values()) {
                calculateShapes(direction, shape);
            }
        }

        @Override
        public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
            List<ItemStack> dropsOriginal = super.getDrops(state, builder);
            if (!dropsOriginal.isEmpty())
                return dropsOriginal;
            return Collections.singletonList(new ItemStack(this, 1));
        }

        @Override
        public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
                                                 BlockRayTraceResult hit) {
            super.onBlockActivated(state, world, pos, entity, hand, hit);
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            if (entity instanceof ServerPlayerEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
                    @Override
                    public ITextComponent getDisplayName() {
                        return new StringTextComponent("Craftox");
                    }

                    @Override
                    public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
                        return new CraftoxUIGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(new BlockPos(x, y, z)));
                    }
                }, new BlockPos(x, y, z));
            }
            return ActionResultType.SUCCESS;
        }

        @Override
        public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
        }

        @Override
        public boolean hasTileEntity(BlockState state) {
            return true;
        }

        @Override
        public TileEntity createTileEntity(BlockState state, IBlockReader world) {
            return new CraftoxTI();
        }

        @Override
        public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
            super.eventReceived(state, world, pos, eventID, eventParam);
            TileEntity tileentity = world.getTileEntity(pos);
            return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
        }

        @Override
        public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
            if (state.getBlock() != newState.getBlock()) {
                TileEntity tileentity = world.getTileEntity(pos);
                if (tileentity instanceof CraftoxTI) {
                    InventoryHelper.dropInventoryItems(world, pos, (CraftoxTI) tileentity);
                    world.updateComparatorOutputLevel(pos, this);
                }
                super.onReplaced(state, world, pos, newState, isMoving);
            }
        }

        @Override
        public boolean hasComparatorInputOverride(BlockState state) {
            return true;
        }

        @Override
        public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
            TileEntity tileentity = world.getTileEntity(pos);
            if (tileentity instanceof CraftoxTI)
                return Container.calcRedstoneFromInventory((CraftoxTI) tileentity);
            else
                return 0;
        }
    }

    public static class CraftoxTI extends LockableLootTileEntity implements ISidedInventory {
        private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);
        protected CraftoxTI() {
            super(tileEntityType);
        }

        @Override
        public void read(BlockState blockState, CompoundNBT compound) {
            super.read(blockState, compound);
            if (!this.checkLootAndRead(compound)) {
                this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
            }
            ItemStackHelper.loadAllItems(compound, this.stacks);
        }

        @Override
        public CompoundNBT write(CompoundNBT compound) {
            super.write(compound);
            if (!this.checkLootAndWrite(compound)) {
                ItemStackHelper.saveAllItems(compound, this.stacks);
            }
            return compound;
        }

        @Override
        public SUpdateTileEntityPacket getUpdatePacket() {
            return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
        }

        @Override
        public CompoundNBT getUpdateTag() {
            return this.write(new CompoundNBT());
        }

        @Override
        public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
            this.read(this.getBlockState(), pkt.getNbtCompound());
        }

        @Override
        public int getSizeInventory() {
            return stacks.size();
        }

        @Override
        public boolean isEmpty() {
            for (ItemStack itemstack : this.stacks)
                if (!itemstack.isEmpty())
                    return false;
            return true;
        }

        @Override
        public ITextComponent getDefaultName() {
            return new StringTextComponent("craftox");
        }

        @Override
        public int getInventoryStackLimit() {
            return 64;
        }

        @Override
        public Container createMenu(int id, PlayerInventory player) {
            return new CraftoxUIGui.GuiContainerMod(id, player, new PacketBuffer(Unpooled.buffer()).writeBlockPos(this.getPos()));
        }

        @Override
        public ITextComponent getDisplayName() {
            return new StringTextComponent("Craftox");
        }

        @Override
        protected NonNullList<ItemStack> getItems() {
            return this.stacks;
        }

        @Override
        protected void setItems(NonNullList<ItemStack> stacks) {
            this.stacks = stacks;
        }

        @Override
        public boolean isItemValidForSlot(int index, ItemStack stack) {
            return true;
        }

        @Override
        public int[] getSlotsForFace(Direction side) {
            return IntStream.range(0, this.getSizeInventory()).toArray();
        }

        @Override
        public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
            return this.isItemValidForSlot(index, stack);
        }

        @Override
        public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
            return true;
        }
        private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());
        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
            if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
                return handlers[facing.ordinal()].cast();
            return super.getCapability(capability, facing);
        }

        @Override
        public void remove() {
            super.remove();
            for (LazyOptional<? extends IItemHandler> handler : handlers)
                handler.invalidate();
        }
    }
}
