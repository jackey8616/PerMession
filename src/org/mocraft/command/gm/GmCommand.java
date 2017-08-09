package org.mocraft.command.gm;

import org.mocraft.command.Command;

public interface GmCommand extends Command {

    @Override
    GmCommand init(String[] args);

    GmCommand reflect();

}
