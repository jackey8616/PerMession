package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class VanillaTask implements Runnable, Task {

    protected int id;
    protected PerMession instance;
    protected CommandSender sender;
    protected boolean reflect;
    protected int delay;
    protected int period;
    protected ZonedDateTime assignTime, startTime, endTime;
    protected String command;
    protected boolean executed = false;

    public VanillaTask(PerMession instance, CommandSender sender, boolean reflect, int delay, int period, String args) {
        this.instance = instance;
        this.sender = sender;
        this.assignTime = ZonedDateTime.now();
        this.reflect = reflect;
        this.delay = delay;
        this.period = period;
        this.startTime = assignTime.plusSeconds(delay);
        this.endTime = startTime.plusSeconds(period);
        this.command = args;
    }

    public String commandReplace(boolean reflect, String cmd) {
        if(!reflect) {
            return cmd;
        } else {
            return instance.vanillaReflector.reflect(cmd);
        }
    }

    @Override
    public void run() {
        if(reflect && !executed)
            executed = instance.getServer().dispatchCommand(sender, command);
        else if(ZonedDateTime.now().isAfter(endTime) || ZonedDateTime.now().isEqual(endTime)) {
            instance.getServer().getScheduler().cancelTask(id);
            instance.getServer().dispatchCommand(sender, commandReplace(reflect, command));
            instance.tasks.remove(this);
        }
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public String getAssignTimeString() { return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(assignTime); }

    public String getStartTimeString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(startTime);
    }

    public String getEndTimeString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endTime);
    }

    public String getCommand() {
        return this.command;
    }

    public String getReflectCommand() { return (instance.vanillaReflector.reflect(command) != null ? instance.vanillaReflector.reflect(command) : "(None)"); }

    public String toString() { return this.toString(); }

}
