import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.sjaeledyr.transcendentmobs.Mobs.SkeletonCrusader;

public class SpigotListener implements Listener {
  FileConfiguration cfg = this.getConfig();
  SkeletonCrusader sr = new SkeletonCrusader();
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e ) {
        Player p = e.getPlayer();
        if (!(cfg.contains(p.getName()))) {
            cfg.set(p.getName() + "." + "kills", 0);
            this.saveConfig();
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
