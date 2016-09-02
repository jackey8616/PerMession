package org.mocraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

/**
 * Created by Clode on 2016/8/29.
 */
public class PerMession extends JavaPlugin {

    @Override
    public void onEnable() {
        /** Debug
                    Iterator<Permission> per = Bukkit.getPluginManager().getPermissions().iterator();
                    while(per.hasNext()) {
                        System.out.println(per.next().getName());
                    }
                **/
    }

    @Override
    public void onDisable() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("per") && sender.isOp()) {
            CommandTask task = new CommandTask((Player) sender, args[0], args);
            task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 1L));
            return true;
        }
        return false;
    }

}
