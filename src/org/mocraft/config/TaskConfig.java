package org.mocraft.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemoryConfiguration;
import org.mocraft.PerMession;
import org.mocraft.command.executor.argument.PmDurationArgs;
import org.mocraft.tasks.VanillaTask;

public class TaskConfig extends PluginYaml {

    private PerMession instance;

    public TaskConfig(PerMession instance, String fileName, String defaults) {
        super(instance, fileName, defaults);
        this.instance = instance;
    }

    public void loadVariable() {
        System.out.println("Loading....");
        instance.tasks.clear();
        for(String key : getConfigurationSection("Tasks").getKeys(false)) {
            ConfigurationSection innerSection = getConfigurationSection("Tasks." + key);
            VanillaTask task = new VanillaTask(
                                    instance,
                                    Bukkit.getConsoleSender(),
                                    innerSection.getString("AssignTime"),
                                    innerSection.getBoolean("Reflect"),
                                    innerSection.getInt("Delay"),
                                    innerSection.getInt("Period"),
                                    innerSection.getString("StartTime"),
                                    innerSection.getString("EndTime"),
                                    innerSection.getString("Command"),
                                    innerSection.getBoolean("Executed"));
            new PmDurationArgs().arrangeTask(instance, task);
        }
        set("Tasks", new MemoryConfiguration());
    }

    public void saveVariable() {
        System.out.println("Saving....");
        for(VanillaTask task : instance.tasks) {
            ConfigurationSection innerSection = new MemoryConfiguration();
            innerSection.set("Reflect", task.getReflect());
            innerSection.set("Delay", task.getDelay());
            innerSection.set("Period", task.getPeriod());
            innerSection.set("Command", task.getCommand());
            innerSection.set("Executed", task.getExecuted());
            innerSection.set("AssignTime", task.getAssignTimeString());
            innerSection.set("StartTime", task.getStartTimeString());
            innerSection.set("EndTime", task.getEndTimeString());
            set("Tasks." + task.getId(), innerSection);
        }
    }

}
