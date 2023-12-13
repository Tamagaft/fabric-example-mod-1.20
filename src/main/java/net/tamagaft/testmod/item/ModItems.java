package net.tamagaft.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tamagaft.testmod.TestMod;

public class ModItems {
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().maxCount(128)));
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().maxCount(128)));
    private static Item registerItem(String name, Item item) {
        return  Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    private static void addItemsToEngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RAW_TANZANITE);
        entries.add(TANZANITE);
    }

    public static void registerModItems() {
        TestMod.LOGGER.debug("Registering Mod Items for " + TestMod.MOD_ID);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToEngredientItemGroup);

    }
}