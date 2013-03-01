/***** 
 * CT326 - Assignment 01 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab01;

// Java core packages
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class Test 
{
    static DecimalFormat precision2 = new DecimalFormat("0.00");
    
    public static void main(String args[]) 
    {
        
/***** ASSIGNMENT INSTRUCTION
 * – Assume the payroll is processed once per month. Create an array of Employee 
 * variables to store references to the various employee objects.
 */
        Employee[] employees = new Employee[4];

        //DateTime constructor for this library year, month, day, hour, minute
        employees[0] = new Boss("John", "Smith", 800.0, new DateTime(2002, 9, 21, 0, 0));

        employees[1] = new CommissionWorker(
                "Sue", "Jones", new DateTime(2005, 12, 22, 0, 0), 400.0, 3.0, 150);

        employees[2] = new PieceWorker(
                "Bob", "Lewis", new DateTime(1998, 2, 3, 0, 0), 2.5, 200);

        employees[3] = new HourlyWorker(
                "Karen", "Price", new DateTime(2008, 10, 1, 0, 0), 13.75, 40);
        
        StringBuilder forDisplay = new StringBuilder();
        
/***** ASSIGNMENT INSTRUCTION
 * – In a loop, calculate the payroll for each Employee, and add a €100.00 bonus to
 * the person’s payroll if they joined the company over 10 years ago.
 * NB: Bonus decided using day, month, year. Real world would often count only month and year.
 */                
        for (int i=0;i<employees.length;i++)
        {
            forDisplay.append(handleEmployee(employees[i]));
        }
        
        JOptionPane.showMessageDialog(null, forDisplay, "CT326 - Assignment 01", 
                JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
    
    public static boolean checkBonus(DateTime employeeJoinDate)
    {
        DateTime now = new DateTime();
        Period period = new Period(employeeJoinDate, now);
        if (period.getYears()>=10)
            return true;
        return false;
    }

    public static StringBuilder handleEmployee(Employee handleThisEmployee)
    {   
        StringBuilder forDisplay = new StringBuilder();
        
        forDisplay.append(handleThisEmployee.toString()).append("\n");
        forDisplay.append("Base wage: €").append(precision2.format(handleThisEmployee.earnings()));
        
/***** ASSIGNMENT INSTRUCTION
 * – add a €100.00 bonus to the person’s payroll if they joined the company over 10 years ago.
 */ 
        //pass employee join date to the method checkBonus(Datetime employeeJoinDate)
        if(checkBonus(handleThisEmployee.getJoinDate()))
        {
            forDisplay.append("\n10 year Loyalty bonus €100.00\nTotal for month: €")
                    .append(precision2.format( (4 * handleThisEmployee.earnings())+100)).append("\n\n");
        }
        else
        {
            forDisplay.append("\n10 year Loyalty bonus €0.00\nTotal for month: €")
                    .append(precision2.format((4 * handleThisEmployee.earnings()))).append("\n\n");
        }
        return forDisplay;
    }
} // end class Test
