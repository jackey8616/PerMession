package org.mocraft.command.gm;

import java.util.ArrayList;

public class GmMangaddp implements GmCommand {

    protected String group;
    protected ArrayList<String> permissions = new ArrayList<String>();

    public GmMangaddp() {}

    public GmMangaddp(String group, String[] permissions) {
        this.group = group;
        for(String per : permissions)
            this.permissions.add(per);
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangaddp init(String[] args) {
        this.group = args[1];
        for(int i = 2; i < args.length; ++i)
            this.permissions.add(args[i]);
        return this;
    }

    @Override
    public String toStringCommand() {
        String cmd = "mangaddp " + group + " ";
        for(String per : permissions)
            cmd += per + " ";
        return cmd.trim();
    }

    @Override
    public String label() {
        return "mangaddp";
    }

    @Override
    public GmCommand reflect() {
        return new GmMangdelp(group, permissions.toArray(new String[permissions.size()]));
    }
}
