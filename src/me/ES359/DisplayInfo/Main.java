package me.ES359.DisplayInfo;

import me.ES359.DisplayInfo.commands.DisplayCommand;
import me.ES359.DisplayInfo.utils.Debug;
import me.ES359.DisplayInfo.utils.DebugCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ES359 on 1/20/15.
 */
public class Main extends JavaPlugin {

    private Debug debug = new Debug();

    public void onEnable() {
        debug.info("&aonEnable method reached!");
        registerAllCommands();
    }




    public void registerAllCommands()
    {
        registerCmd("di-debug", new DebugCommand());
        registerCmd("displayinfo", new DisplayCommand());
        debug.info("&4Commands have been registered.");
    }
    public void registerCmd(String command, CommandExecutor commandExecutor)
    {
        Bukkit.getServer().getPluginCommand(command).setExecutor(commandExecutor);
    }

}
