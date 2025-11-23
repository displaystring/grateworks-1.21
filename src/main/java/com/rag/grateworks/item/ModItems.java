package com.rag.grateworks.item;

import com.rag.grateworks.GrateWorks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item STAINLESS_STEEL_INGOT = registerItem("stainless_steel_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GrateWorks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GrateWorks.LOGGER.info("Registered ITEMS for" + GrateWorks.MOD_ID);
    }
}
