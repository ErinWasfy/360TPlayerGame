*Requirements of the Business case:
Having a Player class - an instance of this class with that can communicate with other Player(s) (other instances of this class)
The use case for this task is as bellow:
1. create 2 players
2. one of the players should send a message to second player (let's call this player "initiator")
3. when a player receives a message should send back a new message that contains the received message concatenated with the message counter that this player sent.
4. finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
5. both players should run in the same java process (strong requirement)
6. document for every class the responsibilities it has.
7. opposite to 5: have every player in a separate JAVA process (different PID).
Please use pure Java as much as possible (no additional frameworks like spring, etc.)
Please deliver one single maven project with the source code only (no jars). Please send the maven project as archive attached to e-mail (eventual links for download will be ignored due to security policy).
Please provide a shell script to start the program.
Everything what is not clearly specified is to be decided by developer. Everything what is specified is a hard requirement.
Please focus on design and not on technology, the technology should be the simplest possible that is achieving the target.
The focus of the exercise is to deliver the cleanest and clearest design that you can achieve (and the system has to be functional).
///////////////////////////////////////////////////////////////////////////////////////////
*********************************
//////////////////////////////////////////////////////
----------------Abstract Solutions-------------------------
-Classes Created in order as follows:
* API Class
------------------------------------------------------------
BaseApi : An abstract class for both client and server classes. Besides, it contains all the methods and objects needed
to be used in the other classes.
------------------------------------------------------------------------------------------------------
* Player Class
---------------------------------------------------------------------------------------------
Player: A Serializable class that includes name, messageCount, message variables.
------------------------------------------------------------------------------------------------------
* PlayerBuilder Class
---------------------------------------------------------------------------------------------
PlayerBuilder: A builder used to initialize a new player.
------------------------------------------------------------------------------------------
* Constants
------------------------------------------------------------------------------------
Constants: A class that includes contant values.
----------------------------------------------------------------------------------------
* MsgtransportApplication
---------------------------------------------------------------------------------------------
MsgtransportApplication: A launch point of the app that initializes both Server and Client instances.
------------------------------------------------------------------------------------------------------
* How to run an APP
------------------------------------------------------------------
Using this command below:  mvn package -Dmaven.test.skip=true
------------------------------------------------------------------------------------------
Run SH file(\run.sh) to start running two instances (client and server) of the app.
