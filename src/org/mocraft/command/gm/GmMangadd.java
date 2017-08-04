package org.mocraft.command.gm;

public class GmMangadd implements GmCommand {

    protected String group;

    public GmMangadd() {}

    public GmMangadd(String group) {
        this.group = group;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangadd init(String[] args) {
        this.group = args[1];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mangadd " + group;
    }

    @Override
    public String label() {
        return "mangadd";
    }

    @Override
    public GmCommand reflect() {
        return new GmMangdel(group);
    }

    }
