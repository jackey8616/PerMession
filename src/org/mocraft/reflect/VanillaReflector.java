package org.mocraft.reflect;

import org.bukkit.command.Command;
import org.mocraft.PerMession;
import org.mocraft.command.VaLoadedCommand;

import java.util.HashMap;
import java.util.Map;

public class VanillaReflector implements Reflector {

    protected PerMession instance;

    public Map<String, VaLoadedCommand> commandPool = new HashMap<String, VaLoadedCommand>();
    public Map<String, Command> reflectableMap = new HashMap<String, Command>();

    public VanillaReflector(PerMession instance) {
        this.instance = instance;
    }

    @Override
    public String reflect(String command) {
        String[] cmd = command.split(" ");
        return reflect(cmd[0], cmd);
    }

    @Override
    public String reflect(String label, String[] args) {
        if(instance.permissionsEx && label.equalsIgnoreCase("pex")) {
            return instance.pexReflector.reflect(label, args);
        } else if (instance.groupManager && instance.gmReflector.reflectableMap.containsKey(label)) {
            return instance.gmReflector.reflectableMap.get(label).init(args).reflect().toStringCommand();
        } else {
            return null;
        }
    }

}
