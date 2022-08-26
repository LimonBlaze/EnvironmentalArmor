package io.github.magicquartz.environmentalarmor.mixin;

import io.github.magicquartz.environmentalarmor.Enva;
import io.github.magicquartz.environmentalarmor.entity.damage.SimpleDamageSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mixin(PlayerEntity.class)
public abstract class FirstApril extends LivingEntity {

    @Shadow public abstract boolean damage(DamageSource source, float amount);

    protected FirstApril(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "attack")
    private void attack(CallbackInfo info) { // For bees.
        if(Enva.STINGER.isActive(this)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
            LocalDateTime now = LocalDateTime.now();
            if(dtf.format(now).equals("04/01")) {
                damage(SimpleDamageSource.NATURAL_CAUSES, getHealth());
            }
        }
    }
}
