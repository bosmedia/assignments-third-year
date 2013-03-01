/*****
 * CT326 - Assignment 11 - c.loughnane1@nuigalway.ie - 09101916
 */
package ct326.assignment.pkg11;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
/***** ASSIGNMENT INSTRUCTION
 * Create server and client programs that allows files to be uploaded and downloaded to the server.
 */
public class FileClient {

    private static Socket sock;
    private static String fileName;
    private static BufferedReader stdin;
    private static StringTokenizer userInput;
    private static FileOutputStream fileWriter;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    public static void main(String[] args) throws IOException {
        try {
            sock = new Socket("localhost", 4444);
            stdin = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.err.println("Cannot connect to the server, try again later.");
            System.exit(1);
        }

        oos = new ObjectOutputStream(sock.getOutputStream());

        String selectedAction = selectAction();
        userInput = new StringTokenizer(selectedAction);

        try {
            switch (messageType.valueOf(userInput.nextElement().toString())) {
                case put:
                    oos.writeUTF(selectedAction);
                    oos.flush();
                    sendFile(userInput.nextElement().toString());
                    break;
                case get:
                    System.out.println("entered " + selectedAction);
                    oos.writeUTF(selectedAction);
                    oos.flush();
                    receiveFile(userInput.nextElement().toString());
                    break;

            }
            oos.close();
        } catch (Exception e) {
            System.err.println("not valid input");
        }
        sock.close();
    }

    public static String selectAction() throws IOException {
        System.out.println("COMMANDS: get *filename*");
        System.out.println("\t  put *filename*");
        System.out.println("\t  example: put data.txt");
        System.out.print("ftp> ");

        return stdin.readLine();
    }
    /***** ASSIGNMENT INSTRUCTION
     * The server should be multi-threaded, and have one thread per connection. 
     * The client should be able to specify whether to upload or download a file
     */
    public static void sendFile(String fileName) {
        try {
            File fileToSend1 = new File("");
            String dir = fileToSend1.getAbsolutePath();
            File fileToSend = new File(dir + "/" + fileName);
            System.out.println("Client trying to send file: " + dir + "/" + fileName);

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

            System.out.println("File " + fileName + " sent to Server.");
        } catch (IOException ex) {
            System.err.println("CLIENT send file error: " + ex.getMessage());
        }

    }
    /***** ASSIGNMENT INSTRUCTION
     * The server should be multi-threaded, and have one thread per connection. 
     * The client should be able to specify whether to upload or download a file
     */
    public static void receiveFile(String fileName) {
        try {

            ois = new ObjectInputStream(sock.getInputStream());

            String fileToReceive = ois.readUTF();

            long length = ois.readLong();

            fileWriter = new FileOutputStream(("received_from_server_" + fileToReceive));
            byte[] buffer = new byte[8192];
            int bytesRead;

            while (length > 0 && (bytesRead = ois.read(buffer, 0, (int) Math.min(buffer.length, length))) != -1) {
                fileWriter.write(buffer, 0, bytesRead);
                length -= bytesRead;
            }

            System.out.println("File " + fileName + " received from Server.");
        } catch (IOException ex) {
            System.err.println("Server reports problem with your command. Re-check filename.");
        } finally {
            try {
                fileWriter.close();
                ois.close();
            } catch (IOException ex) {
                System.err.println("Server unable to close stream.");
            }
        }
    }

    public enum messageType 
    {
        get, put;
    }
}
