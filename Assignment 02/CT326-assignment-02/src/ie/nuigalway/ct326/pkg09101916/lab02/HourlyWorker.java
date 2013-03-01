package ie.nuigalway.ct326.pkg09101916.lab02;

// Definition of class HourlyWorker

public final class HourlyWorker extends Employee {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,
            double wagePerHour, double hoursWorked) {
        super(first, last); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setWage(double wagePerHour) {
        wage = wagePerHour;
    }

    // Set the hours worked
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setHours(double hoursWorked) {
        hours = hoursWorked;
    }

    // Get the HourlyWorker's pay
/***** ASSIGNMENT INSTRUCTION
 * - Change the Earnings() method in Employee and all sub-classes to throw a generic Exception 
 * if the total earnings would be less than zero. The exception should have a message with the 
 * employee's name and the error encountered.
 */ 
    @Override
    public double earnings() throws Exception {
        if((wage*hours)<0)
            throw new Exception();
        return wage * hours;
    }

    @Override
    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
