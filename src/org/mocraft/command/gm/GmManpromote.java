package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmManpromote implements GmCommand {

    protected UUID target;
    protected String group;

    public GmManpromote() {}

    public GmManpromote(UUID target, String group) {
        this.target = target;
        this.group = group;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManpromote init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        this.group = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manpromote " + Bukkit.getPlayer(target).getName() + " " + group;
    }

    @Override
    public String label() {
        return "manpromote";
    }

    @Override
    public GmCommand reflect() {
        return new GmMandemote(target, group);
    }
}
