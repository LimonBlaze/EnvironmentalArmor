package io.github.magicquartz.environmentalarmor.registry;

import io.github.magicquartz.environmentalarmor.Enva;
import io.github.magicquartz.environmentalarmor.entity.effect.SimpleStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class EnvaEffects {

    public static final StatusEffect WATER_RESISTANCE_EFFECT = new SimpleStatusEffect(StatusEffectCategory.BENEFICIAL, 0x00BBFF);
    public static final StatusEffect SUNSCREEN_EFFECT = new SimpleStatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFE659);
    public static Potion WATER_RESISTANCE_POTION = new Potion("water_resistance", new StatusEffectInstance(WATER_RESISTANCE_EFFECT,
        Math.max(0, Enva.CONFIG.waterResistance.shortDuration)));
    public static Potion LONG_WATER_RESISTANCE_POTION = new Potion("water_resistance", new StatusEffectInstance(WATER_RESISTANCE_EFFECT,
        Math.max(0, Enva.CONFIG.waterResistance.longDuration)));
    
    public static void register() {
        if(Enva.CONFIG.waterResistance.enable) {
            Registry.register(Registry.STATUS_EFFECT, Enva.identifier("water_resistance"), WATER_RESISTANCE_EFFECT);
            Registry.register(Registry.POTION, Enva.identifier("water_resist_potion_short"), WATER_RESISTANCE_POTION);
            if(Enva.CONFIG.waterResistance.enableLong) {
                Registry.register(Registry.POTION, Enva.identifier("water_resist_potion_long"), LONG_WATER_RESISTANCE_POTION);
            }
        }
        if(Enva.CONFIG.sunscreen.enable) {
            Registry.register(Registry.STATUS_EFFECT, Enva.identifier("sunscreen"), SUNSCREEN_EFFECT);
        }
    }
    
}
