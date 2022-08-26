package io.github.magicquartz.environmentalarmor.registry;

import io.github.magicquartz.environmentalarmor.Enva;
import io.github.magicquartz.environmentalarmor.block.AirFilterBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class EnvaBlocks {

    public static final Block TITANIUM_ORE = new Block(FabricBlockSettings
        .of(Material.METAL)
        .requiresTool()
        .requiresTool()
        .strength(5.0f, 20.0f)
        .sounds(BlockSoundGroup.ANCIENT_DEBRIS));

    public static final Block TITANIUM_BLOCK = new Block(FabricBlockSettings
        .of(Material.METAL)
        .requiresTool()
        .requiresTool()
        .strength(5.0f, 30.0f)
        .sounds(BlockSoundGroup.METAL));

    public static final Block AIR_FILTER = new AirFilterBlock(FabricBlockSettings
        .of(Material.STONE)
        .breakInstantly()
        .strength(1.5f, 0.5f)
        .sounds(BlockSoundGroup.STONE));

    public static void register() {
        if(Enva.CONFIG.titanium.enable) {
            Registry.register(Registry.BLOCK, Enva.identifier("titanium_ore"), TITANIUM_ORE);
            Registry.register(Registry.BLOCK, Enva.identifier("titanium_block"), TITANIUM_BLOCK);
            if(Enva.CONFIG.titanium.enableAirFilter) {
                Registry.register(Registry.BLOCK, Enva.identifier("air_filter"), AIR_FILTER);
            }
        }
    }
    
}
