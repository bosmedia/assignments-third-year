/*****
 * CT326 - Assignment 11 - c.loughnane1@nuigalway.ie - 09101916
 */
package ct326.assignment.pkg11;

import java.io.*;
import java.net.*;
/***** ASSIGNMENT INSTRUCTION
 * Create server and client programs that allows files to be uploaded and downloaded to the server.
 */
public class FileServer {

    private static ServerSocket serverSocket;
    private static Socket clientSocket = null;
    private static int clientID = 1;

    public static void main(String[] args) throws IOException {

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started.");
        } catch (Exception e) {
            System.err.println("Port already in use.");
            System.exit(1);
        }
        /***** ASSIGNMENT INSTRUCTION
         * The server should be multi-threaded, and have one thread per connection. 
         */
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket+" for client "+clientID);

                Thread t = new Thread(new CLIENTConnection(clientSocket, clientID++));

                t.start();

            } catch (Exception e) {
                System.err.println("Error in connection attempt.");
            }
        }
    }
}
