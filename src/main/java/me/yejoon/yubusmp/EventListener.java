package me.yejoon.yubusmp;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

import static org.bukkit.Bukkit.getLogger;


public class EventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(e.getPlayer().getName() + " < 이사람 서버접속함");

        if(!e.getPlayer().hasPlayedBefore()) {
            Random randomPos = new Random();
            int randomX = randomPos.nextInt(100000) - 50000;
            int randomZ = randomPos.nextInt(100000) - 50000;
            Block block = Bukkit.getWorld("World").getHighestBlockAt(randomPos.nextInt(50000) - 25000 + randomX, randomPos.nextInt(50000) - 25000 + randomZ);
            e.getPlayer().teleport(block.getLocation().add(.5, 1, .5));
            e.getPlayer().setBedSpawnLocation(block.getLocation().add(.5, 1, .5));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(e.getPlayer().getName() + " < 이사람 서버나감");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
            e.setDeathMessage(e.getPlayer().getName() + " < 이사람 죽어버림");
    }
}
