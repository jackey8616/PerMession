package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class VanillaTask implements Runnable, Task {

    protected int id;
    protected PerMession instance;
    protected CommandSender sender;
    protected int reflect;
    protected int period;
    protected ZonedDateTime startTime, endTime;
    protected String command;

    public VanillaTask(PerMession instance, CommandSender sender, int reflect, int period, String args) {
        this.instance = instance;
        this.sender = sender;
        this.startTime = ZonedDateTime.now();
        this.reflect = reflect;
        this.period = period;
        this.endTime = startTime.plusSeconds(period);
        this.command = args;
        if(reflect != 0)
            instance.getServer().dispatchCommand(sender, args);
    }

    public String commandReplace(int reflect, String cmd) {
        if(reflect == 0) {
            return cmd;
        } else if(reflect == 1)  {
            return instance.vanillaReflector.reflect(cmd);
        }
        return null;
    }

    @Override
    public void run() {
        if(ZonedDateTime.now().isAfter(endTime) || ZonedDateTime.now().isEqual(endTime)) {
            instance.getServer().getScheduler().cancelTask(id);
            instance.getServer().dispatchCommand(sender, commandReplace(reflect, command));
            instance.tasks.remove(this);
        }
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getStartTimeString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(startTime);
    }

    public String getCommand() {
        return this.command;
    }

    public String getReflectCommand() {
        return (instance.vanillaReflector.reflect(command) != null ? instance.vanillaReflector.reflect(command) : "(None)");
    }

    public String toString() { return this.toString(); }

}