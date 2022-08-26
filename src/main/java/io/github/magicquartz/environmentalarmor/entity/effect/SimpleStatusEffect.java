package io.github.magicquartz.environmentalarmor.entity.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class SimpleStatusEffect extends StatusEffect {
    
    public SimpleStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }
    
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //NO-OP
    }
    
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        //NO-OP
    }
    
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
    
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        //NO-OP
    }
    
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        //NO-OP
    }
    
}
