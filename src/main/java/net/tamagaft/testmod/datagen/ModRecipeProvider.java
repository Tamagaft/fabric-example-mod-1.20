package net.tamagaft.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.tamagaft.testmod.block.ModBlocks;
import net.tamagaft.testmod.item.ModItems;

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
    }
}
