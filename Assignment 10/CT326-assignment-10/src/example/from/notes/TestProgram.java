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
//        number++;
//        new Consumer(cubbyhole, number).start();
//        new Producer(cubbyhole, number).start();
    }

}
