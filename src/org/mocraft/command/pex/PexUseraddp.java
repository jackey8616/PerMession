package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public class PexUseraddp implements PexCommand {

    protected UUID target;
    protected String permission;
    protected World world;

    public PexUseraddp() {}

    public PexUseraddp(UUID target, String permission, World world) {
        this.target = target;
        this.permission = permission;
        this.world = world;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexUseraddp init(String[] args) {
        this.target = Bukkit.getPlayer(args[2]).getUniqueId();
        this.permission = args[4];
        this.world = args.length > 5 ? Bukkit.getWorld(args[5]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "pex user " + Bukkit.getPlayer(target).getName() + " add " + permission + (world != null ? " " + world : "") ;
    }

    @Override
    public String label() {
        return "pex user <user> add";
    }

    @Override
    public PexCommand reflect() {
        return new PexUserremovep(target, permission, world);
    }
}