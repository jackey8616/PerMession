package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GmMandemote extends GmManpromote implements GmCommand {

    public GmMandemote() {}

    public GmMandemote(Player target, String group) {
        this.target = target;
        this.group = group;
    }

    @Override
    public GmMandemote init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]);
        this.group = args[2];
        return this;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public String toStringCommand() {
        return "mandemote " + target.getDisplayName() + " " + group;
    }

    @Override
    public String label() { return "mandemote"; }


    @Override
    public GmCommand reflect() {
        return new GmManpromote(target, group);
    }
}
