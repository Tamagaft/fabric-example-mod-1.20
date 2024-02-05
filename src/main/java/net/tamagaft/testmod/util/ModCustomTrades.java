package net.tamagaft.testmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.tamagaft.testmod.item.ModItems;
import net.tamagaft.testmod.villager.ModVillagers;

public class ModCustomTrades {
    public static   void registerCustomTrade(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.TOMATO,7),
                    6,5,0.05f));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,7),
                    new ItemStack(ModItems.TOMATO_SEEDS,1),
                    2,7,0.05f));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.RUBY,32),
                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.MENDING, 1)),
                    3,10,0.05f));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.CORN,64),
                    new ItemStack(Items.NOTE_BLOCK,1),
                    3,10,0.05f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.CORN,64),
                    new ItemStack(Items.MUSIC_DISC_13,1),
                    3,10,0.05f));
        });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.CORN,64),
                    new ItemStack(Items.MUSIC_DISC_5,1),
                    3,10,0.05f));
        });

    }
}
