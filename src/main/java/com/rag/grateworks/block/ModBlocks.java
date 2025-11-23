package com.rag.grateworks.block;

import com.rag.grateworks.GrateWorks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(5f, 6f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.IRON_GRAY)
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(5f, 6f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GrateWorks.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(GrateWorks.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        GrateWorks.LOGGER.info("Registering BLOCKS for " + GrateWorks.MOD_ID);
    }
}
