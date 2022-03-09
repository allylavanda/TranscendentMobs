package me.sjaeledyr.transcendentmobs.mobs;

import me.sjaeledyr.transcendentmobs.util.KillCounter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.entity.EntityDeathEvent;

public class SpiderWeaver {
    KillCounter kc = new KillCounter();

    public void spiderDeathHandler(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Player p = e.getEntity().getKiller();
        kc.addKillSpider(p, 1);
        //Spider Weaver spawn condition
        if (kc.getKillsSpider(p) >= 3) {
            //Spawn Location
            Location spawnLoc = p.getLocation().add(2,0,0);
            World world = p.getWorld();
            p.sendMessage("A Spider Weaver Has Appeared!");
            Spider spider = (Spider) world.spawnEntity(spawnLoc, EntityType.SPIDER);
            spider.setCustomName("Spider Weaver");
            spider.setCustomNameVisible(true);
            // Attributes
            spider.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(75);
            spider.setHealth(75);
            // Spider Gear ??
            kc.resetKillsSpider(p);
        }
    }
}