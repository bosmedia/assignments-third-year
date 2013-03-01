/*****
 * CT326 - Assignment 05 - c.loughnane1@nuigalway.ie - 09101916
 * 
 * part 1
 * 
 */

package ct326.assignment.pkg05.part01;

import java.io.Serializable;

/***** ASSIGNMENT INSTRUCTION
 * - StudentData object
 */

public class StudentData implements Serializable
{
    private String name; 
    private String dob;
    private String ID;

    public StudentData()
    {
        name = "";
        dob = "";
        ID = "";
    }
    
    public StudentData(String name, String dob, String ID)
    {
        this.name = name;
        this.dob = dob;
        this.ID = ID;
    }   
    
    //accessors
    public String getName()
    {
        return name;
    }
    
    public String getDOB()
    {
        return dob;
    }
    
    public String getID()
    {
        return ID;
    }
    
    //mutators
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setDOB(String dob)
    {
        this.dob = dob;
    }
    
    public void setID(String ID)
    {
        this.ID = ID;
    }
    
    @Override
    public String toString()
    {
        return name + " " + dob + " " + ID;
    }
}