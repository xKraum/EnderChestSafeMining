package com.enderchestsafemining.utils;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EnderChestChecker {

    /**
     * Checks if the given block state is an Ender Chest.
     *
     * @param blockState The block state to check.
     * @return {@code true} if the block is an Ender Chest, {@code false} otherwise.
     */
    public static boolean isTargetEnderChest(BlockState blockState) {
        return blockState.getBlock() == Blocks.ENDER_CHEST;
    }

    /**
     * Checks if breaking an Ender Chest with the player's current tool will drop the Ender Chest item.
     *
     * @param player The client player entity.
     * @return {@code true} if breaking the Ender Chest will drop the item, {@code false} otherwise.
     */
    public static boolean willDropEnderChest(ClientPlayerEntity player) {
        ItemStack itemStack = player.getMainHandStack();
        Item item = itemStack.getItem();

        return isValidPickaxe(item) && itemHasEnchantment(itemStack, Enchantments.SILK_TOUCH);
    }

    private static boolean isValidPickaxe(Item item) {
        if (item != null) {
            return item == Items.IRON_PICKAXE
                    || item == Items.DIAMOND_PICKAXE
                    || item == Items.NETHERITE_PICKAXE;
        }

        return false;
    }

    private static boolean itemHasEnchantment(ItemStack item, Enchantment enchantment) {
        if (item != null & enchantment != null) {
            return EnchantmentHelper.getLevel(enchantment, item) != 0;
        }

        return false;
    }

}
