/*****
 * CT326 - Assignment 09 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg09.part01;

/***** ASSIGNMENT INSTRUCTION
 * Write a driver program that creates an instance of the BankAccount class and
 * then creates several concurrent threads that use the various methods of the 
 * same bank account object. 
 */
public class TestThread extends Thread
{
    private boolean terminate = false;
    private BankAccount acc;
    private int threadID;
    
    public TestThread(BankAccount acc, int threadID)
    {
        this.acc = acc;
        this.threadID = threadID;
    }
    
    @Override
    public void run()
    {
        while(!terminate)
        {
            //synchronized to keep the transactions grouped for each thread
            synchronized(acc)
            {
                acc.makeDeposit(100);
                System.out.println("Thread: "+threadID+" deposit:    "+acc.toString());
                acc.makeWithDrawal(150);
                System.out.println("Thread: "+threadID+" withdrawal: "+acc.toString());            
                acc.makeDeposit(50);
                System.out.println("Thread: "+threadID+" deposit:    "+acc.toString()); 

                this.terminate = true;
                System.out.println("After Thread: "+threadID+". "+acc.toString());
            }
        }
    }
    
    public static void main(String[] args) 
    {

        BankAccount acc = new BankAccount(100);
        
        for(int i=0;i<100;i++)
        {
            new TestThread(acc, (i+1)).start();
        } 
    }
}
