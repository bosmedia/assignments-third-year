/*****
 * CT326 - Assignment 07 - c.loughnane1@nuigalway.ie - 09101916
 */

package ct326.assignment.pkg07;

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
    private static GUIFindRational rationalApp;
    
    public static void main(String[] args)
    {
        rationalApp = new GUIFindRational();
        
        rationalArray = new ArrayList<>();
        
        newArrayValues();
    }
    
    public static int random()
    {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10)+1;
    }
    
    public static void generateRationals()
    {
        rationalArray.clear();
        for(int i=0;i<10;i++)
        {
            rationalArray.add(new Rational(random(),random()));
        }
    }
    
    public static void newArrayValues()
    {
        generateRationals();
        
        System.out.print(rationalArray.toString() + " unsorted list.\n");
        
        /***** ASSIGNMENT INSTRUCTION
        * 2. Then use the built-in Collections.sort() method to sort the contents
        * of the list. Print out the contents of the list to verify the results.
        */
        Collections.sort(rationalArray);
        
        System.out.print(rationalArray.toString() + " sorted list.\n");
        
        /***** ASSIGNMENT INSTRUCTION
         * 4. Use the Collections.shuffle() method to shuffle the elements in your
         * list, print out the results and then sort them again (using Collections.sort(),
         * again printing to confirm)
         */
        Collections.shuffle(rationalArray);
        
        System.out.print(rationalArray.toString() + " shuffled list.\n");
        
        /***** ASSIGNMENT INSTRUCTION
        * 3. Modify the program to use your own Comparator object i.e. write a class 
        * that implements the java.util.Comparator interface and then use the version 
        * of the sort() method that allows you to pass your own Comparator object 
        * (the sort() method will take 2 arguments). Print out the contents of the list
        * to verify the results.  
        */
        Collections.sort(rationalArray, new ArrayRationalSort());
        
        System.out.print(rationalArray.toString() + " own sort implementation.\n");
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
            
            if(searchDenominator == 0)
            {
                System.out.print("ERROR: I wont let you end the Universe. Denominator adjusted to 1.\n");
                searchDenominator = 1;
            }
            Rational searchFraction = new Rational(searchNumerator,searchDenominator);
            System.out.print("searching for "+searchFraction.toString()+"...\n");
            
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
            System.out.print("ERROR: Invalid values entered\n");
        }
    }
}