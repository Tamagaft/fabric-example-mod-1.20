package net.tamagaft.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.tamagaft.testmod.block.ModBlocks;
import net.tamagaft.testmod.block.entity.ModBlockEntities;
import net.tamagaft.testmod.entity.ModEntities;
import net.tamagaft.testmod.entity.custom.PorcupineEntity;
import net.tamagaft.testmod.item.ModItemGroups;
import net.tamagaft.testmod.item.ModItems;
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

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE,800);
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
	}
}