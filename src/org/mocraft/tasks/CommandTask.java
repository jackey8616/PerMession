package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;

public class CommandTask implements Runnable {

    protected int id;
    protected PerMession instance;
    protected CommandSender sender;
    protected int reflect;
    protected int period;
    protected ZonedDateTime startTime, endTime;
    protected String command;

    public CommandTask(PerMession instance, CommandSender sender, int reflect, int period, String args) {
        this.instance = instance;
        this.sender = sender;
        this.startTime = ZonedDateTime.now();
        this.reflect = reflect;
        this.period = period;
        this.endTime = startTime.plusSeconds(period);
        this.command = args;
    }

    @Override
    public void run() {  }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

}
