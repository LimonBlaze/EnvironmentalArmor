package io.github.magicquartz.environmentalarmor.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.Config.Gui.Background;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "environmental_armor_config")
@Background("enva:textures/blocks/titanium_block")
public class EnvaConfig implements ConfigData {
    
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.RequiresRestart
    public Glass glass = new Glass();
    
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.RequiresRestart
    public Titanium titanium = new Titanium();
    
    @ConfigEntry.Gui.CollapsibleObject
    public Sunscreen sunscreen = new Sunscreen();
    
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.RequiresRestart
    public WaterResistance waterResistance = new WaterResistance();
    
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.RequiresRestart
    public AirFilter airFilter = new AirFilter();
    
    public static class Glass {
        
        public boolean enableGlassBowl = true;
        public boolean enableGlassHelmet = true;
        public boolean enableGlasses = true;
        
    }
    
    public static class Titanium {
        
        public boolean enable = true;
        public boolean enableArmor = true;
        public boolean enableTitaniumCoatedGlassBowl = true;
        public boolean enableTitaniumCoatedGlassHelmet = true;
        public boolean enableWorldGen = true;
        @ConfigEntry.BoundedDiscrete(max = 64)
        public int oreGroupSize = 9;
        @ConfigEntry.BoundedDiscrete(max = 32)
        public int oreGroupsPerChunk = 10;
        
    }
    
    public static class Sunscreen {
    
        @ConfigEntry.Gui.RequiresRestart
        public boolean enable = true;
        
        @ConfigEntry.Gui.RequiresRestart
        public int maxUses = 4;
        
        public int duration = 12000;
        
    }
    
    public static class WaterResistance {
        
        public boolean enable = true;
        public boolean enableLong = true;
        public int shortDuration = 3600;
        public int longDuration = 9600;
        
        @Comment("Registry ID of the potion ingredient for Water Resistance potion, Default: minecraft:awkward")
        public String potionIngredient = "minecraft:awkward";
        
        @Comment("Registry ID of the item ingredient for Water Resistance potion, Default: minecraft:scute")
        public String itemIngredient = "minecraft:scute";
        
    }
    
    public static class AirFilter {
    
        public boolean enable = true;
        
    }
    
}
