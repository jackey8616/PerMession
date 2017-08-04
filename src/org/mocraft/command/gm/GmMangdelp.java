package org.mocraft.command.gm;

public class GmMangdelp extends GmMangaddp implements GmCommand {

    public GmMangdelp() {}

    public GmMangdelp(String group, String[] permissions) {
        this.group = group;
        for(String per : permissions) {
            this.permissions.add(per);
        }
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangdelp init(String[] args) {
        this.group = args[1];
        for(int i = 2; i < args.length; ++i)
            this.permissions.add(args[i]);
        return this;
    }

    @Override
    public String toStringCommand() {
        String cmd = "mangdelp " + group + " ";
        for(String per : permissions)
            cmd += per + " ";
        return cmd.trim();
    }

    @Override
    public GmCommand reflect() {
        return new GmMangaddp(group, permissions.toArray(new String[permissions.size()]));
    }

}
