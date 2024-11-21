package personal.vanmuur.glyphmod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import personal.vanmuur.glyphmod.registry.ModBlocks;

import java.util.List;

public class BlankRuneItem extends Item {
    public BlankRuneItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        InteractionHand hand = context.getHand();
        Player player = context.getPlayer();

        if (player == null || level.isClientSide() || hand != InteractionHand.MAIN_HAND) {
            return InteractionResult.PASS;
        }

        BlockState state = level.getBlockState(clickedPos);
        Block block = state.getBlock();

        if (block == Blocks.SANDSTONE) {
            // We want to replace the block at the pos with a WrittenSandstoneBlock.

            level.removeBlock(clickedPos, false);

            level.setBlock(clickedPos, ModBlocks.WRITTEN_SANDSTONE.get().defaultBlockState(), 1);

            player.sendSystemMessage(Component.literal("You just clicked: Standstone."));

            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("A blank rune with shimmering potential in it.").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    //    private int getRandomNumber() {
//        return RandomSource.createNewThreadLocalInstance().nextInt(10);
//    }
}
