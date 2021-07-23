package me.sjaeledyr.transcendentmobs.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class AugmentGUI {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if (label.equalsIgnoreCase("augment")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
        }
        return false;
    }

    private void createInv(final Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Weapon Augmentation");
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item == null)
            return;

    }
}
