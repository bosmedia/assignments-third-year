/*****
 * CT326 - Assignment 10 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author c.loughnane1@nuigalway.ie - 09101916
 */
public class IntBuffer
{
    private int contents = -1;
    private boolean available = false;
    
    /***** ASSIGNMENT INSTRUCTION
    * Modify the IntBuffer class (in the notes) to use the Java Concurrency API.
    * In particular, use the ReentrantLock and Condition classes to implement 
    * similar functionality.
    */
    final Lock lock = new ReentrantLock();
    final Condition empty  = lock.newCondition();
    final Condition full = lock.newCondition();
    
    public int get() throws InterruptedException
    {
        lock.lock();
        try {
            while (available == false)
            {
                full.await();
            }
            available = false;
            empty.signal();
            return contents;
        } finally {
            lock.unlock();
        }
    }
    
    public void put(int value) throws InterruptedException
    {
        lock.lock();
        try {
            while (available == true)
            {
                empty.await();
            }
            contents = value;
            available = true;
            full.signal();
        }finally{
            lock.unlock();
        }
    }

}
