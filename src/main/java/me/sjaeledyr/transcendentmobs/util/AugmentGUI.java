package me.sjaeledyr.transcendentmobs.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AugmentGUI implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("augment")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
        }
        createInv(p);
        sender.sendMessage("Debug");
        return true;
    }
    public void createInv(final Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Weapon Augmentation");
        ItemStack item = player.getInventory().getItemInMainHand();
        inv.setItem(0, item);
        if (item == null) {
            player.sendMessage("You must have an augmentable item equipped!");
            return;
        }
        player.openInventory(inv);
    }
}