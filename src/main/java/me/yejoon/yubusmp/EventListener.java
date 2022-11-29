package me.yejoon.yubusmp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(e.getPlayer().getName() + " (" + e.getPlayer().getUniqueId() + ") < 이사람 서버접속함");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(e.getPlayer().getName() + " (" + e.getPlayer().getUniqueId() + ") < 이사람 서버나감");
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
            e.setDeathMessage(e.getPlayer().getName() + " (" + e.getPlayer().getUniqueId() + ") < 이사람 죽어버림");
    }
}
