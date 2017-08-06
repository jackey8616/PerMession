package org.mocraft.tasks;

public interface Task {

    String commandReplace(int reflect, String cmd);

    int getId();

    void setId(int id);

    String toString();

}
