package me.ES359.DisplayInfo.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ES359 on 1/20/15.
 */
public class SettingsManager {

    public Player player;

    private SettingsManager() {}

    static SettingsManager instance = new SettingsManager();

    public static SettingsManager getControllerInstance() {
        return instance;
    }

    public ArrayList<String> restricted = new ArrayList<String>();


    public String header
            () {
        return ChatColor.translateAlternateColorCodes('&',"&c[&2&l+&c]&4------------------------------&c[&2&l+&c]\n"
        );
    }

    public String display() {

        return ChatColor.translateAlternateColorCodes('&',"&c[&c]&4---------------&c[&c]\n&c |\n&c |\n&c |"
      );
    }


    Plugin plugin;
    FileConfiguration config;
    File file;

    public void configSetup(Plugin p){
        config = p.getConfig();
        config.options().copyDefaults(true);
        file = new File(p.getDataFolder(), "config.yml");
        p.saveConfig();
        //Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', Info.prefix_Console + "&b&lConfiguration file has been &a&ocreated&b&l!"));
    }


    public Player getPlayer()
    {
        return player;
    }



    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(file);
        }catch(IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&oERROR &b&l> &6&oCould not save the &eConfig file, &c&oPlease check for errors!"));;
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public PluginDescriptionFile getDesc() {
        return plugin.getDescription();
    }

    public Plugin pl() {
        return plugin;
    }



    static public ItemStack createItem(Material mat, String name) {

        name = name.replaceAll("&", "");

        ItemStack is = new ItemStack(mat);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        is.setItemMeta(meta);
        return is;
    }

    static public  ItemStack closeMenuItem() {
        return createItem(Material.LAVA_BUCKET, ChatColor.translateAlternateColorCodes('&', "&6Closes this &cMenu."));
    }

    static public void closeMenu(Player p) {
        p.closeInventory();
    }


    /**
     * [+]---------------[]
     *  |
     */

}
