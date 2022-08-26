package io.github.magicquartz.environmentalarmor.item;

import io.github.magicquartz.environmentalarmor.Enva;
import io.github.magicquartz.environmentalarmor.registry.EnvaEffects;
import io.github.magicquartz.environmentalarmor.registry.EnvaItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SunscreenItem extends Item {

    public SunscreenItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack leftover = user.getStackInHand(hand);
        //Only force consume the sunscreen when sneaking, so there won't be misoperation problems
        if(user.isSneaking() || !user.hasStatusEffect(EnvaEffects.SUNSCREEN_EFFECT)) {
            int dmg = leftover.getDamage();
            if(dmg == leftover.getMaxDamage())
                leftover = ItemStack.EMPTY;
            else
                leftover.setDamage(dmg + 1);
            user.addStatusEffect(new StatusEffectInstance(EnvaEffects.SUNSCREEN_EFFECT,
                Enva.CONFIG.sunscreen.duration,
                0, false, false));
            user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1, 1);
            return TypedActionResult.success(leftover, world.isClient);
        }
        return TypedActionResult.pass(leftover);
    }
    
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(EnvaItems.TITANIUM_DUST) || super.canRepair(stack, ingredient);
    }
    
}