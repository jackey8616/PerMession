package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GmManpromote implements GmCommand {

    protected Player target;
    protected String group;

    public GmManpromote() {}

    public GmManpromote(Player target, String group) {
        this.target = target;
        this.group = group;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManpromote init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]);
        this.group = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manpromote " + target.getDisplayName() + " " + group;
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
