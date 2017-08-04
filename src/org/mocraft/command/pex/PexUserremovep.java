package org.mocraft.command.pex;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public class PexUserremovep extends PexUseraddp implements PexCommand {

    public PexUserremovep() {}

    public PexUserremovep(UUID target, String permission, World world) {
        super(target, permission, world);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public String toStringCommand() {
        return "pex user " + Bukkit.getPlayer(target).getName() + " remove " + permission + (world != null ? " " + world : "") ;
    }

    @Override
    public String label() {
        return "pex user <user> remove";
    }

    @Override
    public PexCommand reflect() {
        return new PexUseraddp(target, permission, world);
    }
}
