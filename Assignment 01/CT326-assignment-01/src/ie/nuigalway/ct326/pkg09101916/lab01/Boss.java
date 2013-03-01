/***** 
 * CT326 - Assignment 01 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab01;

// Boss class derived from Employee.
import org.joda.time.DateTime;

public final class Boss extends Employee {

    private double weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary, DateTime joinDate) {
        super(first, last, joinDate); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = (salary > 0 ? salary : 0);
    }

    // get Boss's pay
    @Override
    public double earnings() {
        return weeklySalary;
    }

    // get String representation of Boss's name
    @Override
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
