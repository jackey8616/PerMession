package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PexGroupuadd implements PexCommand, PexPlayerCommand {

    protected String group;
    protected String target;
    protected World world;

    public PexGroupuadd() {}

    public PexGroupuadd(String group, String target, World world) {
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
        this.target = args[5];
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex group " + group + " user add " + target + (world != null ? " " + world.getName() : ""); }

    @Override
    public String label() {
        return "pex group <group> user add";
    }

    @Override
    public PexCommand reflect() {
        return new PexGroupuremove(group, target, world);
    }

    @Override
    public Player getPlayer() { return Bukkit.getPlayer(target); }

}
