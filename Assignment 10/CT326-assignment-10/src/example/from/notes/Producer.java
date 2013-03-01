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
            cubbyhole.put(i);
            System.out.println("Producer #"+this.number+" put:" +i);
            try{
                sleep((int)(Math.random() * 100));
            }
            catch(InterruptedException e){}
        }
    }
}


