package ie.nuigalway.ct326.pkg09101916.lab02;

// Abstract base class Employee.

public abstract class Employee {

    private String firstName;
    private String lastName;

    // constructor
    public Employee(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + ' ' + lastName;
    }

/***** ASSIGNMENT INSTRUCTION
 * - Change the Earnings() method in Employee and all sub-classes to throw a generic Exception 
 * if the total earnings would be less than zero. The exception should have a message with the 
 * employee's name and the error encountered.
 */ 
    public abstract double earnings() throws Exception;
}
