/***** 
 * CT326 - Assignment 01 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab01;

// Definition of class HourlyWorker
import org.joda.time.DateTime;

public final class HourlyWorker extends Employee {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last, DateTime joinDate,
            double wagePerHour, double hoursWorked) {
        super(first, last, joinDate); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour) {
        wage = (wagePerHour > 0 ? wagePerHour : 0);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay
    @Override
    public double earnings() {
        return wage * hours;
    }

    @Override
    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
