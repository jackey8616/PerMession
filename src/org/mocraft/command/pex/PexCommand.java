package org.mocraft.command.pex;

import org.mocraft.command.Command;

public interface PexCommand extends Command {

    @Override
    PexCommand init(String[] args);

    PexCommand reflect();

}
