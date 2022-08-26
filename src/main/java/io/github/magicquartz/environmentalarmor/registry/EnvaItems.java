package io.github.magicquartz.environmentalarmor.registry;

import io.github.magicquartz.environmentalarmor.Enva;
import io.github.magicquartz.environmentalarmor.item.GlassBowlItem;
import io.github.magicquartz.environmentalarmor.item.SunscreenItem;
import io.github.magicquartz.environmentalarmor.item.material.armor.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class EnvaItems {
    
    //Glass
    public static final ArmorItem WATER_GLASS_BOWL = new ArmorItem(new WaterGlassArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings());
    public static final GlassBowlItem GLASS_BOWL = new GlassBowlItem(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1), WATER_GLASS_BOWL);
    public static final ArmorItem GLASS_HELMET = new ArmorItem(new GlassArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ArmorItem GLASSES = new ArmorItem(new GlassesArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.COMMON));
    
    //Titanium
    public static final Item TITANIUM_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item TITANIUM_DUST = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final ArmorItem TITANIUM_HELMET = new ArmorItem(new TitaniumArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ArmorItem TITANIUM_CHESTPLATE = new ArmorItem(new TitaniumArmorMaterial(), EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ArmorItem TITANIUM_LEGGINGS = new ArmorItem(new TitaniumArmorMaterial(), EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ArmorItem TITANIUM_BOOTS = new ArmorItem(new TitaniumArmorMaterial(), EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));
    public static final BlockItem TITANIUM_ORE = new BlockItem(EnvaBlocks.TITANIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem TITANIUM_BLOCK = new BlockItem(EnvaBlocks.TITANIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final SunscreenItem SUNSCREEN = new SunscreenItem(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(Math.max(1, Enva.CONFIG.sunscreen.maxUses - 1)));
    public static final BlockItem AIR_FILTER = new BlockItem(EnvaBlocks.AIR_FILTER, new Item.Settings().group(ItemGroup.DECORATIONS));
    
    //Titanium Coated
    public static final Item TITANIUM_COATED_WATER_GLASS_BOWL = new ArmorItem(new TitaniumCoatedArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings());
    public static final GlassBowlItem TITANIUM_COATED_GLASS_BOWL = new GlassBowlItem(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1), TITANIUM_COATED_WATER_GLASS_BOWL);
    public static final Item TITANIUM_COATED_GLASS_HELMET = new ArmorItem(new TitaniumCoatedArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    
    public static void register() {
        //Glass
        if(Enva.CONFIG.glass.enableGlassBowl) {
            Registry.register(Registry.ITEM, Enva.identifier("water_glass_bowl"), EnvaItems.WATER_GLASS_BOWL);
            Registry.register(Registry.ITEM, Enva.identifier("glass_bowl"), GLASS_BOWL);
        }
        if(Enva.CONFIG.glass.enableGlassHelmet) {
            Registry.register(Registry.ITEM, Enva.identifier("glass_helmet"), EnvaItems.GLASS_HELMET);
        }
        if(Enva.CONFIG.glass.enableGlasses) {
            Registry.register(Registry.ITEM, Enva.identifier("glasses"), EnvaItems.GLASSES);
        }
        //Titanium
        if(Enva.CONFIG.titanium.enable) {
            Registry.register(Registry.ITEM, Enva.identifier("titanium_ingot"), TITANIUM_INGOT);
            Registry.register(Registry.ITEM, Enva.identifier("titanium_dust"), TITANIUM_DUST);
            Registry.register(Registry.ITEM, Enva.identifier("titanium_ore"), TITANIUM_ORE);
            Registry.register(Registry.ITEM, Enva.identifier("titanium_block"), TITANIUM_BLOCK);
            if(Enva.CONFIG.titanium.enableArmor) {
                Registry.register(Registry.ITEM, Enva.identifier("titanium_helmet"), EnvaItems.TITANIUM_HELMET);
                Registry.register(Registry.ITEM, Enva.identifier("titanium_chestplate"), EnvaItems.TITANIUM_CHESTPLATE);
                Registry.register(Registry.ITEM, Enva.identifier("titanium_leggings"), EnvaItems.TITANIUM_LEGGINGS);
                Registry.register(Registry.ITEM, Enva.identifier("titanium_boots"), EnvaItems.TITANIUM_BOOTS);
            }
            if(Enva.CONFIG.airFilter.enable) {
                Registry.register(Registry.ITEM, Enva.identifier("air_filter"), AIR_FILTER);
            }
            if(Enva.CONFIG.sunscreen.enable) {
                Registry.register(Registry.ITEM, Enva.identifier("sunscreen"), SUNSCREEN);
            }
            //Titanium Coated
            if(Enva.CONFIG.titanium.enableTitaniumCoatedGlassBowl) {
                Registry.register(Registry.ITEM, Enva.identifier("titanium_coated_water_glass_bowl"), EnvaItems.TITANIUM_COATED_WATER_GLASS_BOWL);
                Registry.register(Registry.ITEM, Enva.identifier("titanium_coated_glass_bowl"), TITANIUM_COATED_GLASS_BOWL);
            }
            if(Enva.CONFIG.titanium.enableTitaniumCoatedGlassHelmet) {
                Registry.register(Registry.ITEM, Enva.identifier("titanium_coated_glass_helmet"), EnvaItems.TITANIUM_COATED_GLASS_HELMET);
            }
        }
    }
    
    public static class Tags {
        
        public static final TagKey<Item> DIVING_HELMETS = TagKey.of(Registry.ITEM_KEY, Enva.identifier("diving_helmets"));
        public static final TagKey<Item> LANDWALKING_HELMETS = TagKey.of(Registry.ITEM_KEY, Enva.identifier("landwalking_helmets"));
    
    }
    
}
