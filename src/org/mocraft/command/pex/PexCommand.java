package org.mocraft.command.pex;

public interface PexCommand {

    boolean reflectable();

    PexCommand init(String[] args);

    String toStringCommand();

    String label();

    PexCommand reflect();


}
