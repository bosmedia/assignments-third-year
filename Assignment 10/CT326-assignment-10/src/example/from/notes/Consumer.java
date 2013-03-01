/*****
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*****
 * CTXXX - Assignment XX - c.loughnane1@nuigalway.ie - 09101916
 */


package example.from.notes;

/**
 *
 * @author c.loughnane1@nuigalway.ie - 09101916
 */
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
            value = cubbyhole.get();
            System.out.println("Consumer #"+this.number+ " got:"+ value);
        }
    }
}
