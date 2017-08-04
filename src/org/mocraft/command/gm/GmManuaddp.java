package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GmManuaddp implements GmCommand {

    protected Player target;
    protected ArrayList<String> permissions = new ArrayList<String>();

    public GmManuaddp() {}

    public GmManuaddp(Player target, String[] permissions) {
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
        this.target = Bukkit.getPlayer(args[1]);
        for(int i = 2; i < args.length; ++i)
            this.permissions.add(args[i]);
        return this;
    }

    @Override
    public String toStringCommand() {
        String cmd = "manuaddp " + target.getDisplayName() + " ";
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
