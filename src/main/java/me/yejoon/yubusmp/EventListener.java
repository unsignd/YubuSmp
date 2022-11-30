package me.yejoon.yubusmp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static org.bukkit.Bukkit.getLogger;


public class EventListener implements Listener {
    Map<UUID, Location> spawn = new HashMap<UUID, Location>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(e.getPlayer().getName() + " < 이사람 서버접속함");

        if(!e.getPlayer().hasPlayedBefore()) {
            Random randomPos = new Random();
            int randomX = randomPos.nextInt(10000) - 5000;
            int randomZ = randomPos.nextInt(10000) - 5000;
            Block block = Bukkit.getWorld("World").getHighestBlockAt(randomPos.nextInt(5000) - 2500 + randomX, randomPos.nextInt(5000) - 2500 + randomZ);
            e.getPlayer().teleport(block.getLocation().add(.5, 1, .5));
            spawn.put(e.getPlayer().getUniqueId(), block.getLocation().add(.5, 1, .5));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(e.getPlayer().getName() + " < 이사람 서버나감");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setDeathMessage(e.getEntity().getName() + " < 이사람 죽어버림");
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        e.setRespawnLocation(spawn.get(e.getPlayer().getUniqueId()));
    }

    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent e) {
        spawn.put(e.getPlayer().getUniqueId(), e.getBed().getLocation());
    }
}
