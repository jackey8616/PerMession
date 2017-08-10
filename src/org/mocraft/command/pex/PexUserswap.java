package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PexUserswap implements PexCommand, PexPlayerCommand {

    protected String target;
    protected String permissionA, permissionB;
    protected World world;

    public PexUserswap() {}

    public PexUserswap(String target, String permissionA, String permissionB, World world) {
        this.target = target;
        this.permissionA = permissionA;
        this.permissionB = permissionB;
        this.world = world;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public PexUserswap init(String[] args) {
        this.target = args[2];
        this.permissionA = args[4];
        this.permissionB = args[5];
        this.world = args.length > 6 ? Bukkit.getWorld(args[6]) : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex user " + target + " swap " + permissionA + " " + permissionB + (world != null ? " " + world.getName() : "" ); }

    @Override
    public String label() {
        return "pex user <user> swap";
    }

    @Override
    public PexCommand reflect() {
        return new PexUserswap(target, permissionB, permissionA, world);
    }

    @Override
    public Player getPlayer() { return Bukkit.getPlayer(target); }

}
