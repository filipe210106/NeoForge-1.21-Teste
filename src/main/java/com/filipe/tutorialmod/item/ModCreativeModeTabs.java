package com.filipe.tutorialmod.item;

import com.filipe.tutorialmod.TutorialMod;
import com.filipe.tutorialmod.block.ModBlocks;
import com.filipe.tutorialmod.item.custom.SigmaItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MODID);

    public static final Supplier<CreativeModeTab> SIGMA_TAB = CREATIVE_MODE_TAB.register("sigma_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SIGMA.get()))
                    .title(Component.translatable("creativetab.tutorialmod.sigma"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SIGMA);
                        output.accept(ModItems.BETINHA);
                        output.accept(ModItems.DILDO_GOMES);
                        output.accept(ModBlocks.SIGMA_BLOCK);
                        output.accept(ModBlocks.BETINHA_BLOCK);
                        output.accept(ModItems.SIGMA_ITEM);
                        output.accept(ModBlocks.AURA_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
