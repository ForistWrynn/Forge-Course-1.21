package net.forist.mccourse.block;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties
{
    public static final FoodProperties KOHLRABI = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F).build();

    public static final FoodProperties URIELMOCHI = new FoodProperties.Builder().nutrition(4).saturationModifier(1f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 3), 1.0f).alwaysEdible().build();

    public static final FoodProperties LEVINAMOCHI = new FoodProperties.Builder().nutrition(4).saturationModifier(1f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 2), 1.0f).alwaysEdible().build();
}
