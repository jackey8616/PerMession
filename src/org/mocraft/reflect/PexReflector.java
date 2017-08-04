package org.mocraft.reflect;

import org.bukkit.plugin.java.JavaPlugin;
import org.mocraft.PerMession;
import org.mocraft.command.pex.*;

import java.util.HashMap;
import java.util.Map;

public class PexReflector {

    public JavaPlugin pexInstance;
    public Map<String, PexCommand> reflectableMap = new HashMap<String, PexCommand>();

    public PexReflector(PerMession instance) {
        pexInstance = (JavaPlugin) instance.getServer().getPluginManager().getPlugin("PermissionEx");
        reflectableMap.put("pex user <user> add", new PexUseraddp());
        reflectableMap.put("pex user <user> remove", new PexUserremovep());
        reflectableMap.put("pex user <user> swap", new PexUserswap());
        reflectableMap.put("pex user <user> group set", new PexUsergset());
        reflectableMap.put("pex user <user> group remove", new PexUsergremove());
        reflectableMap.put("pex group <group> add", new PexGroupaddp());
        reflectableMap.put("pex group <group> remove", new PexGroupremovep());
        reflectableMap.put("pex group <group> user add", new PexGroupuadd());
        reflectableMap.put("pex group <group> user remnove", new PexGroupuremove());
        reflectableMap.put("pex promote", new PexPromote());
        reflectableMap.put("pex demote", new PexDemote());
        reflectableMap.put("promote", new PexOutterPromote());
        reflectableMap.put("demote", new PexOutterDemote());
    }

    public String reflect(String label, String[] args) {
        String cmd = "";
        if (reflectableMap.containsKey(label)) {
            return reflectableMap.get(label).init(args).reflect().toStringCommand();
        } else {
            return null;
        }
    }

}
