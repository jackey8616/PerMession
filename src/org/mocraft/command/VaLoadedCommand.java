package org.mocraft.command;

public class VaLoadedCommand implements Command {

    protected String command, reflect;

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public Command init(String[] args) {
        return null;
    }

    @Override
    public String toStringCommand() {
        return null;
    }

    @Override
    public String label() {
        return null;
    }

    public String reflect() {
        return null;
    }
}
