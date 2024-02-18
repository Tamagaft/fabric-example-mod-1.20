package net.tamagaft.testmod.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tamagaft.testmod.TestMod;

public class ModRecipes {
    public static void registerRecipies(){
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestMod.MOD_ID,GemPolishingRecipe.Serializer.ID),
                GemPolishingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestMod.MOD_ID, GemPolishingRecipe.Type.ID),
                GemPolishingRecipe.Type.INSTANCE);
    }
}
