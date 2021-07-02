package me.sjaeledyr.transcendentmobs.Loot;

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

    public static ItemStack testWeapon;

    public static void init() {
        createTestWeapon();
    }
    public static void createTestWeapon() {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 100,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("This Is Gonna Hurt");
        List<String> lore = new ArrayList<>();
        lore.add("This is a weapon to test the plugin's");
        lore.add("functionality / for debugging");
        meta.setLore(lore);
        // add a modifier
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        item.setItemMeta(meta);
        testWeapon = item;
    }
}
