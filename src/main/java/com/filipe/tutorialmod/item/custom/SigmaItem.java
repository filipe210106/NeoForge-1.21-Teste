package com.filipe.tutorialmod.item.custom;

import com.filipe.tutorialmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class SigmaItem extends Item {
    public static final Map<Block, Block> SIGMA_MAP =
            Map.of(
                    ModBlocks.BETINHA_BLOCK.get(), ModBlocks.SIGMA_BLOCK.get()
            );
    public SigmaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBLock = level.getBlockState(context.getClickedPos()).getBlock();

        if(SIGMA_MAP.containsKey(clickedBLock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), SIGMA_MAP.get(clickedBLock).defaultBlockState());

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_DESTROY, SoundSource.BLOCKS);
            }
        }


        return InteractionResult.SUCCESS;
    }
}
