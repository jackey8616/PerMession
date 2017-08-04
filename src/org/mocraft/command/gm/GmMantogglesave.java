package org.mocraft.command.gm;

public class GmMantogglesave implements GmCommand {

    @Override
    public boolean reflectable() {
        return true;
    }

    @Override
    public GmMantogglesave init(String[] args) {
        return this;
    }

    @Override
    public String toStringCommand() {
        return "mantogglesave";
    }

    @Override
    public String label() {
        return "mantogglesave";
    }

    @Override
    public GmCommand reflect() {
        return new GmMantogglesave();
    }
}
