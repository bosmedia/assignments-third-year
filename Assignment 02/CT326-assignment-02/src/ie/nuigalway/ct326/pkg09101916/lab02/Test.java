/***** 
 * CT326 - Assignment 02 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab02;

// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Test {

    static DecimalFormat precision2 = new DecimalFormat("0.00");
    // test Employee hierarchy
    public static void main(String args[]) 
    {
        String output = "";
  
        Boss boss = new Boss("John", "Smith", 800.0);
/***** ASSIGNMENT INSTRUCTION
 * - Test this by changing the Test class so that two of the employees will have negative earnings.
 */  
        CommissionWorker commissionWorker =
                new CommissionWorker(
                "Sue", "Jones", -400.0, -3.0, 150);

        PieceWorker pieceWorker =
                new PieceWorker("Bob", "Lewis", 2.5, 200);
/***** ASSIGNMENT INSTRUCTION
 * - Test this by changing the Test class so that two of the employees will have negative earnings.
 */  
        HourlyWorker hourlyWorker =
                new HourlyWorker("Karen", "Price", -13.75, 40);     
                
        output += handleEmployee(boss);
        output += handleEmployee(commissionWorker);
        output += handleEmployee(pieceWorker);
        output += handleEmployee(hourlyWorker);

        JOptionPane.showMessageDialog(null, output,
                "CT326 - Assignment 02",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }

/***** ASSIGNMENT INSTRUCTION
 * - Modify the Test class to be able to handle exceptions. When an exception is encountered 
 * calculating an employee's earnings, the Test class should print out the error message and 
 * continue as normal with the next employees.
 */     
    public static String handleEmployee(Employee handleThisEmployee)
    {   
        String forDisplay ="";

        try {
            forDisplay += 
                    handleThisEmployee.toString() + " earned $"
                    + precision2.format(handleThisEmployee.earnings()) + "\n";
        } catch (Exception ex) {
            forDisplay +="\nEmployee "+handleThisEmployee.toString()+" cannot earn less than zero\n\n";
        }          
        return forDisplay; 
    }    
}
