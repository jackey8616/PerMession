package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PexUsergset implements PexCommand, PexPlayerCommand {

    protected UUID target;
    protected String group;
    protected World world;

    public PexUsergset() {}

    public PexUsergset(UUID target, String group, World world) {
        this.target = target;
        this.group = group;
        this.world = world;
    }

    @Override
    public boolean reflectable() { return true; }

    @Override
    public PexUsergset init(String[] args) {
        this.target = Bukkit.getPlayer(args[2]).isOnline() ? Bukkit.getPlayer(args[2]).getUniqueId() : Bukkit.getOfflinePlayer(args[2]).getUniqueId();
        this.group = args[5];
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex user " + Bukkit.getPlayer(target).getName() + " group set " + group + (world != null ? " " + world.getName() : "");
    }

    @Override
    public String label() {
        return "pex user <user> group set";
    }

    @Override
    public PexCommand reflect() {
        return new PexUsergremove(target, group, world);
    }

    @Override
    public Player getPlayer() { return Bukkit.getPlayer(target); }

}
