package org.mocraft.command.gm;

public class GmMantogglevalidate implements GmCommand {

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMantogglevalidate init(String[] args) {
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mantogglevalidate";
    }

    @Override
    public String label() {
        return "mantogglevalidate";
    }

    @Override
    public GmCommand reflect() {
        return new GmMantogglevalidate();
    }
}
