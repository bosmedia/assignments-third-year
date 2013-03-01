/***** 
 * CT326 - Assignment 01 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab01;

// Abstract base class Employee.
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public abstract class Employee {

    private String firstName;
    private String lastName;
    
/***** ASSIGNMENT INSTRUCTION
 * – Modify the supplied payroll system to include private instance variable joinDate
 * in class Employee to represent when they joined the company. Using Joda-time library.
 */
    private DateTime joinDate;
    
/***** ASSIGNMENT INSTRUCTION
 * – Use a static variable in the Employee class to help automatically assign each 
 * new employee a unique (incremental) id number.
 */
    private static int totalEmployee;
    private int employeeNumber;
    
    // constructor
    public Employee(String first, String last, DateTime joinDate) 
    {
        employeeNumber = ++totalEmployee;
        firstName = first;
        lastName = last;
        this.joinDate = joinDate;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    public DateTime getJoinDate() {
        return joinDate;
    }
    
    @Override
    //using DateTimeFormat.forPattern to return a more human friendly date format
    public String toString() {
        return firstName + " " + lastName + "\nEmployee No: " + employeeNumber + " - Joined: " 
                + joinDate.toString(DateTimeFormat.forPattern("dd/MM/yyyy"));
    }

    public abstract double earnings();
}
