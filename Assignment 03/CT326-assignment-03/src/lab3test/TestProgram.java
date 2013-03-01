/*****
 * CT326 - Assignment 03 - c.loughnane1@nuigalway.ie - 09101916
 */

/***** ASSIGNMENT INSTRUCTION
 * - Write a short driver program that could be used to test your class. Pass 
 * the various runtime parameters as strings in the form of x/y, use the Enhanced 
 * For Loop to loop through them, and then use a StringTokenizer to divide the 
 * inputted fractions into numbers. Note that StringTokenizer(string, "//" ) will 
 * tokenize the string using backslashes as the divider instead of spaces.
 */
package lab3test;

import java.util.StringTokenizer;
import lab3code.Rational;

public class TestProgram
{
    private static StringTokenizer newToken;

    public static void main(String[] args)
    {   
        Rational current, previous =  null;
        Rational addition;
        Rational subtraction;
        Rational multipication;
        Rational division;
                 
        for (String fraction : args)
        {
            newToken = new StringTokenizer(fraction,"/"); 
            
            current = new Rational(Integer.parseInt(newToken.nextToken())
                    ,Integer.parseInt(newToken.nextToken()));
                     
            /***** ASSIGNMENT INSTRUCTION
            * - Still in that loop, use the methods created earlier to add, subtract, multiply 
            * and divide the current fraction with the one prior. The first fraction inputted 
            * can be ignored.
            */
            if (previous != null)
            {
                System.out.format("current fraction: %d/%d",current.getNumerator(),current.getDenominator());
                System.out.format("\tprevious fraction: %d/%d\n",previous.getNumerator(),previous.getDenominator());
                  
                addition =         Rational.addition(current, previous);
                subtraction =      Rational.subtraction(current, previous);
                multipication =    Rational.multiplication(current, previous);
                division =         Rational.division(current, previous);
                
                System.out.format("\t\t\tAddition\t%d/%d\n",addition.getNumerator(),addition.getDenominator());
                System.out.format("\t\t\tSubtraction\t%d/%d\n",subtraction.getNumerator(),subtraction.getDenominator());
                System.out.format("\t\t\tMultipication\t%d/%d\n",multipication.getNumerator(),multipication.getDenominator());
                System.out.format("\t\t\tDivision\t%d/%d\n",division.getNumerator(),division.getDenominator());
            }
            previous = current;            
        }
    }
}