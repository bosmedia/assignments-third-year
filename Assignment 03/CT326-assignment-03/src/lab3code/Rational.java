/*****
 * CT326 - Assignment 03 - c.loughnane1@nuigalway.ie - 09101916
 */

package lab3code;

/***** ASSIGNMENT INSTRUCTION
 * - Write a Java class called Rational for performing arithmetic with fractions.
 */
public class Rational
{
    /***** ASSIGNMENT INSTRUCTION
     * - Use integer variables to represent the two private variables of the class:
     * the numerator and the denominator, and corresponding Getter methods.
     */
    private int numerator;
    private int denominator;
    
    public Rational()
    {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    public Rational(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int getNumerator()
    {
        return this.numerator;
    }
    
    public int getDenominator()
    {
        return this.denominator;
    }
    
    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }
    
    public void setDenominator(int denominator)
    {
        this.denominator = denominator;
    }
    
    /***** ASSIGNMENT INSTRUCTION
     * – Also provide public methods for addition, subtraction, multiplication and division of
     * two fractions, and use the formatted output functions to print out the result to the console.
     */
    public static Rational addition(Rational current, Rational preivious)
    {
        int commonDenominator = lcm(current.denominator, preivious.denominator);
        
        int newNumerator = (current.numerator*(commonDenominator/current.denominator))
                +(preivious.numerator*(commonDenominator/preivious.denominator));
        
        return reduce(new Rational(newNumerator, commonDenominator));
    }
    
    public static Rational subtraction(Rational current, Rational previous)
    {
        int commonDenominator = lcm(current.denominator, previous.denominator);
        
        int newNumerator = (current.numerator*(commonDenominator/current.denominator))
                -(previous.numerator*(commonDenominator/previous.denominator));
        
        return new Rational(newNumerator, commonDenominator);
    }
    
    public static Rational multiplication(Rational current, Rational previous)
    {   
        return reduce(new Rational(current.getNumerator()*previous.getNumerator()
                            ,current.getDenominator()*previous.getDenominator()));
    }
    
    public static Rational division(Rational current, Rational previous)
    {   
        return reduce(new Rational(current.getNumerator()*previous.getDenominator()
                            ,current.getDenominator()*previous.getNumerator()));
    }
    
    private static int lcm(int denominatorOne, int denominatorTwo)
    {
        int num1, num2;
        if (denominatorOne > denominatorTwo) {
            num1 = denominatorOne;
            num2 = denominatorTwo;
        } else {
            num1 = denominatorTwo;
            num2 = denominatorOne;
        }
        for (int i = 1; i <= num2; i++) {
            if ((num1 * i) % num2 == 0) {
                return i * num1;
            }
        }
        throw new Error("Error");
    }
    /*****
     * using Euclidean algorithm for getting gcd
     */
    
    public static Rational reduce(Rational reduceRational)
    {
        int originalNumerator, tempNumerator;
        int originalDenominator, tempDenominator;
        
        originalNumerator = tempNumerator = reduceRational.getNumerator();
        originalDenominator = tempDenominator = reduceRational.getDenominator();
        
        while (tempDenominator != 0)
        {
            int temp = tempDenominator;
            tempDenominator = tempNumerator % tempDenominator;
            tempNumerator = temp;
        }
        int gcd = tempNumerator;
        
        return new Rational((originalNumerator /= gcd),(originalDenominator /= gcd));
    }
    
    @Override
    public String toString()
    {
        return numerator+"/"+denominator;
    }
}
