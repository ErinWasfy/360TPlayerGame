package com.demo.msgtransport.playerscope;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String playerName;
    private AtomicInteger msgCount;
    private String msg;

    public Player(String playerName, AtomicInteger msgCount, String msg) {
        this.playerName = playerName;
        this.msgCount = msgCount;
        this.msg = msg;
    }
    public String getPlayerName() {
        return playerName;
    }

    public AtomicInteger getMsgCount() {
        return msgCount;
    }

    public String getMessage() {
        return msg;
    }
    public void setMessage(String message) {
        this.msg = message;
    }

    public void increaseMsgCount() {
        this.msgCount.incrementAndGet();
    }
    public void getResponseFor(Player sender) {
        String m = sender.getMessage() + " " + this.getMsgCount();
        increaseMsgCount();
        this.setMessage(m);
    }
}
