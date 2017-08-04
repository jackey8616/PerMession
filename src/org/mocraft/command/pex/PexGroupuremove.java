package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public class PexGroupuremove extends PexGroupuadd implements PexCommand {

    public PexGroupuremove() {}

    public PexGroupuremove(String group, UUID target, World world) {
        super(group, target, world);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexGroupuremove init(String[] args) {
        this.group = args[2];
        this.target = Bukkit.getPlayer(args[5]).getUniqueId();
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex group " + group + " user remove " + Bukkit.getPlayer(target).getName() + (world != null ? " " + world.getName() : "");
    }

    @Override
    public String label() {
        return "pex group <group> user remove";
    }

    @Override
    public PexCommand reflect() {
        return new PexGroupuadd(group, target, world);
    }
}
