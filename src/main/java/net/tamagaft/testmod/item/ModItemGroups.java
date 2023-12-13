package net.tamagaft.testmod.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tamagaft.testmod.TestMod;

public class ModItemGroups {
    public static final ItemGroup TANZANITE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "tanzanite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.tanzanite"))
                    .icon(() -> new ItemStack(ModItems.TANZANITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TANZANITE);
                        entries.add(ModItems.RAW_TANZANITE);

                        entries.add(Items.DIAMOND);


                    }).build());


    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
