package me.sjaeledyr.transcendentmobs.util;

import me.sjaeledyr.transcendentmobs.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class killCounter {
    private Main main = Main.getPlugin(Main.class);
    FileConfiguration cfg = main.getConfig();

    public void addKillSkeleton(Player p, int count) {
        int i = cfg.getInt(p.getName() + "." + "skeleton kills");
        int a = count;
        cfg.set(p.getName() + "." + "skeleton kills", a + i);
        main.saveConfig();
    }
    public int getKillsSkeleton(Player p) {
        return cfg.getInt(p.getName() + "." + "skeleton kills");
    }
    public void resetKillsSkeleton(Player p) {
        cfg.set(p.getName() + "." + "skeleton kills", 0);
        main.saveConfig();
    }
    public void addKillZombie(Player p, int count) {
        int i = cfg.getInt(p.getName() + "." + "zombie kills");
        int a = count;
        cfg.set(p.getName() + "." + "zombie kills", a + i);
        main.saveConfig();
    }
    public int getKillsZombie(Player p) {
        return cfg.getInt(p.getName() + "." + "zombie kills");
    }
    public void resetKillsZombie(Player p) {
        cfg.set(p.getName() + "." + "zombie kills", 0);
        main.saveConfig();
    }
    public void addKillSpider(Player p, int count) {
        int i = cfg.getInt(p.getName() + "." + "spider kills");
        int a = count;
        cfg.set(p.getName() + "." + "spider kills", a + i);
        main.saveConfig();
    }
    public int getKillsSpider(Player p) { return cfg.getInt(p.getName() + "." + "spider kills"); }
    public void resetKillsSpider(Player p) {
        cfg.set(p.getName() + "." + "spider kills", 0);
        main.saveConfig();
    }
}