package org.mocraft.command.gm;

public class GmMangdel extends GmMangadd implements GmCommand {

    public GmMangdel() {}

    public GmMangdel(String group) {
        this.group = group;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangdel init(String[] args) {
        this.group = args[1];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mangdel " + group;
    }

    @Override
    public GmCommand reflect() {
        return new GmMangadd(group);
    }

}
