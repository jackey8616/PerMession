package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class PexGroupuremove extends PexGroupuadd {

    public PexGroupuremove() {}

    public PexGroupuremove(String group, String target, World world) {
        super(group, target, world);
    }

    @Override
    public PexGroupuremove init(String[] args) {
        this.group = args[2];
        this.target = args[5];
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex group " + group + " user remove " + target + (world != null ? " " + world.getName() : ""); }

    @Override
    public String label() {
        return "pex group <group> user remove";
    }

    @Override
    public PexCommand reflect() {
        return new PexGroupuadd(group, target, world);
    }

}
