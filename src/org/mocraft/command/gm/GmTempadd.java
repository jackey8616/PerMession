package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GmTempadd implements GmCommand {

    protected Player target;

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmTempadd init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]);
        return this;
    }

    @Override
    public String toStringCommand() {
        return "tempadd " + target.getDisplayName();
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
