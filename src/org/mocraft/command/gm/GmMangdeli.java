package org.mocraft.command.gm;

public class GmMangdeli extends GmMangaddi implements GmCommand {

    public GmMangdeli() {}

    public GmMangdeli(String groupA, String groupB) {
        this.groupA = groupA;
        this.groupB = groupB;
    }

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMangdeli init(String[] args) {
        this.groupA = args[1];
        this.groupB = args[2];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mangdeli " + groupA + " " + groupB;
    }

    @Override
    public GmCommand reflect() {
        return new GmMangaddi(groupA, groupB);
    }

}
