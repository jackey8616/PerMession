package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class PexGroupremovep extends PexGroupaddp {

    public PexGroupremovep() {}

    public PexGroupremovep(String group, String permission, World world) {
        super(group, permission, world);
    }

    @Override
    public PexGroupremovep init(String[] args) {
        this.group = args[2];
        this.permission = args[4];
        this.world = args.length > 5 ? Bukkit.getWorld(args[5]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex group " + group + " remove " + permission + (world != null ? " " + world.getName() : "");
    }

    @Override
    public String label() {
        return "pex group <group> remove";
    }

    @Override
    public PexCommand reflect() {
        return new PexGroupaddp(group, permission, world);
    }
}
