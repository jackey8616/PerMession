package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmManudelp extends GmManuaddp implements GmCommand {

    public GmManudelp() {}

    public GmManudelp(UUID target, String[] permissions) {
        this.target = target;
        for(String per : permissions)
            this.permissions.add(per);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManudelp init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        for(int i = 2; i < args.length; ++i)
            this.permissions.add(args[i]);
        return this;
    }

    @Override
    public String toStringCommand() {
        String cmd = "manudelp " + Bukkit.getPlayer(target).getName() + " ";
        for(String per : permissions)
            cmd += per + " ";
        return cmd.trim();
    }

    @Override
    public String label() {
        return "manudelp";
    }

    @Override
    public GmCommand reflect() {
        return new GmManuaddp(target, permissions.toArray(new String[permissions.size()]));
    }

}
