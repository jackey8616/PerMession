package org.mocraft.config;

import org.mocraft.PerMession;

public class ReflectConfig extends PluginYaml {

    private PerMession instance;

    public ReflectConfig(PerMession instance, String fileName, String defaults) {
        super(instance, fileName, defaults);
        this.instance = instance;
    }

    public void loadVariable() {
        getConfigurationSection("ReflectedVanillaCommands").getValues(false);
    }

    public void saveVariable() {

    }
}
