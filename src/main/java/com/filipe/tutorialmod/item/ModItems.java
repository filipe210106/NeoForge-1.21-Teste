package com.filipe.tutorialmod.item;

import com.filipe.tutorialmod.TutorialMod;
import com.filipe.tutorialmod.entity.ModEntities;
import com.filipe.tutorialmod.item.custom.AuraItem;
import com.filipe.tutorialmod.item.custom.SigmaItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MODID);

    public static final DeferredItem<Item> SIGMA = ITEMS.register("sigma",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BETINHA = ITEMS.register("betinha",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DILDO_GOMES = ITEMS.register("dildodogomes",
            () -> new AuraItem(new Item.Properties()));

    public static final DeferredItem<Item> SIGMA_ITEM = ITEMS.register("sigma_item",
            ()-> new SigmaItem(new Item.Properties()));

    public static final DeferredItem<Item> BORRACHA_ROSINHA_RAW = ITEMS.register("borracharosinharaw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORRACH_ROSINHA_COOKED = ITEMS.register("borracharosinhanonraw",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
