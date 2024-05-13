package uce.edu.ec.paii_004b;

//import java.awt.Container;
//import java.awt.Container
import uce.edu.ec.paii_004b.Container.Container;
import uce.edu.ec.paii_004b.Models.Student;

/**
 * Class containing the "main" method
 * prints Hello world! by default - replace with your code
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
   //    
        Student s = new Student(2,"homero","simpson",43);
//String resultStudent = Create(newStudent, "Student");
Container c = new Container();

c.Create(s, "Student");
  //System.out.println(c.Create(s, "Student"));
      

      //  System.out.println(resultStudent );
        
      //  String c = new Container().CreateStudent(2,"homero","simpson",43);
     //   System.out.println(c);
        
    }

   
}
