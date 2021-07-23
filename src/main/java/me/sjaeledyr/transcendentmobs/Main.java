package me.sjaeledyr.transcendentmobs;

import me.sjaeledyr.transcendentmobs.Loot.Armor;
import me.sjaeledyr.transcendentmobs.Loot.Weapons;
import me.sjaeledyr.transcendentmobs.util.AugmentGUI;
import me.sjaeledyr.transcendentmobs.util.EventListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static FileConfiguration config;
    private final Weapons weapons = new Weapons();
    private final Armor armor = new Armor();
    private final AugmentGUI aGUI = new AugmentGUI();

    @Override
    public final void onEnable()
    {
        // Commands
        this.getCommand("augment").setExecutor(new AugmentGUI());

        // Plugin startup logic
        config=getConfig();
        this.saveDefaultConfig();
        weapons.init();
        armor.init();
        System.out.println("[TranscendentMobs] TranscendentMobs by Sjaeledyr has been Loaded! ");
        System.out.println("[TranscendentMobs] Plugin Version 1.0");

        // Set up event listener
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        config.set("test", true);
    }
    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
        System.out.println("[TranscendentMobs] TranscendentMobs has been disabled!");
        config = null;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("augment")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
        }
        aGUI.createInv(p);
        return true;
    }
}
