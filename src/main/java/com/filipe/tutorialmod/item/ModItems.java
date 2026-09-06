package com.filipe.tutorialmod.item;

import com.filipe.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MODID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GOMES = ITEMS.register("gomes",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
