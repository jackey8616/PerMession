package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;

public class GroupManagerTask extends CommandTask {

    public GroupManagerTask(PerMession instance, CommandSender sender, Player target, int period, String cmd) {
        super(instance, sender, target, period, cmd);
    }

    public String commandReplace(String cmd) {
        String[] splitCmd = cmd.split(" ");
        if(splitCmd[0].contains("add"))
            cmd.replace(splitCmd[0], splitCmd[0].replace("add", "del"));
        else if(splitCmd[0].contains("del"))
            cmd.replace(splitCmd[0], splitCmd[0] = splitCmd[0].replace("del", "add"));
        return cmd;
    }

    @Override
    public void run() {
        if(ZonedDateTime.now().isAfter(endTime) || ZonedDateTime.now().isEqual(endTime)) {
            instance.getServer().getScheduler().cancelTask(id);
            instance.getServer().dispatchCommand(sender, commandReplace(command));
        }
    }
}
