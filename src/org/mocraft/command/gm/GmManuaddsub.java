package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GmManuaddsub implements GmCommand {

    protected Player target;
    protected String group;

    public GmManuaddsub() {}

    public GmManuaddsub(Player target, String group) {
        this.target = target;
        this.group = group;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManuaddsub init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]);
        this.group = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manuaddsub " + target.getDisplayName() + " " + group;
    }

    @Override
    public String label() {
        return "manuaddsub";
    }

    @Override
    public GmCommand reflect() {
        return new GmManudelsub(target, group);
    }
}
