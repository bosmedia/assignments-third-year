/***** 
 * CT326 - Assignment 01 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab01;

// CommissionWorker class derived from Employee
import org.joda.time.DateTime;

public final class CommissionWorker extends Employee {

    private double salary; // base salary per week
    private double commission; // amount per item sold
    private int quantity; // total items sold for week

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last, DateTime joinDate,
            double salary, double commission, int quantity) {
        super(first, last, joinDate); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    // set CommissionWorker's weekly base salary
    public void setSalary(double weeklySalary) {
        salary = (weeklySalary > 0 ? weeklySalary : 0);
    }

    // set CommissionWorker's commission
    public void setCommission(double itemCommission) {
        commission = (itemCommission > 0 ? itemCommission : 0);
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold) {
        quantity = (totalSold > 0 ? totalSold : 0);
    }

    // determine CommissionWorker's earnings
    @Override
    public double earnings() {
        return salary + commission * quantity;
    }

    // get String representation of CommissionWorker's name
    @Override
    public String toString() {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
