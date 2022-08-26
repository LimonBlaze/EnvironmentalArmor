package io.github.magicquartz.environmentalarmor.mixin;

import io.github.apace100.origins.power.OriginsPowerTypes;
import io.github.magicquartz.environmentalarmor.registry.EnvaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);
    
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        if(age % 20 != 0) return;
        if(hasStatusEffect(StatusEffects.WATER_BREATHING)) return;
        boolean submerged = isSubmergedInWater();
        ItemStack helmet = getEquippedStack(EquipmentSlot.HEAD);
        boolean rightHelmet = submerged ?
            helmet.isIn(EnvaItems.Tags.DIVING_HELMETS) :
            helmet.isIn(EnvaItems.Tags.LANDWALKING_HELMETS);
        if(rightHelmet && OriginsPowerTypes.WATER_BREATHING.isActive(this) != submerged) {
            addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 30, 0, true, false));
        }
    }
    
}
