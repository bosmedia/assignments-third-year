/*****
 * CT326 - Assignment 10 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg10;

public class TestProgram
{
    public TestProgram(){}
    
    private static IntBuffer cubbyhole;
    private static int number;
    
    public static void main(String[] args)
    {
        cubbyhole  = new IntBuffer();
        
        number++;
        new Consumer(cubbyhole, number).start();
        new Producer(cubbyhole, number).start();
        number++;
        new Producer(cubbyhole, number).start();
        new Consumer(cubbyhole, number).start();
        number++;
        new Producer(cubbyhole, number).start();
        new Consumer(cubbyhole, number).start();
    }
}
