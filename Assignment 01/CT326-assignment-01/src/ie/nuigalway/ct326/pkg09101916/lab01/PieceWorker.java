/***** 
 * CT326 - Assignment 01 - c.loughnane1@nuigalway.ie - 09101916
 */
package ie.nuigalway.ct326.pkg09101916.lab01;

// PieceWorker class derived from Employee
import org.joda.time.DateTime;

public final class PieceWorker extends Employee {

    private double wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last, DateTime joinDate,
            double wage, int numberOfItems) {
        super(first, last, joinDate); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
    public void setWage(double wage) {
        wagePerPiece = (wage > 0 ? wage : 0);
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
    @Override
    public double earnings() {
        return quantity * wagePerPiece;
    }

    @Override
    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
