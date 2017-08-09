package org.mocraft.command.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;
import org.mocraft.command.executor.argument.PmReflectArgs;
import org.mocraft.command.executor.argument.PmTaskArgs;

public class PermeExecutor implements CommandExecutor {

    private PerMession intance;

    public PermeExecutor(PerMession instance) {
        this.intance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        try {
            if (cmd.getName().equalsIgnoreCase("perme") && sender.isOp()) {
                if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(cmd.getUsage());
                } else if(args[0].startsWith("tasks")) {
                    new PmTaskArgs(intance, sender, args);
                } else if(args[0].startsWith("dur")) {
                    new PmReflectArgs(intance, sender, args);
                } else {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            intance.getLogger().severe(e.getMessage());
        }
        return false;
    }
}
