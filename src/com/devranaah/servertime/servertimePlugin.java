package com.devranaah.servertime;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTimePlugin extends JavaPlugin implements Listener {
    
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("ServerTimePlugin has been enabled!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("ServerTimePlugin has been disabled!");
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        if (player.getInventory().getItemInMainHand().getType() == Material.CLOCK) {
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
            player.sendMessage(ChatColor.YELLOW + "Server Time: " + ChatColor.GREEN + time);
        }
    }
}

// plugin.yml
name: ServerTimePlugin
version: 1.0
main: com.example.servertime.ServerTimePlugin
description: A simple plugin to show server time when clicking a clock.
author: YourName
api-version: 1.16
