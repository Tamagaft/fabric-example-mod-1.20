package net.tamagaft.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.tamagaft.testmod.block.ModBlocks;
import net.tamagaft.testmod.item.ModItems;
import net.minecraft.recipe.Ingredient;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE,ModBlocks.DEEPSLATE_RUBY_ORE,ModBlocks.END_STONE_RUBY_ORE,ModBlocks.NETHER_RUBY_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter,RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 1f, 200,"ruby");
        offerBlasting(exporter,RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 1f, 100,"ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK );

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE,1)
                .pattern("CC")
                .pattern("CC")
                .input('C', Items.CHARCOAL)
                .criterion(hasItem(Items.CHARCOAL), conditionsFromItem(Items.CHARCOAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COAL_BRIQUETTE)));

        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModBlocks.RUBY_BLOCK))
                .criterion(hasItem(ModBlocks.RUBY_BLOCK),conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.RUBY_DOOR)));

        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR, Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModBlocks.RUBY_BLOCK),conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.RUBY_TRAPDOOR)));

        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModBlocks.RUBY_BLOCK))
                .criterion(hasItem(ModBlocks.RUBY_BLOCK),conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.RUBY_STAIRS)));

        offerSlabRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_SLAB, ModBlocks.RUBY_BLOCK);

        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModBlocks.RUBY_BLOCK))
                .criterion(hasItem(ModBlocks.RUBY_BLOCK),conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.RUBY_FENCE)));

        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModBlocks.RUBY_BLOCK))
                .criterion(hasItem(ModBlocks.RUBY_BLOCK),conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.RUBY_FENCE_GATE)));

        offerWallRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_WALL, ModBlocks.RUBY_BLOCK);

        offerPressurePlateRecipe(exporter, ModBlocks.RUBY_PRESSURE_PLATE, ModBlocks.RUBY_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.RUBY_BUTTON,1)
                .input(ModBlocks.RUBY_BLOCK)
                .criterion(hasItem(ModBlocks.RUBY_BLOCK), conditionsFromItem(ModBlocks.RUBY_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE,1)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', Items.STICK)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE,1)
                .pattern("RR")
                .pattern("RS")
                .pattern(" S")
                .input('S', Items.STICK)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_AXE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL,1)
                .pattern("R")
                .pattern("S")
                .pattern("S")
                .input('S', Items.STICK)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SHOVEL)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SWORD,1)
                .pattern("R")
                .pattern("R")
                .pattern("S")
                .input('S', Items.STICK)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SWORD)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE,1)
                .pattern("RR")
                .pattern(" S")
                .pattern(" S")
                .input('S', Items.STICK)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_HOE)));


    }
}
