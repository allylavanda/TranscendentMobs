package me.sjaeledyr.transcendentmobs.util;package

import me.sjaeledyr.transcendentmobs.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.sjaeledyr.transcendentmobs.Mobs.SkeletonCrusader;


public class EventListener implements Listener {
  private Main main = Main.getPlugin(Main.class);
  FileConfiguration cfg = main.getConfig();
  SkeletonCrusader sr = new SkeletonCrusader();
  
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
  public void entityDeath(EntityDeathEvent e) {
    if (e.getEntity() instanceof Skeleton) {
      sr.skeletonDeathHandler(e);
    }
  }
  
  @EventHandler
  public void onDamage (EntityDamageByEntityEvent e) {

  }

}