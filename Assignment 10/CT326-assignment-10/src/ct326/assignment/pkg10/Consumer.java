/*****
 * CT326 - Assignment 10 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg10;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread
{
    private int number;
    private IntBuffer cubbyhole;
    
    public Consumer(IntBuffer c, int number)
    {
        cubbyhole = c;
        this.number = number;
    }
    
    @Override
    public void run()
    {
        int value;
        for (int i=0;i<10;i++)
        {
            try {
                sleep(1);
                value = cubbyhole.get();
                System.out.println("Consumer #"+this.number+ " got:"+ value);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
