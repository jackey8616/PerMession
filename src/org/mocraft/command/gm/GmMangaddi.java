package org.mocraft.command.gm;

public class GmMangaddi implements GmCommand {

    protected String groupA, groupB;

    public GmMangaddi() {}

    public GmMangaddi(String groupA, String groupB) {
        this.groupA = groupA;
        this.groupB = groupB;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangaddi init(String[] args) {
        this.groupA = args[1];
        this.groupB = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mangaddi " + groupA + " " + groupB;
    }

    @Override
    public String label() {
        return "mangaddi";
    }

    @Override
    public GmCommand reflect() {
        return new GmMangdeli(groupA, groupB);
    }

}
