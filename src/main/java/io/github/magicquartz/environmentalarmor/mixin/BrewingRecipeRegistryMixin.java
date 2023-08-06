package io.github.magicquartz.environmentalarmor.mixin;

import io.github.magicquartz.environmentalarmor.Enva;
import io.github.magicquartz.environmentalarmor.registry.EnvaEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public abstract class BrewingRecipeRegistryMixin {
    
    @Invoker("registerPotionRecipe")
    private static void callRegisterPotionRecipe(Potion input, Item item, Potion output) {
        throw new AssertionError();
    }
    
    @Inject(method = "registerDefaults", at = @At("HEAD"))
    private static void enva$registerDefaults(CallbackInfo ci) {
        if(!Enva.CONFIG.waterResistance.enable) return;
        
        Identifier potionId = Identifier.tryParse(Enva.CONFIG.waterResistance.potionIngredient);
        Potion potion = Potions.EMPTY;
        if(potionId == null) {
            potionId = new Identifier("awkward");
            Enva.CONFIG.waterResistance.potionIngredient = potionId.toString();
        } else potion = Registry.POTION.get(potionId);
        if(potion == Potions.EMPTY) potion = Potions.AWKWARD;
        
        Identifier itemId = Identifier.tryParse(Enva.CONFIG.waterResistance.itemIngredient);
        Item item = Items.AIR;
        if(itemId == null) {
            itemId = new Identifier("scute");
            Enva.CONFIG.waterResistance.itemIngredient = itemId.toString();
        } else item = Registry.ITEM.get(itemId);
        if(item == Items.AIR) item = Items.SCUTE;
        
        callRegisterPotionRecipe(potion, item, EnvaEffects.WATER_RESISTANCE_POTION);
        
        if(!Enva.CONFIG.waterResistance.enableLong) return;
        
        callRegisterPotionRecipe(EnvaEffects.WATER_RESISTANCE_POTION, Items.REDSTONE, EnvaEffects.LONG_WATER_RESISTANCE_POTION);
    }
    
}
