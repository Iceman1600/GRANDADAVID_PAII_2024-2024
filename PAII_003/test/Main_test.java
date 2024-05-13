/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import Resources.Connect;
import Capa2.Dao_Schedule;
import Capa3.Schedule;


/**
 *
 * @author USUARIO
 */
public class Main_test {

   
         private static Connection connection;
      
	    private static Connection obtenerConexion() throws SQLException {
	        return  Connect.getConnection();
	    }
     public static void main(String[] args) throws SQLException {
         connection = obtenerConexion();
            /*  Courses c = new Courses();
              Student s = new Student();
              Professor p = new Professor();
                int courseId;
                  int studentId;
                     int professorId;*/
      // Dao_Courses.createTable(conexion);
      // Dao_Student.createTable(conexion);
     // Dao_Professor.createTable(conexion);
   // Dao_Schedule.createTable(conexion);
  // Student s=  new Student(3,"David","LOPEZ",29);
  // Dao_Student.create(connection, s);
   
    // Professor p =  new Professor(1,"Andres","Gualoto",46);
   //  Professor p1 =  new Professor(3,"Silvio","Zabala",33);
    // Dao_Professor.create(connection,p1);
    
Schedule sc = new Schedule(
                1, // id_courses
                1, // id_student
                1, // id_prof
                LocalTime.of(9, 0), // hour_b (hora de inicio)
                LocalTime.of(11, 0), // hour_f (hora de finalización)
                LocalDate.of(2024,3,11) // day (fecha actual)
            );
//Dao_Schedule.create2(connection, sc);
    // Dao_Schedule.read(connection, 1);
   //  Courses c =  new Courses(1,"Calculo","Matematicas",1);
     //     Dao_Courses.create(conexion,c);
     
     
  /*           courseId = c.getId();
             studentId = s.getId();
            professorId = p.getId();*/

            // Crear un objeto Schedule con las claves primarias
       /*     Schedule sc = new Schedule(
                courseId,
                studentId,
                professorId,
                LocalTime.of(9, 0),
                LocalTime.of(11, 0),
                LocalDate.of(2024, 5, 16)
            );
            Dao_Schedule.create(connection,sc);*/
}}
