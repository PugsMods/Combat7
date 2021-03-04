package com.putopug.combat7.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//
//@author PutoPug
//
public class CraftoxBlock extends Block {
    public static final DirectionProperty HOR_FACE = BlockStateProperties.HORIZONTAL_FACING;
    protected  static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction,VoxelShape>();
    public CraftoxBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(6.0F,6.0F)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .setLightLevel((lightlevel) -> 10)
        );
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
}
