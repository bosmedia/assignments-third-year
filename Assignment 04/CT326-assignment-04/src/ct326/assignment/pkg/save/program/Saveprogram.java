/*****
 * CT326 - Assignment 04 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg.save.program;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*****
 *  - Write a Java application that prompts the user to input their Name, Address, 
 * Date of Birth and Student ID number using the standard input - this information 
 * should then be saved to a file named studentData. The program should use the 
 * FileWriter class and an appropriate processing stream to handle the data output.
 */
public class Saveprogram 
{
    private static BufferedReader stdIn;
    private static String name;
    private static String address;
    private static String dob;
    private static String studentID;
    private static FileWriter outFile = null;
    
    public static void main(String[] args) 
    {
        /*****
         * - ask user to input details
         */
        System.out.println("Please enter your details in this order:\n");
        
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Your full name: ");
            name = stdIn.readLine();
            System.out.println("Your full address:");
            address = stdIn.readLine();
            System.out.println("Your date of birth:");
            dob = stdIn.readLine();
            System.out.println("Your student ID number: ");
            studentID = stdIn.readLine();           
        } catch (IOException ex) {
            Logger.getLogger(Saveprogram.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        /*****
         * - setup file handling objects
         */
        try {
            outFile = new FileWriter("studentData");
        } catch (IOException ex) {
            Logger.getLogger(Saveprogram.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*****
         * - write entered details to file
         */
        try (PrintWriter out = new PrintWriter(outFile)) 
        {
            out.println(name);
            out.println(address);
            out.println(dob);
            out.println(studentID);
            
            out.close();          
        }
        try {
            outFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Saveprogram.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
