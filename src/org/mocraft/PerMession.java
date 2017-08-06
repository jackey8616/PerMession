package org.mocraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.mocraft.reflect.GMReflector;
import org.mocraft.reflect.PexReflector;
import org.mocraft.reflect.VanillaReflector;
import org.mocraft.tasks.GMTask;
import org.mocraft.tasks.PexTask;
import org.mocraft.tasks.VanillaTask;

import java.util.ArrayList;

/**
 * Created by Clode on 2016/8/29.
 */
public class PerMession extends JavaPlugin {

    public boolean permissionsEx = false;
    public JavaPlugin pexInstance;
    public PexReflector pexReflector;
    public boolean groupManager = false;
    public JavaPlugin gmInstance;
    public GMReflector gmReflector;

    public VanillaReflector vanillaReflector;
    public ArrayList<VanillaTask> tasks = new ArrayList<VanillaTask>();

    @Override
    public void onEnable() {
        permissionsEx = getServer().getPluginManager().getPlugin("PermissionsEx") != null;
        groupManager = getServer().getPluginManager().getPlugin("GroupManager") != null;
        vanillaReflector = new VanillaReflector(this);

        if(permissionsEx) {
            pexInstance = (JavaPlugin) getServer().getPluginManager().getPlugin("PermissionsEx");
            pexReflector = new PexReflector(this);
        } else if(groupManager) {
            gmInstance = (JavaPlugin) getServer().getPluginManager().getPlugin("GroupManager");
            gmReflector = new GMReflector(this);
        }
    }

    @Override
    public void onDisable() {}

    public void assignTask(CommandSender sender, int reflect, int period, int argsIndex, String[] args) {
        String command = "";
        VanillaTask task = null;
        for (int i = argsIndex; i < args.length; ++i)
            command += args[i] + " ";
        if(permissionsEx && command.startsWith("pex")) {
            task = new PexTask(this, sender, reflect, period, command.trim());
        } else if(groupManager && gmReflector.reflect(command) != null) {
            task = new GMTask(this, sender, reflect, period, command.trim());
        } else {
            task = new VanillaTask(this, sender, reflect, period, command.trim());
        }
        task.setId(this.getServer().getScheduler().scheduleSyncRepeatingTask(this, task, 0L, 20L));
        tasks.add(task);
        return;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("perme") && sender.isOp()) {
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(cmd.getUsage());
            } else if(args[0].equalsIgnoreCase("tasks")) {
                sender.sendMessage(String.format("| I D |       T I M E       |    COMMAND / REFLECT"));
                for(VanillaTask task : tasks)
                    sender.sendMessage(String.format("| %03d | %s | %s | %s |", task.getId(), task.getStartTimeString(), task.getCommand(), task.getReflectCommand()));
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
