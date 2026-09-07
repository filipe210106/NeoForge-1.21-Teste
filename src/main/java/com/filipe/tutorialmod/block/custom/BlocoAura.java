package com.filipe.tutorialmod.block.custom;

import com.filipe.tutorialmod.block.ModBlocks;
import com.filipe.tutorialmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.client.event.sound.SoundEvent;


public class BlocoAura extends Block {
    public BlocoAura(Properties properties) {
        super(properties);
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, ModSounds.SOM_AURA.get(), SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }
}