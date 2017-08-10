package org.mocraft;

import org.bukkit.plugin.java.JavaPlugin;
import org.mocraft.command.executor.PermeExecutor;
import org.mocraft.config.ConfigManager;
import org.mocraft.reflect.GMReflector;
import org.mocraft.reflect.PexReflector;
import org.mocraft.reflect.VanillaReflector;
import org.mocraft.tasks.VanillaTask;

import java.util.ArrayList;

/**
 * Created by Clode on 2016/8/29.
 */
public class PerMession extends JavaPlugin {

    public ConfigManager config;

    public boolean permissionsEx = false;
    public JavaPlugin pexInstance;
    public PexReflector pexReflector;
    public boolean groupManager = false;
    public JavaPlugin gmInstance;
    public GMReflector gmReflector;

    public PermeExecutor permeCommandExecutor;
    public VanillaReflector vanillaReflector;
    public ArrayList<VanillaTask> tasks = new ArrayList<VanillaTask>();
    public ArrayList<String> taskLogs = new ArrayList<String>();

    @Override
    public void onEnable() {
        config = new ConfigManager(this);
        config.onEnable();

        permissionsEx = getServer().getPluginManager().getPlugin("PermissionsEx") != null;
        groupManager = getServer().getPluginManager().getPlugin("GroupManager") != null;
        vanillaReflector = new VanillaReflector(this);

        if(permissionsEx) {
            pexInstance = (JavaPlugin) getServer().getPluginManager().getPlugin("PermissionsEx");
            pexReflector = new PexReflector(this);
        } else if(groupManager) {
            gmInstance = (JavaPlugin) getServer().getPluginManager().getPlugin("GroupManager");
            gmReflector = new GMReflector(this);
        }

        this.getCommand("perme").setExecutor(permeCommandExecutor = new PermeExecutor(this));
    }

    @Override
    public void onDisable() {
        config.onDisable();
    }

}
