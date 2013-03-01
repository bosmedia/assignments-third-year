/*****
 * CT326 - Assignment 04 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg.load.program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*****
 * - Create a separate class to read in that file, line by line, and output it 
 * to the console with the line number. The program should create a FileReader 
 * object and pass this in the constructor of a LineNumberReader object to handle 
 * the file reading required.
 */
public class Loadprogam 
{
    private static FileReader inFile = null;
    
    public static void main(String[] args) 
    {
        System.out.println("The details stored on file are:\n");
        
        try {
            inFile = new FileReader("studentData");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Loadprogam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /***** ASSIGNMENT INSTRUCTION
        * - The program should create a FileReader object and pass this in the
        * constructor of a LineNumberReader object to handle the file reading required
        */ 
        LineNumberReader in = new LineNumberReader(inFile);
        
        String line;
        try {
            while((line = in.readLine()) != null)
            {
                /***** ASSIGNMENT INSTRUCTION
                * - read in that file, line by line, and output it to the console
                * with the line number.
                */ 
                System.out.println(in.getLineNumber() + " " +  line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Loadprogam.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Loadprogam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            inFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Loadprogam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
