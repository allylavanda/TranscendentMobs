package me.sjaeledyr.transcendentmobs.util;

import me.sjaeledyr.transcendentmobs.Main;
import me.sjaeledyr.transcendentmobs.Mobs.ZombieWarrior;
import me.sjaeledyr.transcendentmobs.Mobs.SkeletonCrusader;
import me.sjaeledyr.transcendentmobs.Mobs.SpiderWeaver;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;


public class EventListener implements Listener {
    private Main main = Main.getPlugin(Main.class);
    FileConfiguration cfg = main.getConfig();
    SkeletonCrusader sc = new SkeletonCrusader();
    ZombieWarrior zw = new ZombieWarrior();
    SpiderWeaver sw = new SpiderWeaver();

    @EventHandler
    public void onJoin(PlayerJoinEvent e ) {
        Player p = e.getPlayer();
        if (!(cfg.contains(p.getName()))) {
            cfg.set(p.getName() + "." + "kills", 0);
            main.saveConfig();
        }
        else {
            return;
        }
    }
    @EventHandler
    public void entityDeathSkeleton(EntityDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) { if (e.getEntity() instanceof Skeleton)
            sc.skeletonDeathHandler(e);
        }
    }
    @EventHandler
    public void entityDeathZombie(EntityDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) { if (e.getEntity() instanceof Zombie)
            zw.zombieDeathHandler(e);
        }
    }
    @EventHandler
    public void entityDeathSpider(EntityDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) { if (e.getEntity() instanceof Spider)
            sw.spiderDeathHandler(e);
        }
    }
    @EventHandler
    public void onDamage (EntityDamageByEntityEvent e) {
    }
}
