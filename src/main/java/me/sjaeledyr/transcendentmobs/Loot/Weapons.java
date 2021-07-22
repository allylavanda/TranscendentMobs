package me.sjaeledyr.transcendentmobs.Loot;

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

public class Weapons {
    // Weapon List
    public static ItemStack testWeapon;
    public static ItemStack warriorsAxe;
    public static ItemStack konstanzasRapier;
    public static ItemStack fonteynesGreatShield;

    public static void init() {
        createTestWeapon();
        createWarriorsAxe();
        createKonstanzasRapier();
        createFonteynesGreatShield();
    }
    // DEBUG WEAPONS
    public static void createTestWeapon() {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        // Attributes
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
                100, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "This Is Gonna Hurt");
        List<String> lore = new ArrayList<>();
        lore.add("This is a weapon to test the plugin's");
        lore.add("functionality / for debugging");
        meta.setLore(lore);
        // Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        item.setItemMeta(meta);
        testWeapon = item;
    }
    public static void createWarriorsAxe() {
        ItemStack item = new ItemStack(Material.IRON_AXE);
        // Attributes
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",
                5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        ItemMeta meta = item.getItemMeta();
        // Lore
        meta.setDisplayName("Warrior's Axe");
        List<String> lore = new ArrayList<>();
        lore.add("Hardy axe used by the mightiest of Warriors");
        meta.setLore(lore);
        // Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        item.setItemMeta(meta);
        warriorsAxe = item;
    }
    // TRANSCENDENT WEAPONS
    public static void createKonstanzasRapier() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        // Attributes
        AttributeModifier damageModifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
                10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        // AttributeModifier frostModifier = new AttributeModifier(UUID.randomUUID(), "generic.slow",
        //        -10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        ItemMeta meta = item.getItemMeta();
        // Lore
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Konstanza's Rapier");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Transcendent");
        meta.setLore(lore);

        // Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        // meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, frostModifier);
        item.setItemMeta(meta);
        konstanzasRapier = item;
    }
    public static void createFonteynesGreatShield() {
        ItemStack item = new ItemStack(Material.SHIELD);
        // Attributes
        AttributeModifier blockModifier = new AttributeModifier(UUID.randomUUID(), "generic.blockChance",
                10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
        AttributeModifier toughnessModifier = new AttributeModifier(UUID.randomUUID(), "generic.tough",
                4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
        AttributeModifier kbModifier = new AttributeModifier(UUID.randomUUID(), "generic.kb",
                0.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);

        ItemMeta meta = item.getItemMeta();

        //Lore
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Fonteyne's Great Shield");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Transcendent");
        lore.add("TBD");
        meta.setLore(lore);

        // Set Modifiers
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, blockModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughnessModifier);
        meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbModifier);
        item.setItemMeta(meta);
        fonteynesGreatShield = item;
    }
}