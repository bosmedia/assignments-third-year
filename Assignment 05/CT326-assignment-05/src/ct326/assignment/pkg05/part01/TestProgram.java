/*****
 * CT326 - Assignment 05 - c.loughnane1@nuigalway.ie - 09101916
 * 
 * part 1
 * 
 */

package ct326.assignment.pkg05.part01;

import java.io.*;

/***** ASSIGNMENT INSTRUCTION
 * - Write a simple Java program that creates an array of StudentData objects 
 * (name, Date Of Birth, and ID), including a toString override to print out all
 * variables. It then serializes the array (and not the StudentData objects 
 * individually) and saves it to a file named studentdata.txt. It should then 
 * read the array from the file and reconstruct a new array object from this 
 * data, and print out each item in the array to the console.
 */
public class TestProgram
{
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        /*****
         * create array of objects and create some StudentData
         */
        StudentData[] students = new StudentData[3];
        
        StudentData student1 = new StudentData("Chris Loughnane","20/09/72","09101916");
        StudentData student2 = new StudentData("Joe Bloggs","02/10/92","10601371");
        StudentData student3 = new StudentData("Batman","07/04/1915","534534535345345");
        
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
           
        /*****
         * create file handling objects for output and write array of students
         */
        OutputStream outFile = new FileOutputStream("studentdata.txt");
        ObjectOutput output = new ObjectOutputStream(outFile);
        
        output.writeObject(students);
        
        output.close();
        outFile.close();
        
       /*****
        * create file handling objects for input and read objects from file
        */
        InputStream inFile = new FileInputStream( "studentdata.txt" );

        ObjectInput input = new ObjectInputStream (inFile);

        StudentData[] readStudentArray = (StudentData[])input.readObject();
        
        /*****
         * display data loaded from file
         */
        for(StudentData student: readStudentArray)
        {
            System.out.println(student.toString());
        }
        
        input.close();
        inFile.close();  
    }  
}
