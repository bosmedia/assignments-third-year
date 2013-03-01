/***** 
 * CT326 - Assignment 02 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab02;

// Boss class derived from Employee.

public final class Boss extends Employee {

    private double weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary) {
        super(first, last); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setWeeklySalary(double salary) {
        weeklySalary = salary;
    }

    // get Boss's pay
/***** ASSIGNMENT INSTRUCTION
 * - Change the Earnings() method in Employee and all sub-classes to throw a generic Exception 
 * if the total earnings would be less than zero. The exception should have a message with the 
 * employee's name and the error encountered.
 */     
    @Override
    public double earnings() throws Exception {
        
        if(weeklySalary<0)
            throw new Exception();
        return weeklySalary;
    }

    // get String representation of Boss's name
    @Override
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
