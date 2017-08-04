package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;

public class GMTask extends CommandTask {

    private PerMession instance;

    public GMTask(PerMession instance, CommandSender sender, int reflect, int period, String cmd) {
        super(instance, sender, reflect, period, cmd);
        this.instance = instance;
        if(reflect != 0)
            instance.getServer().dispatchCommand(sender, cmd);
    }

    public String commandReplace(int reflect, String cmd) {
        if(reflect == 0) {
            return cmd;
        } else if(reflect == 1) {
            System.out.println(cmd);
            String[] splitCmd = cmd.split(" ");
            return instance.gmReflect.reflect(splitCmd[0], splitCmd);
            /**
            if(splitCmd[0].equalsIgnoreCase("manuadd"))
                cmd = "manudel " + splitCmd[1];
            else if(splitCmd[0].equalsIgnoreCase("manuaddv"))
                cmd = "manudelv " + splitCmd[1] + " " + splitCmd[2];
            else if(splitCmd[0].equalsIgnoreCase("mangaddv"))
                cmd = "mangdelv " + splitCmd[1] + " " + splitCmd[2];
            else if (splitCmd[0].contains("add"))
                cmd = cmd.replace(splitCmd[0], splitCmd[0].replace("add", "del"));
            else if (splitCmd[0].contains("del"))
                cmd = cmd.replace(splitCmd[0], splitCmd[0] = splitCmd[0].replace("del", "add"));
            return cmd;**/
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
