package me.ES359.DisplayInfo.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Created by ES359 on 1/20/15.
 */
public class Inform
{


    public String permissionError() {
        return ChatColor.translateAlternateColorCodes('&', "&7You don't have permission for this.");
    }

    public String commandError() {
        return ChatColor.translateAlternateColorCodes('&', "&6&oThe requested command function couldn't be completed&a.");
    }

    public String chatInformEnabled() {

        return ChatColor.translateAlternateColorCodes('&',"&b&oGlobal &2Chat &6has been &a&o&lEnabled!");
    }
    public String chatinformDisabled() {
        return ChatColor.translateAlternateColorCodes('&',"&b&oGlobal &2Chat &chas been &c&o&lDisabled!");
    }

    public String ConsoleEnabled() {
        return ChatColor.translateAlternateColorCodes('&'," &6&oIs now &a&o&nEnabled&b.");
    }
    public String ConsoleDisabled() {
        return ChatColor.translateAlternateColorCodes('&', "&cIs now &6&n&oDisabled&4.");
    }


    public String ConsoleError()
    {
        return ChatColor.translateAlternateColorCodes('&', "&4Error &l&7> &6This command isn't for use by the &c[&2Console&c].");
    }

    public String ArgumentsError()
    {
        return ChatColor.translateAlternateColorCodes('&', "&4Error &l&7> &6You have used incorrect arguments.");
    }

    public String functionError()
    {
        return ChatColor.translateAlternateColorCodes('&', "&4Error &l&7> &cCould not complete the requested function.");
    }


    public void logToConsole(String l) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', l));
    }

    public void globalBroadcast(String broadcast) {
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', broadcast));
    }

}
