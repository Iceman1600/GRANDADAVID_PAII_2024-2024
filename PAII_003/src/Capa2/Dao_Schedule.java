/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Capa2;

import Capa3.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Resources.Dao;

 /*
 * @ David Granda
 */
public class Dao_Schedule implements Dao {
    
    @Override
    public  void create(Connection connection, Object o) throws SQLException {
          if (o instanceof Schedule) {
        Schedule s = (Schedule) o;
        String query = "INSERT INTO Schedule (id_courses, id_student, id_prof, hour_b, hour_f, day) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
      
            stmt.setInt(1, s.id_courses);
            stmt.setInt(2, s.id_student);
            stmt.setInt(3, s.id_prof);
            stmt.setObject(4, java.sql.Time.valueOf(s.hour_b)); // Convertir LocalTime a java.sql.Time
            stmt.setObject(5, java.sql.Time.valueOf(s.hour_f)); // Convertir LocalTime a java.sql.Time
            stmt.setObject(6, java.sql.Date.valueOf(s.day)); // Convertir LocalDate a java.sql.Date
            stmt.executeUpdate();
            System.out.println("Schedule created successfully.");
        }}
    }
    
   /*   public static void create2(Connection connection, Object o) throws SQLException {
          if (o instanceof Schedule) {
        Schedule s = (Schedule) o;
        String query = "INSERT INTO Schedule (id_courses, id_student, id_prof, hour_b, hour_f, day) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
      
            stmt.setInt(1, s.id_courses);
            stmt.setInt(2, s.id_student);
            stmt.setInt(3, s.id_prof);
            stmt.setObject(4, java.sql.Time.valueOf(s.hour_b)); // Convertir LocalTime a java.sql.Time
            stmt.setObject(5, java.sql.Time.valueOf(s.hour_f)); // Convertir LocalTime a java.sql.Time
            stmt.setObject(6, java.sql.Date.valueOf(s.day)); // Convertir LocalDate a java.sql.Date
            stmt.executeUpdate();
            System.out.println("Schedule created successfully.");
        }}
    }*/
    
    @Override
     public  Schedule read(Connection connection, int id) throws SQLException {
       
     String query = "SELECT s.id_courses, s.id_student, " + // Añadir el operador de concatenación al final
               "s.id_prof, s.hour_b, s.hour_f, s.day " +
               "FROM Schedule s " +
               "INNER JOIN Courses c ON s.id_courses = c.Id " +
               "INNER JOIN Students st ON s.id_student = st.Id " +
               "INNER JOIN Professors p ON s.id_prof = p.Id " + // Agregar un espacio después de p.Id
               "WHERE id_courses = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
            
                    int id_courses = rs.getInt("id_courses");
                    int id_student = rs.getInt("id_student");
                    int id_prof = rs.getInt("id_prof");
                    LocalTime hour_b = rs.getTime("hour_b").toLocalTime(); // Convertir java.sql.Time a LocalTime
                    LocalTime hour_f = rs.getTime("hour_f").toLocalTime(); // Convertir java.sql.Time a LocalTime
                    LocalDate day = rs.getDate("day").toLocalDate(); // Convertir java.sql.Date a LocalDate
                    return new Schedule(id_courses, id_student, id_prof, hour_b, hour_f, day);
                } else {
                    System.out.println("The Schedule with the specified ID was not found.");
                }
            }
        }
        return null;
    }
     
     
    @Override
     public  void update(Connection connection, Object o) throws SQLException {
          if (o instanceof Schedule) {
        Schedule s = (Schedule) o;
    String query = "UPDATE Schedule SET id_courses = ?, id_student = ?, id_prof = ?, hour_b = ?, hour_f = ?, day = ? WHERE id_courses = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, s.id_courses);
        stmt.setInt(2, s.id_student);
        stmt.setInt(3, s.id_prof);
        stmt.setObject(4, java.sql.Time.valueOf(s.hour_b)); // Convertir LocalTime a java.sql.Time
        stmt.setObject(5, java.sql.Time.valueOf(s.hour_f)); // Convertir LocalTime a java.sql.Time
        stmt.setObject(6, java.sql.Date.valueOf(s.day)); // Convertir LocalDate a java.sql.Date
        stmt.setInt(7, s.id_courses); // Cláusula WHERE usando id_courses
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Successfully updated Schedule.");
        } else {
            System.out.println("The Schedule with the specified ID was not found.");
        }
    }}
}
     
  

    @Override
    public  void delete(Connection connection, int id) throws SQLException {
    String query = "DELETE FROM Schedule WHERE id_courses = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Successfully removed schedule.");
        } else {
            System.out.println("The Schedule with the specified ID was not found.");
        }
    }
}

    @Override
    public List<Schedule> getAll(Connection connection) throws SQLException {
    List<Schedule> scheduleList = new ArrayList<>();
    String query = "SELECT * FROM Schedule";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id_courses = rs.getInt("id_courses");
                int id_student = rs.getInt("id_student");
                int id_prof = rs.getInt("id_prof");
                LocalTime hour_b = rs.getTime("hour_b").toLocalTime(); // Convertir java.sql.Time a LocalTime
                LocalTime hour_f = rs.getTime("hour_f").toLocalTime(); // Convertir java.sql.Time a LocalTime
                LocalDate day = rs.getDate("day").toLocalDate(); // Convertir java.sql.Date a LocalDate

                scheduleList.add(new Schedule(id_courses, id_student, id_prof, hour_b, hour_f, day));
            }
        }
    }
    return scheduleList;
}

    @Override
    public  void createTable(Connection connection) throws SQLException {
    String query = "CREATE TABLE IF NOT EXISTS Schedule (" +
                   "id_courses INT," +
                   "id_student INT," +
                   "id_prof INT," +
                   "hour_b TIME," +
                   "hour_f TIME," +
                   "day DATE," +
                   "FOREIGN KEY (id_courses) REFERENCES Courses(Id)," +
                   "FOREIGN KEY (id_student) REFERENCES Students(Id)," +
                   "FOREIGN KEY (id_prof) REFERENCES Professors(Id)," +
                   "PRIMARY KEY (id_courses, id_student, day))";
    connection.createStatement().executeUpdate(query);
    System.out.println("Created or existing table.");
}

}


