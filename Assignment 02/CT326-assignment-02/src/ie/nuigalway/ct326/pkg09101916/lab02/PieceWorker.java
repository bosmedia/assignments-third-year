package ie.nuigalway.ct326.pkg09101916.lab02;

// PieceWorker class derived from Employee

public final class PieceWorker extends Employee {

    private double wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,
            double wage, int numberOfItems) {
        super(first, last); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setWage(double wage) {
        wagePerPiece = wage;
    }

    // set number of items output
/***** ASSIGNMENT NOTE
 * Note: you may have to remove the "if less than zero, set to zero" 
 * [wagePerHour > 0 ? wagePerHour : 0] parts of the subclasses.
 */
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
/***** ASSIGNMENT INSTRUCTION
 * - Change the Earnings() method in Employee and all sub-classes to throw a generic Exception 
 * if the total earnings would be less than zero. The exception should have a message with the 
 * employee's name and the error encountered.
 */ 
    @Override
    public double earnings() throws Exception {
        if((quantity * wagePerPiece)<0)
            throw new Exception();
        return quantity * wagePerPiece;
    }

    @Override
    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
