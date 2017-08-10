package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PexOutterPromote implements PexCommand, PexPlayerCommand {

    protected String target;

    public PexOutterPromote() {}

    public PexOutterPromote(String target) {
        this.target = target;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexOutterPromote init(String[] args) {
        this.target = args[1];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "promote " + target;
    }

    @Override
    public String label() {
        return "promote";
    }

    @Override
    public PexCommand reflect() {
        return new PexOutterDemote(target);
    }

    @Override
    public Player getPlayer() { return Bukkit.getPlayer(target); }

}
