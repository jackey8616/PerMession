package org.mocraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Iterator;

/**
 * Created by Clode on 2016/8/29.
 */
public class PerMession extends JavaPlugin {

    public boolean groupManager = false;

    @Override
    public void onEnable() {
        groupManager = getServer().getPluginManager().getPlugin("GroupManager") != null;

    }

    @Override
    public void onDisable() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("perme") && sender.isOp()) {
            //System.out.println(label);
            for(String str : args)
                //System.out.println(str);
            //CommandTask task = new CommandTask((Player) sender, args[0], args);
            //task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 1L));
            return true;
        }
        return false;
    }

}
