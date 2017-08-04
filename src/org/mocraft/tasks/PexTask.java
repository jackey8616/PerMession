package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;

public class PexTask extends CommandTask {

    public PerMession instance;

    public PexTask(PerMession instance, CommandSender sender, int reflect, int period, String cmd) {
        super(instance, sender, reflect, period, cmd);
        this.instance = instance;
        if(reflect != 0) {
            instance.getServer().dispatchCommand(sender, cmd);
        }
    }

    public String commandReplace(int reflect, String cmd) {
        if(reflect == 0) {
            return cmd;
        } else if(reflect == 1) {
            String[] splitCmd = cmd.split(" ");
            return instance.pexReflector.reflect(splitCmd[0], splitCmd);
        }
        return null;
    }

    @Override
    public void run() {
        if(ZonedDateTime.now().isAfter(endTime) || ZonedDateTime.now().isEqual(endTime)) {
            instance.getServer().getScheduler().cancelTask(id);
            instance.getServer().dispatchCommand(sender, commandReplace(reflect, command));
        }
    }

}
