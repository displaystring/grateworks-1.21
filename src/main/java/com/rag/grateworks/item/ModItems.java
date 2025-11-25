package com.rag.grateworks.item;

import com.rag.grateworks.GrateWorks;
import com.rag.grateworks.item.custom.CrowbarItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item STAINLESS_STEEL_INGOT = registerItem("stainless_steel_ingot", new Item(new Item.Settings()));

    public static final Item CROWBAR = registerItem("crowbar", new CrowbarItem(new Item.Settings().maxDamage(250)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GrateWorks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GrateWorks.LOGGER.info("Registered ITEMS for " + GrateWorks.MOD_ID);
    }
}
