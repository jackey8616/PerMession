package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;

public class CommandTask implements Runnable {

    protected int id;
    protected PerMession instance;
    protected CommandSender sender;
    protected Player target;
    protected ZonedDateTime startTime, endTime;
    protected String command;

    public CommandTask(PerMession instance, CommandSender sender, Player target, int period, String args) {
        this.instance = instance;
        this.sender = sender;
        this.target = target;
        this.startTime = ZonedDateTime.now();
        this.endTime = startTime.plusSeconds(period / 20);
        this.command = args;
    }

    @Override
    public void run() {  }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

}
