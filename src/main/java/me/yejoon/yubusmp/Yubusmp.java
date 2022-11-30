package me.yejoon.yubusmp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Yubusmp extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        ItemStack comp = new ItemStack(Material.ENDER_PEARL);
        CompassMeta compMeta = (CompassMeta) comp.getItemMeta();

        compMeta.setDisplayName(ChatColor.RED + "순간이동기");
        compMeta.addEnchant(Enchantment.LUCK, 1, false);
        comp.setItemMeta(compMeta);

        ShapedRecipe compass = new ShapedRecipe(new NamespacedKey(this, "warp"), comp);
        getLogger().info(compass.getKey().getKey());
        compass.shape("EDE", "DWD", "EDE");
        compass.setIngredient('E', Material.ENDER_EYE);
        compass.setIngredient('D', Material.DIAMOND);
        compass.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        getServer().addRecipe(compass);

        getLogger().info("YUBU SMP PLUGIN ENABLED");
    }

    @Override
    public void onDisable() {

    }
}
