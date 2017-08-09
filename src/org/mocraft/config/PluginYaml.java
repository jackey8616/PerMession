package org.mocraft.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.mocraft.PerMession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PluginYaml extends YamlConfiguration {

    private PerMession instance;
    private File file;
    private String defaults;

    public PluginYaml(PerMession instance, String fileName, String defaults) {
        this.instance = instance;
        this.file = new File(instance.getDataFolder(), fileName);
        this.defaults = defaults;
    }

    public void reload() {
        try {
            if(!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                if(defaults != null) {
                    InputStream fis = getClass().getResourceAsStream("/" + defaults);
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] buff = new byte[1024];
                    int i = 0;
                    while ((i = fis.read(buff)) != -1)
                        fos.write(buff, 0, i);

                    if (fis != null) fis.close();
                    if (fos != null) fos.close();
                }
            }
            load(file);
        } catch (IOException e) {
            e.printStackTrace();
            instance.getLogger().severe("Error while loading file " + file.getName());
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
            instance.getLogger().severe("Error while loading file" + file.getName());
        }
    }

    public void save() {
        try {
            options().indent(2);
            save(file);
        } catch (IOException e) {
            e.printStackTrace();
            instance.getLogger().severe("Error while saving file " + file.getName());
        }
    }

}
