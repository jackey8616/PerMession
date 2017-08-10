package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PexPromote implements PexCommand, PexPlayerCommand {

    protected String target;
    protected String ladder;

    public PexPromote() {}

    public PexPromote(String target, String ladder) {
        this.target = target;
        this.ladder = ladder;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexPromote init(String[] args) {
        this.target = args[2];
        this.ladder = args.length > 3 ? args[3] : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex promote " + target + (ladder != null ? " " + ladder : ""); }

    @Override
    public String label() {
        return "pex promote <user>";
    }

    @Override
    public PexCommand reflect() {
        return new PexDemote(target, ladder);
    }

    @Override
    public Player getPlayer() { return Bukkit.getPlayer(target); }

}
