package org.mocraft.command.pex;

import org.bukkit.Bukkit;

import java.util.UUID;

public class PexDemote extends PexPromote {

    public PexDemote() {}

    public PexDemote(UUID target, String ladder) {
        super(target, ladder);
    }

    @Override
    public PexDemote init(String[] args) {
        this.target = Bukkit.getPlayer(args[2]).getUniqueId();
        this.ladder = args.length > 3 ? args[3] : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex demote " + Bukkit.getPlayer(target).getName() + (ladder != null ? " " + ladder : ""); }

    @Override
    public String label() {
        return "pex demote <user>";
    }

    @Override
    public PexCommand reflect() {
        return new PexPromote(target, ladder);
    }
}
