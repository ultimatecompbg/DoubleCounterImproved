package org.ultimatecompbg;

public class IsDone {
    public static volatile boolean isDone = false;
    public static boolean getDone(){
        return isDone;
    }
    public static void setDone(){
        isDone = true;
    }
}
