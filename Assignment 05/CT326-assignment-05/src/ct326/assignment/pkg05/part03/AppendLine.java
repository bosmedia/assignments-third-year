/*****
 * CT326 - Assignment 05 - c.loughnane1@nuigalway.ie - 09101916
 *
 * part 3
 *
 */

package ct326.assignment.pkg05.part03;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*****
 * - Unrelated to the previous two parts, write a simple program that uses a 
 * RandomAccessFile object to open an ordinary text file and to then append an 
 * extra line of content onto the end of the file.
 */

public class AppendLine
{
    private static BufferedReader stdIn;
    private static String fileName;
    private static File inFile;
    private static long fileLength;
    private static RandomAccessFile rafIn;
    
    public static void main(String[] args)
    {
        /*****
         * I have included an example file "test.txt" for convenient checking of 
         * program.         * 
         */
        try {
            System.out.println("Please enter file name to append (Example file test.txt) :\n");
            
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            try {
                fileName = stdIn.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AppendLine.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            inFile = new File(fileName);
            
            fileLength = inFile.length();
            
            try {
                rafIn = new RandomAccessFile(inFile,"rw");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppendLine.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rafIn.seek(fileLength);
            } catch (IOException ex) {
                Logger.getLogger(AppendLine.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            rafIn.writeBytes("************* this is some appended text*************");
            
        } catch (IOException ex) {
            Logger.getLogger(AppendLine.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rafIn.close();
            } catch (IOException ex) {
                Logger.getLogger(AppendLine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }
}
