package org.mocraft.command;

public interface Command {

    boolean reflectable();

    Command init(String[] args);

    String toStringCommand();

    String label();

}
