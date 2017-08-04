package org.mocraft.command.pex;

import org.bukkit.Bukkit;

import java.util.UUID;

public class PexOutterDemote extends PexOutterPromote implements PexCommand {

    public PexOutterDemote() {}

    public PexOutterDemote(UUID target) {
        this.target = target;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexOutterDemote init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        return this;
    }

    @Override
    public String toStringCommand() {
        return "demote " + Bukkit.getPlayer(target).getName();
    }

    @Override
    public String label() {
        return "demote";
    }

    @Override
    public PexCommand reflect() {
        return new PexOutterPromote(target);
    }
}
