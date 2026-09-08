package com.filipe.tutorialmod.client;

import com.filipe.tutorialmod.effect.GordoEffect;
import com.filipe.tutorialmod.effect.ModEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;

public class GordoRender {
        @SubscribeEvent
        public static void onRenderPlayer(RenderPlayerEvent.Pre event) {

            Player player = event.getEntity();

            if (player.hasEffect(ModEffects.GORDO_EFFECT)) {
                event.getPoseStack().scale(2.0F, 1.0F, 2.0F);
            }
        }
}
