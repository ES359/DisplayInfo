package me.ES359.DisplayInfo.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by ES359 on 1/20/15.
 */
public class DebugCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {

        if(!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player)sender;


        Debug debug = new Debug();

        /*
        Implement an Array list of hardcoders that can access the command.

        Make sure to counter for UUID name changes.
         */

        if(cmd.getName().equalsIgnoreCase("di-debug")) {
            if(args.length < 1) {
                sender.sendMessage("USAGE: /di-debug enabled <TRUE || FALSE>");
            }else {
                if(args.length < 3) {
                    if(args[0].equalsIgnoreCase("enabled")) {
                        if(args[1].equalsIgnoreCase("true")) {
                            debug.setDebugStatus(true);
                            debug.getStatus(p);
                            //sender.sendMessage(ChatColor.GRAY + "Debug statements have been enabled!");
                        }else if(args[0].equalsIgnoreCase("enabled")) {
                            if(args[1].equalsIgnoreCase("false")) {
                                debug.setDebugStatus(false);
                                debug.getStatus(p);
                                //sender.sendMessage(ChatColor.YELLOW + "Debug statements have been disabled.");
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
