package org.mocraft.reflect;

import org.mocraft.PerMession;
import org.mocraft.command.pex.*;

import java.util.HashMap;
import java.util.Map;

public class PexReflector extends VanillaReflector implements Reflector {

    public Map<String, PexCommand> reflectableMap = new HashMap<String, PexCommand>();

    public PexReflector(PerMession instance) {
        super(instance);
        reflectableMap.put("pex user <user> add", new PexUseraddp());
        reflectableMap.put("pex user <user> remove", new PexUserremovep());
        reflectableMap.put("pex user <user> swap", new PexUserswap());
        reflectableMap.put("pex user <user> group set", new PexUsergset());
        reflectableMap.put("pex user <user> group remove", new PexUsergremove());
        reflectableMap.put("pex group <group> add", new PexGroupaddp());
        reflectableMap.put("pex group <group> remove", new PexGroupremovep());
        reflectableMap.put("pex group <group> user add", new PexGroupuadd());
        reflectableMap.put("pex group <group> user remove", new PexGroupuremove());
        reflectableMap.put("pex promote", new PexPromote());
        reflectableMap.put("pex demote", new PexDemote());
        reflectableMap.put("promote", new PexOutterPromote());
        reflectableMap.put("demote", new PexOutterDemote());
    }

    @Override
    public String reflect(String label, String[] args) {
        String anchor = "";
        if(args[0].equalsIgnoreCase("pex")) {
            anchor += "pex ";
            if(args[1].equalsIgnoreCase("user")) {
                anchor += "user <user> ";
                if(args[3].equalsIgnoreCase("group")) {
                    anchor += "group " + args[4];
                } else {
                    anchor += args[3];
                }
            } else if(args[1].equalsIgnoreCase("group")) {
                anchor += "group <group> ";
                if(args[3].equalsIgnoreCase("user")) {
                    anchor += "user " + args[4];
                } else {
                    anchor += args[3];
                }
            } else {
                anchor += args[1];
            }
        } else {
            anchor = args[0];
        }

        if (reflectableMap.containsKey(anchor)) {
            return reflectableMap.get(anchor).init(args).reflect().toStringCommand();
        } else {
            return null;
        }
    }

}
