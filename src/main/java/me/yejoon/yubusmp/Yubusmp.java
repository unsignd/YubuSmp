package me.yejoon.yubusmp;

import org.bukkit.plugin.java.JavaPlugin;

public final class Yubusmp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getLogger().info("YUBU SMP PLUGIN ENABLED");
    }

    @Override
    public void onDisable() {

    }
}
