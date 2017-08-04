package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmMandemote extends GmManpromote implements GmCommand {

    public GmMandemote() {}

    public GmMandemote(UUID target, String group) {
        this.target = target;
        this.group = group;
    }

    @Override
    public GmMandemote init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        this.group = args[2];
        return this;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public String toStringCommand() {
        return "mandemote " + Bukkit.getPlayer(target).getName() + " " + group;
    }

    @Override
    public String label() { return "mandemote"; }


    @Override
    public GmCommand reflect() {
        return new GmManpromote(target, group);
    }
}
