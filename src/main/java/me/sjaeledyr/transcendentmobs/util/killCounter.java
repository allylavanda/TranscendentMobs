package me.sjaeledyr.transcendentmobs.util;

import me.sjaeledyr.transcendentmobs.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class killCounter {
    private Main main = Main.getPlugin(Main.class);
    FileConfiguration cfg = main.getConfig();
    
    public void addKill(Player p, int count) {
        int i = cfg.getInt(p.getName() + "." + "kills");
        int a = count;
        cfg.set(p.getName() + "." + "kills", a+i);
        main.saveConfig();
    }
    public int getKills(Player p) {
        return cfg.getInt(p.getName() + "." + "kills");
    }
    public void resetKills(Player p) {
        cfg.set(p.getName() + "." + "kills", 0);
        main.saveConfig();
    }
}
