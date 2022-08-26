package io.github.magicquartz.environmentalarmor.registry;

import io.github.magicquartz.environmentalarmor.Enva;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class EnvaOres {
    
    private static final ConfiguredFeature<?, ?> TITANIUM_ORE_END = new ConfiguredFeature<>(Feature.ORE,
        new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), EnvaBlocks.TITANIUM_ORE.getDefaultState(),
            Enva.CONFIG.titanium.oreGroupSize));
    private static final PlacedFeature TITANIUM_ORE_PLACE = new PlacedFeature(RegistryEntry.of(TITANIUM_ORE_END), List.of(
        CountPlacementModifier.of(Enva.CONFIG.titanium.oreGroupsPerChunk),
        SquarePlacementModifier.of(),
        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
    ));
    
    public static void register() {
        if(Enva.CONFIG.titanium.enable && Enva.CONFIG.titanium.enableWorldGen) {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Enva.identifier("titanium_ore"), TITANIUM_ORE_END);
            Registry.register(BuiltinRegistries.PLACED_FEATURE, Enva.identifier("titanium_ore"), TITANIUM_ORE_PLACE);
            BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, Enva.identifier("titanium_ore"))
            );
        }
    }
    
}
