package org.mocraft.command.pex;

import org.bukkit.World;

public class PexUserremovep extends PexUseraddp {

    public PexUserremovep() {}

    public PexUserremovep(String target, String permission, World world) {
        super(target, permission, world);
    }

    @Override
    public String toStringCommand() { return "pex user " + target + " remove " + permission + (world != null ? " " + world : "") ; }

    @Override
    public String label() {
        return "pex user <user> remove";
    }

    @Override
    public PexCommand reflect() {
        return new PexUseraddp(target, permission, world);
    }

}
