package org.mocraft.command.gm;

public class GmMangdelv extends GmMangaddv implements  GmCommand {

    public GmMangdelv() {}

    public GmMangdelv(String group, String var) {
        this.group = group;
        this.var = var;
        this.value = null;
    }

    public void init(String group, String var, String value) {
        this.group = group;
        this.var = var;
        this.value = null;
    }

    @Override
    public boolean reflectable() {
        return false;
    }

    @Override
    public GmMangdelv init(String[] args) {
        this.group = args[1];
        this.var = args[2];
        this.value = args[3];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mangdelv " + group + " " + value;
    }

    @Override
    public String label() {
        return "mangdelv";
    }

    @Override
    public GmCommand reflect() {
        return null;
    }
}
