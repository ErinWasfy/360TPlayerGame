package com.demo.msgtransport.playerscope;

import com.demo.msgtransport.util.Constants;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PlayerBuilderTest {

    @BeforeEach
    void setUp() {
    }
    static Player serverPlayer = null;
    static Player clientPlayer = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        serverPlayer = new PlayerBuilder().setName(Constants.player2).initializeMessage().getPlayer();
        clientPlayer = new PlayerBuilder().setName(Constants.player1).getPlayer();
    }

    @org.junit.Test

    public void testPlayers() {
        assertEquals(Constants.player1, clientPlayer.getPlayerName());
        assertEquals(Constants.player2, serverPlayer.getPlayerName());
    }

    @org.junit.Test
    public void testMessageIncrease() {
        int serverPlayerMsgCount = serverPlayer.getMsgCount().intValue();
        int clientPlayerMsgCount = clientPlayer.getMsgCount().intValue();

        serverPlayer.increaseMsgCount();
        clientPlayer.increaseMsgCount();

        assertEquals(++serverPlayerMsgCount, serverPlayer.getMsgCount().intValue());
        assertEquals(++clientPlayerMsgCount, clientPlayer.getMsgCount().intValue());
    }

    @org.junit.Test
    public void testPlayerMessage() {
        clientPlayer.getResponseFor(serverPlayer);
        serverPlayer.getResponseFor(clientPlayer);

        assertEquals("Hello" + " 1", clientPlayer.getMessage());
        assertEquals("Hello" + " 1 1", serverPlayer.getMessage());
    }
}