package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class PexUsergremove extends PexUsergset {

    public PexUsergremove() {}

    public PexUsergremove(String target, String group, World world) {
            super(target, group, world);
    }

    @Override
    public PexUsergremove init(String[] args) {
        this.target = args[2];
        this.group = args[5];
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex user " + target + " group remove " + group + (world != null ? " " + world.getName() : "");
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
