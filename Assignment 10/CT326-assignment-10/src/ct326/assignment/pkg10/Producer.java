/*****
 * CT326 - Assignment 10 - c.loughnane1@nuigalway.ie - 09101916
 */
package ct326.assignment.pkg10;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread
{
    private IntBuffer cubbyhole;
    private int number;
    
    public Producer(IntBuffer c, int number)
    {
        cubbyhole = c;
        this.number = number;
    }
    
    @Override
    public void run()
    {
        for (int i=0;i<10;i++)
        {
            try{
                cubbyhole.put(i);
                System.out.println("Producer #"+this.number+" put:" +i);
                try{
                    sleep((int)(Math.random() * 100));
                }
                catch(InterruptedException e){}
            }
            catch(InterruptedException ex){Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }
}


