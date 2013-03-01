/*****
 * CT326 - Assignment 07 - c.loughnane1@nuigalway.ie - 09101916
 */

package myversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/***** ASSIGNMENT INSTRUCTION
 * 2. Write a Java program that uses an ArrayList to store a collection of Rational
 * objects. Then use the built-in Collections.sort() method to sort the contents
 * of the list. Print out the contents of the list to verify the results.
 */
public class TestProgram
{
    private static ArrayList<Rational> rationalArray;
    private static FindRational rationalApp;
    
    public static void main(String[] args)
    {
        rationalApp = new FindRational();
        
        rationalArray = new ArrayList<>();
        
        generateRationals();
        
        rationalApp.display(rationalArray.toString() + " unsorted list.\n");
        
        /***** ASSIGNMENT INSTRUCTION
        * 2. Then use the built-in Collections.sort() method to sort the contents
        * of the list. Print out the contents of the list to verify the results.
        */
        Collections.sort(rationalArray);
        
        rationalApp.display(rationalArray.toString() + " sorted list.\n");
        
        /***** ASSIGNMENT INSTRUCTION
         * 4. Use the Collections.shuffle() method to shuffle the elements in your
         * list, print out the results and then sort them again (using Collections.sort(),
         * again printing to confirm)
         */
        Collections.shuffle(rationalArray);
        
        rationalApp.display(rationalArray.toString() + " shuffled list.\n");
        
        Collections.sort(rationalArray, ArrayRationalSort.RATIONALSORT);
        
        rationalApp.display(rationalArray.toString() + " own sort implementation.\n");
    }
    
    public static int random()
    {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10)+1;
    }
    
    public static void generateRationals()
    {
        for(int i=0;i<10;i++)
        {
            rationalArray.add(new Rational(random(),random()));
        }
    }
    
    public static void getFractionInput()
    {
        try
        {
            String stringFraction = JOptionPane.showInputDialog(null,"","Enter fraction in a/b format."
                    , JOptionPane.PLAIN_MESSAGE);
            StringTokenizer newToken = new StringTokenizer(stringFraction,"/");
            
            int searchNumerator = Integer.parseInt(newToken.nextToken());
            int searchDenominator = Integer.parseInt(newToken.nextToken());
            
            if(searchDenominator ==0)
            {
                rationalApp.display("ERROR: denominator cannot be zero. Adjusted to 1.\n");
                searchDenominator = 1;
            }
            Rational searchFraction = new Rational(searchNumerator,searchDenominator);
            rationalApp.display("searching for "+searchFraction.toString()+"...\n");
            
            /***** ASSIGNMENT INSTRUCTION
            * Modify the program to use the built-in Collections.binarySearch() 
            * method to check if a particular fraction is contained within the 
            * list. Print out your results. Use a JOptionPane input for this part.
            */
            int searchFractionIndex = Collections.binarySearch(rationalArray, searchFraction, null);
            
            if(searchFractionIndex >= 0)
            {
                System.out.print("found at position "+searchFractionIndex+"\n");             
            }
            else
            {
                System.out.print("fraction is not in list\n");
            }          
        }
        catch(Exception e)
        {
            rationalApp.display("ERROR: Invalid values entered\n");
        }
    }
}