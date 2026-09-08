package com.filipe.tutorialmod.item.custom;

import com.filipe.tutorialmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import com.filipe.tutorialmod.effect.GordoEffect;
import net.neoforged.fml.common.Mod;

public class ModFoodProperties {
    public static final FoodProperties BIGMAC = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0f)
            .alwaysEdible().effect(() -> new MobEffectInstance(ModEffects.GORDO_EFFECT, 800),1.0f).build();
}
