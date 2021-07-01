package me.sjaeledyr.transcendentmobs.Mobs;

import me.sjaeledyr.transcendentmobs.util.killCounter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class ZombieWarrior {
    killCounter kc = new killCounter();

    public void zombieDeathHandler(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();
        kc.addKillZombie(p, 1);
        // Zombie Warrior Spawn Condition
        if (kc.getKillsZombie(p) >= 3) {
            // SpawnLoc
            Location spawnLoc = p.getLocation().add(2,0,0);
            World world = p.getWorld();
            p.sendMessage("A Zombie Warrior Has Appeared!");
            Zombie zombie = (Zombie) world.spawnEntity(spawnLoc, EntityType.ZOMBIE);
            zombie.setCustomName("Zombie Warrior");
            zombie.setCustomNameVisible(true);
            // Attributes
            zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
            zombie.setHealth(100);
            // Zombie Warrior Gear
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_AXE));
            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
            kc.resetKillsZombie(p);
        }
    }
}