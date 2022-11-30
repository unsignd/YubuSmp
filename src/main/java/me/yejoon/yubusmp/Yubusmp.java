package me.yejoon.yubusmp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Yubusmp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        ItemStack comp = new ItemStack(Material.COMPASS);
        ItemMeta compMeta = comp.getItemMeta();
        compMeta.setDisplayName(ChatColor.RED + "플레이어 추적기");
        comp.setItemMeta(compMeta);

        ShapedRecipe compass = new ShapedRecipe(comp);
        compass.shape("EDE", "DWD", "EDE");
        compass.setIngredient('E', Material.ENDER_EYE);
        compass.setIngredient('D', Material.DIAMOND_BLOCK);
        compass.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        getServer().addRecipe(compass);

        getLogger().info("YUBU SMP PLUGIN ENABLED");
    }

    @Override
    public void onDisable() {

    }
}
