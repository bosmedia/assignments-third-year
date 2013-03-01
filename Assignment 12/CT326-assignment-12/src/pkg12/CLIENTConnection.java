/*****
 * CT326 - Assignment 12 - c.loughnane1@nuigalway.ie - 09101916
 */
package pkg12;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.loughnane1@nuigalway.ie - 09101916
 */
public class CLIENTConnection implements Runnable
{

    private int clientID;
    private DatagramSocket clientSocket;
    private DatagramPacket packet;
    private String userInput, filename, initString;

    public CLIENTConnection(DatagramSocket clientSocket, DatagramPacket packet, int clientID) throws IOException
    {
        this.clientSocket = clientSocket;
        this.packet = packet;
        this.clientID = clientID;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("THREAD: " + new String(packet.getData(), 0, packet.getLength()));

            initString = new String(packet.getData(), 0, packet.getLength());

            StringTokenizer t = new StringTokenizer(initString);

            userInput = t.nextToken();
            filename = t.nextToken();

            switch (messageType.valueOf(userInput))
            {
                case put:
                    //sends a message gets the new port information to the client
                    send(packet.getAddress(), packet.getPort(), ("OK").getBytes());

                    //create Object to handle incoming file
                    UDPFileReceiver fileReceiver = new UDPFileReceiver(clientSocket);
                    fileReceiver.receiveFile();
                    
                    break;
                case get:
                    File theFile = new File(filename);

                    send(packet.getAddress(), packet.getPort(), ("OK").getBytes());

                    //create object to handle out going file
                    UDPFileSender fileHandler = new UDPFileSender(clientSocket, packet);
                    fileHandler.sendFile(theFile);
                    break;
                default:
                    System.out.println("Incorrect command received.");
                    break;
            }
        } catch (IOException ex)
        {
            Logger.getLogger(CLIENTConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("*** Transfer for clientID " + clientID + " complete. ***");
    }

    private void send(InetAddress recv, int port, byte[] message) throws IOException
    {
        DatagramPacket packet = new DatagramPacket(message, message.length, recv, port);
        clientSocket.send(packet);
    }

    private void send(byte[] message) throws IOException
    {
        DatagramPacket packet = new DatagramPacket(message, message.length);
        clientSocket.send(packet);
    }

    public enum messageType
    {
        get, put;
    }
}
