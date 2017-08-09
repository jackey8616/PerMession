package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class PexGroupaddp implements PexCommand {

    protected String group, permission;
    protected World world;

    public PexGroupaddp() {}

    public PexGroupaddp(String group, String permission, World world) {
        this.group = group;
        this.permission = permission;
        this.world = world;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexGroupaddp init(String[] args) {
        this.group = args[2];
        this.permission = args[4];
        this.world = args.length > 5 ? Bukkit.getWorld(args[5]) : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex group " + group + " add " + permission + (world != null ? " " + world.getName() : ""); }

    @Override
    public String label() {
        return "pex group <group> add";
    }

    @Override
    public PexCommand reflect() {
        return new PexGroupremovep(group, permission, world);
    }
}
