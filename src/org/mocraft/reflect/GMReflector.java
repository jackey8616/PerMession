package org.mocraft.reflect;

import org.mocraft.PerMession;
import org.mocraft.command.gm.*;

import java.util.HashMap;
import java.util.Map;

public class GMReflector implements Reflector {

    public Map<String, GmCommand> reflectableMap = new HashMap<String, GmCommand>();

    public GMReflector(PerMession instance) {
        reflectableMap.put("manuadd", new GmManuadd());
        reflectableMap.put("manuaddsub", new GmManuaddsub());
        reflectableMap.put("manudelsub", new GmManudelsub());
        reflectableMap.put("mangadd", new GmMangadd());
        reflectableMap.put("mangdel", new GmMangdel());
        reflectableMap.put("manuaddp", new GmManuaddp());
        reflectableMap.put("manudelp", new GmManudelp());
        reflectableMap.put("mangaddp", new GmMangaddp());
        reflectableMap.put("mangdelp", new GmMangdelp());
        reflectableMap.put("mangaddi", new GmMangaddi());
        reflectableMap.put("mangdeli", new GmMangdeli());
        reflectableMap.put("manuaddv", new GmManuaddv());
        reflectableMap.put("mangaddv", new GmMangaddv());
        reflectableMap.put("tempadd", new GmTempadd());
        reflectableMap.put("tempdel", new GmTempdel());
        reflectableMap.put("manpromote", new GmManpromote());
        reflectableMap.put("mandemote", new GmMandemote());
        reflectableMap.put("mantogglevalidate", new GmMantogglevalidate());
        reflectableMap.put("mantogglesave", new GmMantogglesave());
    }

    @Override
    public String reflect(String command) {
        String[] cmd = command.split(" ");
        return reflect(cmd[0], cmd);
    }

    @Override
    public String reflect(String label, String[] args) {
        if (reflectableMap.containsKey(label)) {
            return reflectableMap.get(label).init(args).reflect().toStringCommand();
        } else {
            return null;
        }
    }



}
