package io.github.magicquartz.environmentalarmor.item.material.armor;

import io.github.magicquartz.environmentalarmor.registry.EnvaItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class TitaniumCoatedArmorMaterial implements ArmorMaterial {
    @Override
    public int getDurability(EquipmentSlot slot) {
        return 165;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EnvaItems.TITANIUM_INGOT);
    }

    @Override
    public String getName() {
        return "titanium_coated_glass";
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}