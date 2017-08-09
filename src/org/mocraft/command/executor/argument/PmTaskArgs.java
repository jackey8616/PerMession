package org.mocraft.command.executor.argument;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;
import org.mocraft.tasks.VanillaTask;

public class PmTaskArgs {

    private PerMession instance;
    private CommandSender sender;

    /*              [0]     [1]     [2]
        /<command>  tasks                   - List all un-execute tasks.
        /<command>  tasks   delete  <id>    - Execute <cmd> right now and execute <reflect-cmd> after <period> sec.
    */

    public PmTaskArgs(PerMession instance, CommandSender sender, String[] args) {
        this.instance = instance;
        this.sender = sender;
        if(args.length == 1) {
            list();
        } else {
            if (args[1].equalsIgnoreCase("delete")) {
                delete(args);
            }
        }
    }

    private void list() {
        sender.sendMessage(String.format("| I D |       T I M E       |    COMMAND / REFLECT"));
        for (int i = 0; i < instance.tasks.size(); ++i) {
            VanillaTask task = instance.tasks.get(i);
            sender.sendMessage(String.format("| % 3d | %s | %s | %s |", i, task.getStartTimeString(), task.getCommand(), task.getReflectCommand()));
        }
    }

    private void delete(String[] args) {
        VanillaTask task = instance.tasks.get(Integer.valueOf(args[2]));

        if(task == null) return;
        Bukkit.getScheduler().cancelTask(task.getId());
        instance.tasks.remove(task);
        sender.sendMessage("Removed task id: " + args[2] + ".");
    }

}
