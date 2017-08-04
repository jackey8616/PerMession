package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public class PexGroupuadd implements PexCommand {

    protected String group;
    protected UUID target;
    protected World world;

    public PexGroupuadd() {}

    public PexGroupuadd(String group, UUID target, World world) {
        this.group = group;
        this.target = target;
        this.world = world;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexGroupuadd init(String[] args) {
        this.group = args[2];
        this.target = Bukkit.getPlayer(args[5]).getUniqueId();
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex group " + group + " user add " + Bukkit.getPlayer(target).getName() + (world != null ? " " + world.getName() : "");
    }

    @Override
    public String label() {
        return "pex group <group> user add";
    }

    @Override
    public PexCommand reflect() {
        return new PexGroupuremove(group, target, world);
    }
}
