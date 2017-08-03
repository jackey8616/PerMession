package org.mocraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.mocraft.tasks.CommandTask;
import org.mocraft.tasks.GroupManagerTask;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Clode on 2016/8/29.
 */
public class PerMession extends JavaPlugin {

    public boolean groupManager = false;

    public ArrayList<CommandTask> tasks = new ArrayList<CommandTask>();

    @Override
    public void onEnable() {
        groupManager = getServer().getPluginManager().getPlugin("GroupManager") != null;

    }

    @Override
    public void onDisable() {}

    public void assignTask(CommandSender sender, int reflect, int period, int argsIndex, String[] args) {
        String command = "";
        CommandTask task = null;
        for(int i = argsIndex; i < args.length; ++i)
            command += args[i] + " ";
        if(groupManager) {
            task = new GroupManagerTask(this, sender, reflect, period, command.trim());
        }
        task.setId(this.getServer().getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 20L));
        tasks.add(task);
        return;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("perme") && sender.isOp()) {
            if(args.length == 0 || args[0].equalsIgnoreCase("help")){
                sender.sendMessage(cmd.getUsage());
            } else if(args[0].equalsIgnoreCase("dur") || args[0].equalsIgnoreCase("duration")) {
                int duration = Integer.valueOf(args[1]);
                assignTask(sender, 0, duration, 2, args);
            } else if(args[0].equalsIgnoreCase("dur-reflect") || args[0].equalsIgnoreCase("duration-reflect")) {
                int duration = Integer.valueOf(args[1]);
                assignTask(sender, 1, duration, 2, args);
            }
            return true;
        }
        return false;
    }

}
