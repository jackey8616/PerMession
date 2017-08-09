package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

@Deprecated
public class GMTask extends VanillaTask implements Task {

    public GMTask(PerMession instance, CommandSender sender, boolean reflect, int delay, int period, String cmd) {
        super(instance, sender, reflect, delay, period, cmd);
        this.instance = instance;
    }
}
