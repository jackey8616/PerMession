package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;

@Deprecated
public class PexTask extends VanillaTask implements Task {

    public PexTask(PerMession instance, CommandSender sender, int reflect, int period, String cmd) {
        super(instance, sender, reflect, period, cmd);
    }
}
