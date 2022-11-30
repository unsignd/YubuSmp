package me.yejoon.yubusmp;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Yubusmp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        ShapedRecipe compass = new ShapedRecipe(new ItemStack(Material.COMPASS));
        compass.shape("EDE", "DWD", "EDE");
        compass.setIngredient('E', Material.ENDER_EYE);
        compass.setIngredient('D', Material.DIAMOND_BLOCK);
        compass.setIngredient('W', Material.WITHER_SKELETON_SKULL, 3);
        getServer().addRecipe(compass);

        getLogger().info("YUBU SMP PLUGIN ENABLED");
    }

    @Override
    public void onDisable() {

    }
}
