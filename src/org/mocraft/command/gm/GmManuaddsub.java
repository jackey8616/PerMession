package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmManuaddsub implements GmCommand {

    protected UUID target;
    protected String group;

    public GmManuaddsub() {}

    public GmManuaddsub(UUID target, String group) {
        this.target = target;
        this.group = group;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManuaddsub init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        this.group = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manuaddsub " + Bukkit.getPlayer(target).getName() + " " + group;
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
