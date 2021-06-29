package me.sjaeledyr.transcendentmobs.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class killCounter extends JavaPlugin {
    FileConfiguration cfg = this.getConfig();
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
    public void addKill(Player p, int count) {
        int i = cfg.getInt(p.getName() + "." + "kills");
        int a = count;
        cfg.set(p.getName() + "." + "kills", a+i);
        this.saveConfig();
    }
    public int getKills(Player p) {
        return cfg.getInt(p.getName() + "." + "kills");
    }
    public void resetKills(Player p) {
        cfg.set(p.getName() + "." + "kills", 0);
        this.saveConfig();
    }
}
