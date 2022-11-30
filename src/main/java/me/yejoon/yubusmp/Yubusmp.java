package me.yejoon.yubusmp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
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

        ItemStack comp = new ItemStack(Material.APPLE);
        ItemMeta compMeta = comp.getItemMeta();

        compMeta.setDisplayName(ChatColor.RED + "멋진 순간이동 사과");
        compMeta.addEnchant(Enchantment.LUCK, 1, false);
        compMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        comp.setItemMeta(compMeta);

        ShapedRecipe compass = new ShapedRecipe(new NamespacedKey(this, "warp"), comp);
//        getLogger().info(compass.getKey().getKey());
        compass.shape("EDE", "DWD", "EDE");
        compass.setIngredient('E', Material.APPLE);
        compass.setIngredient('D', Material.DIAMOND);
        compass.setIngredient('W', Material.WITHER_SKELETON_SKULL);

        getServer().addRecipe(compass);

        getLogger().info("YUBU SMP PLUGIN ENABLED");
    }

    @Override
    public void onDisable() {

    }
}
