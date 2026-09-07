package com.filipe.tutorialmod.block;

import com.filipe.tutorialmod.TutorialMod;
import com.filipe.tutorialmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TutorialMod.MODID);

    //Blocos adicionados
    public static final DeferredBlock<Block> SIGMA_BLOCK = registerBlock("sigma_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1f)));

    public static final DeferredBlock<Block> BETINHA_BLOCK = registerBlock("betinha_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1f)));

    public static final DeferredBlock<Block> BORRACHA_ROSA_BLOCK = registerBlock("borracha_rosa_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.AMETHYST).strength(1f)));

    public static final DeferredBlock<Block> BORRACHA_ROSA_RAW_BLOCK = registerBlock("borracha_rosa_raw_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.AMETHYST).strength(1f)));


    //Blocos adicionados
    private static <T extends Block> DeferredBlock<T>  registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
