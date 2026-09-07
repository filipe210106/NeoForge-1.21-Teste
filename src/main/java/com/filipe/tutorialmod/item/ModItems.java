package com.filipe.tutorialmod.item;

import com.filipe.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MODID);

    public static final DeferredItem<Item> SIGMA = ITEMS.register("sigma",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BETINHA = ITEMS.register("betinha",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DILDO_GOMES = ITEMS.register("dildodogomes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORRACHA_ROSINHA_RAW = ITEMS.register("borracharosinharaw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORRACH_ROSINHA_COOKED = ITEMS.register("borracharosinhanonraw",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
