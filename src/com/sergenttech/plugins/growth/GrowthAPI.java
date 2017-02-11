package com.sergenttech.plugins.growth;

import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Ben Sergent V <bsergentv@gmail.com>
 */
public class GrowthAPI extends JavaPlugin {
    
    private final String version = "0.0.1";

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        try {
            org.mcstats.MetricsLite metrics = new org.mcstats.MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
        }
        
        getLogger().log(Level.INFO, "GrowthAPI v{0} enabled.", version);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "GrowthAPI v{0} disabled.", version);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("growth")) {
            sender.sendMessage(new String[] {ChatColor.GOLD+"ThreeSquareMeals v"+version});
        }
        
        return true;
    }

}
