package org.mocraft.tasks;

public interface Task {

    String commandReplace(boolean reflect, String cmd);

    int getId();

    void setId(int id);

    String toString();

}
