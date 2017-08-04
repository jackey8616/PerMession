package org.mocraft.command.gm;

public class GmTempdel extends GmTempadd implements GmCommand {

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmTempdel init(String[] args) {
        return this;
    }

    @Override
    public String toStringCommand() {
        return "tempdel " + target.getDisplayName();
    }

    @Override
    public String label() { return "tempdel"; }

    @Override
    public GmCommand reflect() {
        return new GmTempadd();
    }

}
