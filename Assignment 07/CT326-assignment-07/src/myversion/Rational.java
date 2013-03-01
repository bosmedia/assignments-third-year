/*****
 * CT326 - Assignment 07 - c.loughnane1@nuigalway.ie - 09101916
 */
package myversion;

/***** ASSIGNMENT INSTRUCTION
 * 1. Use the Rational class that you modified in the previous assignment, so that
 * it correctly implements the comparable interface.
 */
public class Rational implements Comparable<Rational>
{
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
        if(denominator > 0) 
        {
            this.denominator = denominator;
        }
        else 
        {
            this.denominator = 1;
        }
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
    
    private static int lcm(int thisDenominator, int incomingDenominator)
    {
        int num1, num2;
        if (thisDenominator > incomingDenominator) {
            num1 = thisDenominator;
            num2 = incomingDenominator;
        } else {
            num1 = incomingDenominator;
            num2 = thisDenominator;
        }
        for (int i = 1; i <= num2; i++) {
            if ((num1 * i) % num2 == 0) {
                return i * num1;
            }
        }
        throw new Error("Error");
    }
    
    /***** ASSIGNMENT INSTRUCTION
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
        
        return new Rational((originalNumerator / gcd),(originalDenominator / gcd));
    }
    
    @Override
    public String toString()
    {
        return numerator+"/"+denominator;
    }

    @Override
    public int compareTo(Rational nextFraction) 
    {
        int commonDenominator = lcm(this.denominator, nextFraction.denominator);
        
        int thisNumerator = (this.numerator*(commonDenominator/this.denominator));
        int nextNumerator = (nextFraction.numerator*(commonDenominator/nextFraction.denominator));
              
        return thisNumerator - nextNumerator;
    }
}
