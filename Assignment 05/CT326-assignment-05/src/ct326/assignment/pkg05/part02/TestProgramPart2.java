/*****
 * CT326 - Assignment 05 - c.loughnane1@nuigalway.ie - 09101916
 * 
 * part 2
 * 
 */

package ct326.assignment.pkg05.part02;

import java.io.*;

/***** ASSIGNMENT INSTRUCTION
 * - Copy and rename these two classes. This time, use custom readObject() and
 * writeObject() override methods in StudentData to read and write the object's 
 * variables. Do not use defaultWriteObject or defaultReadObject methods to do 
 * this.
 */
public class TestProgramPart2
{
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        /*****
         * create array of objects and create some StudentData
         */
        StudentDataPart2[] students;
        
        students = new StudentDataPart2[3];
        
        StudentDataPart2 student1 = new StudentDataPart2("Chris Loughnane part 2","20/09/72","09101916");
        StudentDataPart2 student2 = new StudentDataPart2("Joe Bloggs part 2","02/10/92","10601371");
        StudentDataPart2 student3 = new StudentDataPart2("Batman part 2","07/04/1915","534534535345345");
        
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
            
        /*****
         * create file handling objects for output and write array of students
         */
        OutputStream outFile = new FileOutputStream("studentdatapart2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(outFile);
        
        oos.writeObject(students);
        
        oos.close();
        outFile.close();
       
        /*****
         * create file handling objects for input and read objects from file
         */
        InputStream inFile = new FileInputStream( "studentdatapart2.txt" );
        ObjectInputStream ios = new ObjectInputStream(inFile);
          
        StudentDataPart2[] readStudentArray = (StudentDataPart2[])ios.readObject();
       
        /*****
         * display data loaded from file
         */
        for(StudentDataPart2 student: readStudentArray)
        {
            System.out.println(student.toString());
        }
        
        ios.close();
        inFile.close();   
    }  
}
