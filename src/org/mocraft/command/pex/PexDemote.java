package org.mocraft.command.pex;

public class PexDemote extends PexPromote {

    public PexDemote() {}

    public PexDemote(String target, String ladder) {
        super(target, ladder);
    }

    @Override
    public PexDemote init(String[] args) {
        this.target = args[2];
        this.ladder = args.length > 3 ? args[3] : null;
        return this;
    }

    @Override
    public String toStringCommand() { return "pex demote " + target + (ladder != null ? " " + ladder : ""); }

    @Override
    public String label() {
        return "pex demote <user>";
    }

    @Override
    public PexCommand reflect() {
        return new PexPromote(target, ladder);
    }
}
