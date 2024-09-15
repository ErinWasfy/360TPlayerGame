package com.demo.msgtransport.api;

import com.demo.msgtransport.playerscope.Player;
import com.demo.msgtransport.playerscope.PlayerBuilder;
import com.demo.msgtransport.util.Constants;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class Client extends BaseApi {

    public Client() throws ConnectException {
        super();
        try (Socket socket = new Socket(Constants.hostname, Constants.port);
             ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream is = new ObjectInputStream(socket.getInputStream());){

             player = new PlayerBuilder().setName(Constants.player2).initializeMessage().getPlayer();

            print("Server found");
            print("Initializing Client");
            print("Client Connected!");

            player.getResponseFor(player);
            print("Sending From Client: " + player.getMessage());
            os.writeObject(player);

            chat(player, is, os);
        } catch (ConnectException e) {
            throw new ConnectException();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method listens inputStream. If there are any available inputs,
     * then it checks whether players reached the aimed messageCount or not.
     *
     *  If message count reached, application finalization starts.
     *
     *  If not, chat goes on.
     */
    @Override
    public void chat(Player player, ObjectInputStream is, ObjectOutputStream os) throws IOException, ClassNotFoundException {
        while ((sender = (Player) is.readObject()) != null) {
            if (sender.getMsgCount().intValue() == Constants.messageCount && player.getMsgCount().intValue() == Constants.messageCount) {
                super.exitApplication();
            }
            player.getResponseFor(sender);
            print("Sending From Client: " + player.getMessage());
            os.reset();
            os.writeObject(player);
        }
    }
}
