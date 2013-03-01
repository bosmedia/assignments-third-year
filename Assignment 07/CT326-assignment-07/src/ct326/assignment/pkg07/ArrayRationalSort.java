/*****
 * CT326 - Assignment 07 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg07;

import java.util.Comparator;

/***** ASSIGNMENT INSTRUCTION
 * 3. Modify the program to use your own Comparator object i.e. write a class
 * that implements the java.util.Comparator interface and then use the version
 * of the sort() method that allows you to pass your own Comparator object
 * (the sort() method will take 2 arguments). Print out the contents of the list
 * to verify the results.
 */
public class ArrayRationalSort implements Comparator<Rational>
{    
    @Override
    public int compare(Rational t, Rational t1)
    {      
        return t.compareTo(t1);     
    }
}
