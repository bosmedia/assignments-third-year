package ie.nuigalway.ct326.pkg09101916.lab02;

// CommissionWorker class derived from Employee

public final class CommissionWorker extends Employee {

    private double salary; // base salary per week
    private double commission; // amount per item sold
    private int quantity; // total items sold for week

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last,
            double salary, double commission, int quantity) {
        super(first, last); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    // set CommissionWorker's weekly base salary
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setSalary(double weeklySalary) {
        salary = weeklySalary;
    }

    // set CommissionWorker's commission
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setCommission(double itemCommission) {
        commission = itemCommission;
    }

    // set CommissionWorker's quantity sold
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setQuantity(int totalSold) {
        quantity = totalSold;
    }

    // determine CommissionWorker's earnings
/***** ASSIGNMENT INSTRUCTION
 * - Change the Earnings() method in Employee and all sub-classes to throw a generic Exception 
 * if the total earnings would be less than zero. The exception should have a message with the 
 * employee's name and the error encountered.
 */ 
    @Override
    public double earnings() throws Exception {
        if((salary + commission * quantity)<0)
            throw new Exception();
        return salary + commission * quantity;
    }

    // get String representation of CommissionWorker's name
    @Override
    public String toString() {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
