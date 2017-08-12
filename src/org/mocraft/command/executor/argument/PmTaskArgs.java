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
        /<command>  tasks   delete  <id>    - Delete a specific task with id in list.
        /<command>  tasks   delete-all       - Delete all tasks in list.
    */

    public PmTaskArgs(PerMession instance, CommandSender sender, String[] args) {
        this.instance = instance;
        this.sender = sender;
        if(args.length == 1) {
            list();
        } else {
            if(args[1].startsWith("log")) {
                log();
            } else if(args[1].startsWith("delete")) {
                delete(args, args[1].contains("all"));
            } else if(args[1].startsWith("save")) {
                save();
            }
        }
    }

    private void list() {
        sender.sendMessage(String.format("| I D |     ASSIGN TIME     |      START TIME     |      END  TIME      |    COMMAND / REFLECT"));
        for (int i = 0; i < instance.tasks.size(); ++i) {
            VanillaTask task = instance.tasks.get(i);
            sender.sendMessage(String.format("| % 3d | %s | %s | %s | %s | %s |", i, task.getAssignTimeString(), task.getStartTimeString(), task.getEndTimeString(), task.getCommand(), task.getReflectCommand()));
        }
    }

    private void log() {
        sender.sendMessage(String.format("|     ASSIGN TIME     |      START TIME     |      END  TIME      |    COMMAND / REFLECT"));
        for(String str : instance.taskLogs)
            sender.sendMessage(str);
    }

    private void save() {
        this.instance.onDisable();
    }

    private void delete(String[] args, boolean all) {
        if(all) {
            sender.sendMessage("Removed all(" + instance.tasks.size() + ") tasks.");
            for(VanillaTask task : instance.tasks)
                instance.getServer().getScheduler().cancelTask(task.getId());
            instance.tasks.clear();
        } else {
            VanillaTask task = instance.tasks.get(Integer.valueOf(args[2]));

            if (task == null) return;
            Bukkit.getScheduler().cancelTask(task.getId());
            instance.tasks.remove(task);
            sender.sendMessage("Removed task id: " + args[2] + ".");
        }
    }

}
