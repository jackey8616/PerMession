package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PexUseraddp implements PexCommand, PexPlayerCommand {

    protected String target;
    protected String permission;
    protected World world;

    public PexUseraddp() {}

    public PexUseraddp(String target, String permission, World world) {
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
        this.target = args[2];
        this.permission = args[4];
        this.world = args.length > 5 ? Bukkit.getWorld(args[5]) : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex user " + target + " add " + permission + (world != null ? " " + world : "") ; }

    @Override
    public String label() {
        return "pex user <user> add";
    }

    @Override
    public PexCommand reflect() {
        return new PexUserremovep(target, permission, world);
    }

    @Override
    public Player getPlayer() { return Bukkit.getPlayer(target); }

}
