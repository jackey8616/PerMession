package org.mocraft.command.gm;

public interface GmCommand {

    boolean reflectable();

    GmCommand init(String[] args);

    String toStringCommand();

    String label();

    GmCommand reflect();

}
