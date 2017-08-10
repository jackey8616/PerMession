package org.mocraft.command.pex;

public class PexOutterDemote extends PexOutterPromote {

    public PexOutterDemote() {}

    public PexOutterDemote(String target) {
        this.target = target;
    }

    @Override
    public PexOutterDemote init(String[] args) {
        this.target = args[1];
        return this;
    }

    @Override
    public String toStringCommand() {
        return "demote " + target;
    }

    @Override
    public String label() {
        return "demote";
    }

    @Override
    public PexCommand reflect() {
        return new PexOutterPromote(target);
    }
}
