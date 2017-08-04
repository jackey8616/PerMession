package org.mocraft.command.gm;

import org.bukkit.Bukkit;

public class GmTempdel extends GmTempadd implements GmCommand {

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmTempdel init(String[] args) {
        return this;
    }

    @Override
    public String toStringCommand() {
        return "tempdel " + Bukkit.getPlayer(target).getName();
    }

    @Override
    public String label() { return "tempdel"; }

    @Override
    public GmCommand reflect() {
        return new GmTempadd();
    }

}
