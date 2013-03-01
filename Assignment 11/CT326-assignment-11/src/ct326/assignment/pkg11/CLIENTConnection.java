/*****
 * CT326 - Assignment 11 - c.loughnane1@nuigalway.ie - 09101916
 */
package ct326.assignment.pkg11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class CLIENTConnection implements Runnable {

    private Socket clientSocket;
    private int clientID;
    private StringTokenizer userInput;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private FileOutputStream fileWriter;

    public CLIENTConnection(Socket client, int clientID) {
        this.clientSocket = client;
        this.clientID = clientID;
    }

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(clientSocket.getInputStream());
            String clientSelection;
            boolean WAIT = true;
            while (WAIT) {
                clientSelection = ois.readUTF();

                System.out.println("FROM CLIENT: " + clientSelection);

                userInput = new StringTokenizer(clientSelection);

                switch (messageType.valueOf(userInput.nextElement().toString())) {
                    case put:
                        receiveFile();
                        break;
                    case get:
                        sendFile(userInput.nextElement().toString());
                        break;
                    default:
                        System.out.println("Incorrect command received.");
                        break;
                }
                WAIT = false;
                break;
            }
        } catch (IOException ex) {
            System.err.println("Client has bugged out.");
        }
        try {
            clientSocket.close();
        } catch (IOException ex) {
            System.err.println("Server unable to close scoket for Client "+clientID);
        }
    }

    public void receiveFile() {
        try {
            String fileToReceive = ois.readUTF();

            long length = ois.readLong();

            fileWriter = new FileOutputStream(("received_from_client_" + fileToReceive));
            byte[] buffer = new byte[8192];
            int bytesRead;

            while (length > 0 && (bytesRead = ois.read(buffer, 0, (int) Math.min(buffer.length, length))) != -1) {
                fileWriter.write(buffer, 0, bytesRead);
                length -= bytesRead;
            }

            System.out.println("File " + fileToReceive + " received from Client " + clientID);
        } catch (IOException ex) {
            System.err.println("ERROR Connection closed Client " + clientID);
        } finally {
            try {
                fileWriter.close();
                ois.close();
            } catch (IOException ex) {
            }
        }
    }

    public void sendFile(String fileName) {
        try {
            File fileToSend1 = new File("");
            String dir = fileToSend1.getAbsolutePath();
            File fileToSend = new File(dir + "\\" + fileName);
            System.out.println("Server trying to send file: " + dir + "\\" + fileName);

            oos = new ObjectOutputStream(clientSocket.getOutputStream());

            oos.writeUTF(fileToSend.getName());
            oos.flush();

            oos.writeLong(fileToSend.length());
            oos.flush();

            FileInputStream fileReader = new FileInputStream(fileToSend);

            byte[] buffer = new byte[8192];
            int length;

            while ((length = fileReader.read(buffer)) != -1) {
                oos.write(buffer, 0, length);
            }
            oos.flush();
            fileReader.close();

            System.out.println("File " + fileName + " sent to Client " + clientID + ".");
        } catch (Exception e) {
            System.err.println("File does not exist!");
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
        }
    }

    public enum messageType 
    {
        get, put;
    }
}
