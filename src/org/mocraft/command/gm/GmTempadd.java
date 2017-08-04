package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmTempadd implements GmCommand {

    protected UUID target;

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmTempadd init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        return this;
    }

    @Override
    public String toStringCommand() {
        return "tempadd " + Bukkit.getPlayer(target).getName();
    }

    @Override
    public String label() {
        return "tempadd";
    }

    @Override
    public GmCommand reflect() {
        return new GmTempdel();
    }
}
