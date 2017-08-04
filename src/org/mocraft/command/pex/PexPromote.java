package org.mocraft.command.pex;

import org.bukkit.Bukkit;

import java.util.UUID;

public class PexPromote implements PexCommand {

    protected UUID target;
    protected String ladder;

    public PexPromote() {}

    public PexPromote(UUID target, String ladder) {
        this.target = target;
        this.ladder = ladder;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexPromote init(String[] args) {
        this.target = Bukkit.getPlayer(args[2]).getUniqueId();
        this.ladder = args.length > 3 ? args[3] : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex promote " + Bukkit.getPlayer(target).getName() + (ladder != null ? " " + ladder : "");
    }

    @Override
    public String label() {
        return "pex promote <user>";
    }

    @Override
    public PexCommand reflect() {
        return new PexDemote(target, ladder);
    }
}
