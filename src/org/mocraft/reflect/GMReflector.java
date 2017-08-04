package org.mocraft.reflect;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import org.mocraft.PerMession;

import java.util.HashMap;
import java.util.Map;

public class GMReflector {

    public Map<Command, Command> commands = new HashMap<Command, Command>();

    public GMReflector(PerMession instance) {
        JavaPlugin groupManager = (JavaPlugin)instance.getServer().getPluginManager().getPlugin("GroupManager");

        commands.put(groupManager.getCommand("manuadd"), groupManager.getCommand("manudel"));
        commands.put(groupManager.getCommand("manuaddsub"), groupManager.getCommand("manudelsub"));
        commands.put(groupManager.getCommand("manudelsub"), groupManager.getCommand("manuaddsub"));
        commands.put(groupManager.getCommand("mangadd"), groupManager.getCommand("mangdel"));
        commands.put(groupManager.getCommand("mangdel"), groupManager.getCommand("mangadd"));
        commands.put(groupManager.getCommand("manuaddp"), groupManager.getCommand("manudelp"));
        commands.put(groupManager.getCommand("manudelp"), groupManager.getCommand("manuaddp"));
        commands.put(groupManager.getCommand("mangaddp"), groupManager.getCommand("mangdelp"));
        commands.put(groupManager.getCommand("mangdelp"), groupManager.getCommand("mangaddp"));
        commands.put(groupManager.getCommand("mangaddi"), groupManager.getCommand("mangdeli"));
        commands.put(groupManager.getCommand("mangdeli"), groupManager.getCommand("mangaddi"));
        commands.put(groupManager.getCommand("manuaddv"), groupManager.getCommand("manudelv"));
        commands.put(groupManager.getCommand("manudelv"), groupManager.getCommand("manuaddv"));
        commands.put(groupManager.getCommand("mangaddv"), groupManager.getCommand("mangdelv"));
        commands.put(groupManager.getCommand("tempadd"), groupManager.getCommand("tempdel"));
        commands.put(groupManager.getCommand("tempdel"), groupManager.getCommand("tempadd"));
        commands.put(groupManager.getCommand("manpromote"), groupManager.getCommand("mandemote"));
        commands.put(groupManager.getCommand("mandemote"), groupManager.getCommand("manpromote"));
        commands.put(groupManager.getCommand("mantogglevalidate"), groupManager.getCommand("mantogglevalidate"));
        commands.put(groupManager.getCommand("mantogglesave"), groupManager.getCommand("mantogglesave"));
    }

}
