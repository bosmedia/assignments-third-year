/*****
 * CT326 - Assignment 09 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg09.part01;

/***** ASSIGNMENT INSTRUCTION
 * Write a simple BankAccount class that may be safely accessed by multiple threads
 * of execution at the same time (include deposit/withdraw methods)
 */
public class BankAccount 
{
    private double balance;
    
    public BankAccount(double balance)
    {
        this.balance = balance;
    }

    public synchronized void makeWithDrawal(double debit) 
    {
        balance -= debit;
    }

    public synchronized void makeDeposit(double credit) 
    {
        balance += credit;
    } 
    
    @Override
    public String toString()
    {
        return "The balance is: "+balance;
    }
}
