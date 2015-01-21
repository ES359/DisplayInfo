package me.ES359.DisplayInfo.commands;

import me.ES359.DisplayInfo.events.Displays;
import me.ES359.DisplayInfo.utils.Inform;
import me.ES359.DisplayInfo.utils.SettingsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ES359 on 1/20/15.
 */
public class DisplayCommand extends Inform implements CommandExecutor {

    Displays d = new Displays();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(commandError());
        }

        SettingsManager sm = SettingsManager.getControllerInstance();

        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("displayinfo")){
            if(!p.hasPermission("displayinfo.command")){
                p.sendMessage(permissionError());
            }else {
                if(args.length < 1) {
                   d.ingameDisplay(p,"&3&oUser: &a%user%.\n&3UUID: &6%UUID%\n&3World: &a%world%\n&3OP: &a%op%\n&3Ip: &a%ip%");
                }
            }
        }
        return true;
    }
}
