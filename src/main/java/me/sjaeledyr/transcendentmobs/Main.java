package me.sjaeledyr.transcendentmobs;

import me.sjaeledyr.transcendentmobs.Mobs.SkeletonCrusader;
import me.sjaeledyr.transcendentmobs.util.killCounter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        // Plugin startup logic
        System.out.println("[TranscendentMobs] TranscendentMobs by Sjaeledyr has been Loaded! ");
        System.out.println("Plugin Version 1.0");

        // TranscendentMobs Classes
        getServer().getPluginManager().registerEvents(new SkeletonCrusader(), this);
        getServer().getPluginManager().registerEvents(new killCounter), this;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[TranscendentMobs] TranscendentMobs has been disabled!");
    }


}
