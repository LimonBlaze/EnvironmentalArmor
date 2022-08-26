package io.github.magicquartz.environmentalarmor;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.magicquartz.environmentalarmor.config.EnvaConfig;
import io.github.magicquartz.environmentalarmor.registry.EnvaBlocks;
import io.github.magicquartz.environmentalarmor.registry.EnvaEffects;
import io.github.magicquartz.environmentalarmor.registry.EnvaItems;
import io.github.magicquartz.environmentalarmor.registry.EnvaOres;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Enva implements ModInitializer {
    public static final String ID = "enva";
    public static final PowerType<Power> STINGER = new PowerTypeReference<>(new Identifier("moborigins", "stinger"));
    public static final EnvaConfig CONFIG = createConfig();
    
    @Override
    public void onInitialize() {
        EnvaBlocks.register();
        EnvaItems.register();
        EnvaEffects.register();
        EnvaOres.register();
    }
    
    private static EnvaConfig createConfig() {
        AutoConfig.register(EnvaConfig.class, JanksonConfigSerializer::new);
        ConfigHolder<EnvaConfig> holder = AutoConfig.getConfigHolder(EnvaConfig.class);
        holder.load();
        return holder.getConfig();
    }
    
    public static Identifier identifier(String id) {
        return new Identifier(ID, id);
    }
    
}
