package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmManudelv extends GmManuaddv implements GmCommand {

    public GmManudelv() {}

    public GmManudelv(UUID target, String var) {
        this.target = target;
        this.var = var;
    }

    @Override
    public boolean reflectable() {
        return false;
    }

    @Override
    public GmManudelv init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        this.var = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manudelv " + Bukkit.getPlayer(target).getName() + " " + var;
    }

    @Override
    public String label() {
        return "manudelv";
    }

    @Override
    public GmCommand reflect() {
        return null;
    }

}
