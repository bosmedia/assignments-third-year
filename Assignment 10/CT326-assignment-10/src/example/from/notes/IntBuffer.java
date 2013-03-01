/*****
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*****
 * CT326 - Assignment 10 - c.loughnane1@nuigalway.ie - 09101916
 */

package example.from.notes;

/**
 *
 * @author c.loughnane1@nuigalway.ie - 09101916
 */
public class IntBuffer
{
    private int contents;
    private boolean available = false;
        
    public synchronized int get() {
        while (available == false) {
            try {
                // wait for Producer to put value
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        // notify Producer that value has been retrieved
        notifyAll();
        return contents;
    }
    
    public synchronized void put(int value) {
        while (available == true) {
            try {
                // wait for Consumer to get value
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        // notify Consumer that value has been set
        notifyAll();
    }

}
