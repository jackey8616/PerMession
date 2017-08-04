package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public class PexUsergremove extends PexUsergset implements PexCommand {

    public PexUsergremove() {}

    public PexUsergremove(UUID target, String group, World world) {
        super(target, group, world);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexUsergremove init(String[] args) {
        this.target = Bukkit.getPlayer(args[2]).getUniqueId();
        this.group = args[5];
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex user " + Bukkit.getPlayer(target).getName() + " group remove " + group + (world != null ? " " + world.getName() : "");
    }

    @Override
    public String label() {
        return "pex user <user> group remove";
    }

    @Override
    public PexCommand reflect() {
        return new PexUsergset(target, group, world);
    }
}
