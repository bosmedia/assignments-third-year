/*****
 * CT326 - Assignment 06 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg06;

import java.util.ArrayList;
import java.util.Random;

/*****
 * Write a Java program that uses an ArrayList to store a collection of 10 Rational
 * objects. Write a simple algorithm that manually iterates through the contents of
 * the list and places them in ascending (i.e. smallest Rational to the biggest
 * Rational) order into a new list. You can use a simple bubble sort or similar
 * algorithm to do the sorting – do NOT use the built-in sort algorithm at this
 * stage. (6 marks)
 */
public class TestProgram
{
    private static ArrayList<Rational> rationalArray;
    
    public static void main(String[] args)
    {
        rationalArray = new ArrayList<>();
        
        generateRationals();
        
        System.out.println(rationalArray.toString()+" ArrayList before sort:");
        
        sortArray(rationalArray.size());
        
    }
    
    public static int random()
    {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10)+1;
    }
    
    /***** ASSIGNMENT INSTRUCTION
    * Write a Java program that uses an ArrayList to store a collection of 10 
    * Rational objects.
    */ 
    public static void generateRationals()
    {
        for(int i=0;i<10;i++)
        {
            rationalArray.add(new Rational(random(),random()));
        }
    }
    
    /***** ASSIGNMENT INSTRUCTION
    * Write a simple algorithm that manually iterates through the contents of
    * the list and places them in ascending (i.e. smallest Rational to the biggest
    * Rational) order into a new list.
    */
    public static void sortArray(int length)
    {
        //order into a new list.
        ArrayList<Rational> sortedRationalArray = new ArrayList<>(rationalArray);
        Rational temp;
        boolean sorted;
        
        //using bubble sort with early sorted checking
        for(int i=0;i<length;i++)
        {
            sorted =true;
            for(int j=1;j<(length-i);j++)
            {
                if(sortedRationalArray.get(j-1).compareTo(sortedRationalArray.get(j))> 0)
                {
                    temp = new Rational(sortedRationalArray.get(j-1).getNumerator(),
                            sortedRationalArray.get(j-1).getDenominator());
                    sortedRationalArray.set(j-1,sortedRationalArray.get(j));
                    sortedRationalArray.set(j,temp);
                    sorted = false;
                }
                /***** 
                * remove comment below to display each step
                */ 
                //System.out.println(rationalArray.toString());
            }
            /***** 
             * if there have been no swaps the array is now sorted and no need to
             * continue with more passes 
             */           
            if(sorted)
            {
                System.out.println("Array is now sorted.\n");
                break;
            }
            /***** ASSIGNMENT INSTRUCTION
            * Print out the contents of the list at each stage to verify the 
            * results. (1 marks)
            */
            System.out.print(sortedRationalArray.toString());
            System.out.println(" Pass " + (i+1));
        }
        System.out.println(rationalArray.toString() + " Original unsorted list.");
        System.out.println(sortedRationalArray.toString() + " Copied and sorted list.");
    }

}
