package org.mocraft.command.gm;

import org.bukkit.Bukkit;

import java.util.UUID;

public class GmManuaddv implements GmCommand {

    protected UUID target;
    protected String var, value;

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManuaddv init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        this.var = args[2];
        this.value = args[3];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manuaddv " + Bukkit.getPlayer(target).getName() + " " + var + " " + value;
    }

    @Override
    public String label() {
        return "manuaddv";
    }

    @Override
    public GmCommand reflect() {
        return new GmManudelv(target, var);
    }
}
