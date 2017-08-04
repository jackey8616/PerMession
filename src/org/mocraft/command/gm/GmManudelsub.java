package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GmManudelsub extends GmManuaddsub implements GmCommand {

    public GmManudelsub() { super(); }

    public GmManudelsub(Player target, String group) {
        super(target, group);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManudelsub init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]);
        this.group = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manudelsub " + target.getDisplayName() + " " + group;
    }

    @Override
    public String label() {
        return "manudelsub";
    }

    @Override
    public GmCommand reflect() {
        return new GmManuaddsub(target, group);
    }
}
