package org.mocraft.config;

import org.mocraft.PerMession;

public class ConfigManager {

    private PerMession instance;
    private TaskConfig taskConfig;

    public ConfigManager(PerMession instance) {
        this.instance = instance;
        this.taskConfig = new TaskConfig(instance, "task.yml", "task.yml");
    }

    public void onEnable() {
        taskConfig.reload();
        taskConfig.loadVariable();
    }

    public void onReload() {
        taskConfig.reload();
        onEnable();
    }

    public void onDisable() {
        taskConfig.saveVariable();
        taskConfig.save();
    }

}
