package org.mocraft.command.pex;

import org.bukkit.Bukkit;

import java.util.UUID;

public class PexOutterPromote implements PexCommand {

    protected UUID target;

    public PexOutterPromote() {}

    public PexOutterPromote(UUID target) {
        this.target = target;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexOutterPromote init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        return this;
    }

    @Override
    public String toStringCommand() {
        return "promote " + Bukkit.getPlayer(target).getName();
    }

    @Override
    public String label() {
        return "promote";
    }

    @Override
    public PexCommand reflect() {
        return new PexOutterDemote(target);
    }
}
