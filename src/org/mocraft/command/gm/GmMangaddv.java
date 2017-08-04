package org.mocraft.command.gm;

public class GmMangaddv implements GmCommand {

    protected String group, var, value;

    public void init(String group, String var, String value) {
        this.group = group;
        this.var = var;
        this.value = value;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangaddv init(String[] args) {
        this.group = args[1];
        this.var = args[2];
        this.value = args[3];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mangaddv " + group + " " + value + " " + value;
    }

    @Override
    public String label() {
        return "mangaddv";
    }

    @Override
    public GmCommand reflect() {
        return new GmMangdelv(group, var);
    }
}
