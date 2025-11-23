package com.rag.grateworks.item;

import com.rag.grateworks.GrateWorks;
import com.rag.grateworks.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GRATEWORKS_INGREDIENTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GrateWorks.MOD_ID,"grateworks_ingredients"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT))
                    .displayName(Text.translatable("itemgroup.grateworks.grateworks_ingredients"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.STAINLESS_STEEL_INGOT);
                    }).build());

    public static final ItemGroup GRATEWORKS_BUILDING_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GrateWorks.MOD_ID,"grateworks_building_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK))
                    .displayName(Text.translatable("itemgroup.grateworks.grateworks_building_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.STAINLESS_STEEL_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        GrateWorks.LOGGER.info("Registering ITEM GROUPS for" + GrateWorks.MOD_ID);
    }
}
