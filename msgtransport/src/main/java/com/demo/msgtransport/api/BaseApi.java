package com.demo.msgtransport.api;

import com.demo.msgtransport.playerscope.Player;
import com.demo.msgtransport.playerscope.PlayerBuilder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class BaseApi {

    Socket socket = null;
    Player player = null;
    Player sender = null;

    protected void exitApplication() throws IOException {
        System.out.println("Finalizing the game, thank you for playing...");
        System.exit(0);
    }

    /**
     * Common print method.
     * Instead of writing System.out.println everywhere, this is a simplified solution
     *
     * @param s
     */
    protected void print(String s) {
        System.out.println(s);
    }

     abstract void chat(Player player, ObjectInputStream is, ObjectOutputStream os) throws IOException, ClassNotFoundException;
}
