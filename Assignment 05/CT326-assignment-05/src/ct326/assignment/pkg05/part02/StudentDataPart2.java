/*****
 * CT326 - Assignment 05 - c.loughnane1@nuigalway.ie - 09101916
 * 
 * part 2
 * 
 */

package ct326.assignment.pkg05.part02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/***** ASSIGNMENT INSTRUCTION
 * - StudentData object part 2
 */

public class StudentDataPart2 implements Serializable
{
    private String name; 
    private String dob;
    private String ID;

    public StudentDataPart2()
    {
        name = "";
        dob = "";
        ID = "";
    }
    
    public StudentDataPart2(String name, String dob, String ID)
    {
        this.name = name;
        this.dob = dob;
        this.ID = ID;
    }   
    
    public void writeObject(ObjectOutputStream stream) throws IOException 
    {
        stream.writeObject(name);
        stream.writeObject(dob);
        stream.writeObject(ID);
    }
    
    public void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException 
    {
        this.name = (String)stream.readObject();
        this.dob = (String)stream.readObject();
        this.ID = (String)stream.readObject();
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