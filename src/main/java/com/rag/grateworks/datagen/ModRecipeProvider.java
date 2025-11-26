package com.rag.grateworks.datagen;

import com.rag.grateworks.GrateWorks;
import com.rag.grateworks.block.ModBlocks;
import com.rag.grateworks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerBlasting(recipeExporter, List.of(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.STEEL_INGOT, 0.0f, 100, "steel_ingot");
        offerBlasting(recipeExporter, List.of(ModItems.STEEL_INGOT), RecipeCategory.MISC, ModItems.STAINLESS_STEEL_INGOT, 0.0f, 100, "stainless_steel_ingot");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STAINLESS_STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STAINLESS_STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CROWBAR, 1)
                .group("crowbar")
                .input('#', ModItems.STAINLESS_STEEL_INGOT)
                .input('X', Items.STICK)
                .pattern("  #")
                .pattern(" X ")
                .pattern("#  ")
                .criterion(hasItem(ModItems.STAINLESS_STEEL_INGOT), conditionsFromItem(ModItems.STAINLESS_STEEL_INGOT))
                .offerTo(recipeExporter, Identifier.of(GrateWorks.MOD_ID, "crowbar_recipe"));
    }
}
