package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.UUID;

public class GmManuaddp implements GmCommand {

    protected UUID target;
    protected ArrayList<String> permissions = new ArrayList<String>();

    public GmManuaddp() {}

    public GmManuaddp(UUID target, String[] permissions) {
        this.target = target;
        for(String per : permissions)
            this.permissions.add(per);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManuaddp init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        for(int i = 2; i < args.length; ++i)
            this.permissions.add(args[i]);
        return this;
    }

    @Override
    public String toStringCommand() {
        String cmd = "manuaddp " + Bukkit.getPlayer(target).getName() + " ";
        for(String per : permissions)
            cmd += per + " ";
        return cmd.trim();
    }

    @Override
    public String label() {
        return "manuaddp";
    }

    @Override
    public GmCommand reflect() {
        return new GmManudelp(target, permissions.toArray(new String[permissions.size()]));
    }
}
