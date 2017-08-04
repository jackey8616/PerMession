package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmManudel implements  GmCommand {

    protected UUID target;

    public GmManudel() {}

    public GmManudel(UUID target) {
        this.target = target;
    }

    @Override
    public boolean reflectable() {
        return false;
    }

    @Override
    public GmManudel init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manudel " + Bukkit.getPlayer(target).getName();
    }

    @Override
    public String label() {
        return "manudel";
    }

    @Override
    public GmCommand reflect() {
        return null;
    }
}
