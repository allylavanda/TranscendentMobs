package me.sjaeledyr.transcendentmobs.loot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Armor {
    // Armor List
    public static ItemStack testArmor;

    public static void init() {
        createTestArmor();
    }
    // DEBUG ARMOR
    public static void createTestArmor() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        // Attributes
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.block",
                10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Test Armor");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Transcendent");
        lore.add("Test Armor Piece for debugging purposes");
        meta.setLore(lore);

        //Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        item.setItemMeta(meta);
        testArmor = item;
    }
}