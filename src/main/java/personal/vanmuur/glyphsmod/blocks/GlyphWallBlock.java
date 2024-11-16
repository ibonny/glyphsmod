package personal.vanmuur.glyphsmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import personal.vanmuur.glyphsmod.registry.ModTileEntities;

public class GlyphWallBlock extends Block {
    public GlyphWallBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
            BlockHitResult hit) {
        if (!level.isClientSide) {
            // Check if the block can be painted with a glyph (you could trigger this with
            // an item)
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof GlyphWallTileEntity) {
                GlyphWallTileEntity tileEntity = (GlyphWallTileEntity) blockEntity;
                // Paint a glyph to the TileEntity (this could involve the item in the player's
                // hand)
                tileEntity.paintGlyph(player.getMainHandItem());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    // Optional: Check if the block is part of a larger multiblock (you'll need to
    // implement this)
    private boolean isPartOfMultiblock(Level level, BlockPos pos) {
        // Check for adjacent blocks and verify they're part of the same multiblock
        // structure
        return true; // Implement your multiblock checking logic here
    }

    private boolean isMultiblockValid(Level level, BlockPos pos) {
        // Check neighboring blocks to see if they are all part of the multiblock
        return level.getBlockState(pos.north()).getBlock() instanceof GlyphWallBlock;
    }

}
