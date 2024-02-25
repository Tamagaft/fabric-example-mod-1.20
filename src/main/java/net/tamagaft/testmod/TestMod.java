package net.tamagaft.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.tamagaft.testmod.block.ModBlocks;
import net.tamagaft.testmod.block.entity.ModBlockEntities;
import net.tamagaft.testmod.entity.ModEntities;
import net.tamagaft.testmod.entity.custom.PorcupineEntity;
import net.tamagaft.testmod.item.ModItemGroups;
import net.tamagaft.testmod.item.ModItems;
import net.tamagaft.testmod.recipe.ModRecipes;
import net.tamagaft.testmod.screen.ModScreenHandlers;
import net.tamagaft.testmod.sound.ModSounds;
import net.tamagaft.testmod.util.ModCustomTrades;
import net.tamagaft.testmod.util.ModLootTablesModifiers;
import net.tamagaft.testmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTablesModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrade();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandler();

		ModRecipes.registerRecipies();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE,800);
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());

		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_LOG, ModBlocks.STRIPPED_CHESTNUT_LOG);
		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_WOOD, ModBlocks.STRIPPED_CHESTNUT_WOOD);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LEAVES, 30, 60);
	}
}