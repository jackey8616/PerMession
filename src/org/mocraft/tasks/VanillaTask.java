package org.mocraft.tasks;

import org.bukkit.command.CommandSender;
import org.mocraft.PerMession;

import java.time.ZoneId;
import java.time.ZoneOffset;
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
    protected boolean executed;

    public VanillaTask(PerMession instance, CommandSender sender, boolean reflect, int delay, int period, String args) {
        this(instance, sender, null, reflect, delay, period, null, null, args,false);
    }

    public VanillaTask(PerMession instance, CommandSender sender, String assignTime, boolean reflect, int delay, int period, String startTime, String endTime, String args, boolean Executed) {
        this.instance = instance;
        this.sender = sender;
        this.assignTime = assignTime != null ? ZonedDateTime.parse(assignTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())) : ZonedDateTime.now();
        this.reflect = reflect;
        this.delay = delay;
        this.period = period;
        this.startTime = startTime != null ? ZonedDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())) : this.assignTime.plusSeconds(delay);
        this.endTime = endTime != null ? ZonedDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())) : this.startTime.plusSeconds(period);
        this.command = args;
        this.executed = executed;
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
        if(reflect && !executed) {
            executed = instance.getServer().dispatchCommand(sender, command);
        } else if(ZonedDateTime.now().isAfter(endTime) || ZonedDateTime.now().isEqual(endTime)) {
            instance.getServer().dispatchCommand(sender, commandReplace(reflect, command));
            instance.getServer().getScheduler().cancelTask(id);
            instance.taskLogs.add(String.format("| %s | %s | %s | %s | %s |", getAssignTimeString(), getStartTimeString(), getEndTimeString(), getCommand(), getReflectCommand()));
            instance.tasks.remove(this);
        }
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    public boolean getReflect() { return this.reflect; }

    public void setReflect(boolean reflect) { this.reflect = reflect; }

    public int getDelay() { return this.delay; }

    public int getPeriod() { return this.period; }

    public boolean getExecuted() { return this.executed; }

    public ZonedDateTime getAssignTime() { return assignTime; }

    public String getAssignTimeString() { return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(assignTime); }

    public ZonedDateTime getStartTime() { return startTime; }

    public String getStartTimeString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(startTime);
    }

    public ZonedDateTime getEndTime() { return endTime; }

    public String getEndTimeString() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endTime);
    }

    public String getCommand() {
        return this.command;
    }

    public void setCommand(String command) {  }

    public String getReflectCommand() { return (instance.vanillaReflector.reflect(command) != null ? instance.vanillaReflector.reflect(command) : "(None)"); }

    public String toString() { return this.toString(); }

}
