package me.ES359.DisplayInfo.events;

import me.ES359.DisplayInfo.utils.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ES359 on 1/20/15.
 */
public class Displays {

    SettingsManager sm = SettingsManager.getControllerInstance();


    public void ingameDisplay(Player player, String name) {

        // add permission. name = name.replaceAll("%op%",""+player.isOp());
        // add permission.  name = name.replaceAll("%whitelisted%",""+player.isWhitelisted());

        if (player.hasPermission("displayinfo.ip")) {
            name = name.replaceAll("%ip%", "" + player.getAddress());
        } else {
            name = name.replaceAll("%ip%", "\t-");
            return;
        }
        if (player.hasPermission("display.op")) {
            name = name.replaceAll("%op%", "" + player.isOp());
        } else {
            name = name.replaceAll("%op%", "\t-");
            return;
        }


        if (player.hasPermission("displayinfo.whitelist")) {
            name = name.replaceAll("%whitelist%", "" + player.isWhitelisted())
            ;

        } else {
            name = name.replaceAll("%whitelist%", "\t-");
        }

        name = name.replaceAll("%world%", player.getWorld().getName());
        name = name.replaceAll("%UUID%", "" + player.getUniqueId());
        name = name.replaceAll("%user%", player.getName());
        // //Add permission for IP.  name = name.replaceAll("%IP%", "" + player.getAddress());
        player.sendMessage(sm.header());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', name));
        player.sendMessage(sm.header());
    }

    @Deprecated
    private void runPermissionCheck(Player p) {
        if(p.hasPermission("displayinfo.ip"))
        {

        }
    }

    public void clientDisplay(Player player, String function) {



    }
}
