package me.sjaeledyr.transcendentmobs.Mobs;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import me.sjaeledyr.transcendentmobs.util.killCounter;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.UUID;

public class SkeletonCrusader {
    killCounter kc = new killCounter();

    public void skeletonDeathHandler(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();
        kc.addKillSkeleton(p, 1);
        // Skeleton Crusader spawn condition
        if (kc.getKillsSkeleton(p) >= 3) {
            // Spawn Location
            Location spawnLoc = p.getLocation().add(2,0,0);
            World world = p.getWorld();
            p.sendMessage("A Skeleton Crusader Has Appeared!");
            Skeleton skeleton = (Skeleton) world.spawnEntity(spawnLoc, EntityType.SKELETON);
            skeleton.setCustomName("Skeleton Crusader");
            skeleton.setCustomNameVisible(true);
            skeleton.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
            skeleton.setHealth(40);
            //Particle Effects
            world.spawnParticle(Particle.EXPLOSION_HUGE, skeleton.getLocation(), 1);

            // Skeleton Crusader Gear
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 100,
                    AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            ItemStack scWeapon = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta meta = scWeapon.getItemMeta();
            // add a modifier
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
            scWeapon.setItemMeta(meta);
            kc.resetKillsSkeleton(p);

            skeleton.getEquipment().setItemInMainHand(scWeapon);
            skeleton.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
        }
    }
}
