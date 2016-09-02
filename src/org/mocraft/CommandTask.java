package org.mocraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Clode on 2016/8/29.
 */
public class CommandTask implements Runnable {

    private int id;
    private Player player;
    private String command = "";
    private int time;

    public CommandTask(Player player, String time, String[] args) {
        this.player = player;
        this.time = Integer.valueOf(time) * 60 * 20;
        for(int i = 1; i < args.length; ++i) this.command += args[i] + " ";
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        System.out.println(command);
    }

    @Override
    public void run() {
        if(time == 0) {
            Bukkit.getScheduler().cancelTask(id);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("add", "del"));
        } else {
            time--;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
