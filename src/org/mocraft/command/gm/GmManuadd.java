package org.mocraft.command.gm;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.UUID;

public class GmManuadd implements GmCommand {

    protected UUID target;
    protected String group;
    protected World world;

    public GmManuadd() {}

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmManuadd init(String[] args) {
        this.target = Bukkit.getPlayer(args[1]).getUniqueId();
        this.group = args[2];
        this.world = args.length > 3 ? Bukkit.getWorld(args[3]) : null;
        return this;
    }

    @Override
    public String toStringCommand() {
        return "manuadd " + Bukkit.getPlayer(target).getName() + " " + group + (world == null ? " " + world.getName() : "");
    }

    @Override
    public String label() {
        return "manuadd";
    }

    @Override
    public GmCommand reflect() {
        return new GmManudel(target);
    }
}
