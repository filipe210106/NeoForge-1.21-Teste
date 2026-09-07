package com.filipe.tutorialmod.item.custom;

import com.filipe.tutorialmod.block.ModBlocks;
import com.filipe.tutorialmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

import java.util.Map;
import java.util.function.Consumer;

public class AuraItem extends Item {

    private static final Map<Block, Consumer<UseOnContext>> AURA_MAP =
            Map.of(
                    ModBlocks.BETINHA_BLOCK.get(), AuraItem::buildBetinhaStructure
            );

    public AuraItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (AURA_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                AURA_MAP.get(clickedBlock).accept(context);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(context);
    }

    private static void buildBetinhaStructure(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
        if (lightning != null) {
            lightning.moveTo(Vec3.atBottomCenterOf(pos));

            lightning.setVisualOnly(true);

            level.addFreshEntity(lightning);
        }

        level.playSound(
                null,
                pos,
                SoundEvents.LIGHTNING_BOLT_THUNDER,
                SoundSource.PLAYERS,
                1.0F,
                1.0F
        );

        level.playSound(
                null,
                pos,
                ModSounds.SOM_AURA.get(),
                SoundSource.RECORDS,
                1.0F,
                1.0F
        );

        int betinhaHeight = 5;

        for (int i = 1; i <= betinhaHeight; i++) {
            BlockPos currPos = pos.above(i);

            level.setBlock(currPos, ModBlocks.BETINHA_BLOCK.get().defaultBlockState(), 3);
        }

        level.setBlock(pos.east(), ModBlocks.BETINHA_BLOCK.get().defaultBlockState(), 3);
        level.setBlock(pos.west(), ModBlocks.BETINHA_BLOCK.get().defaultBlockState(), 3);
    }
}