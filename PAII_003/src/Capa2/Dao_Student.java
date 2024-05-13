/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Capa2;

import Capa3.Schedule;
import Capa3.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Resources.Dao;

/**
 *
 * @ David Granda
 */
public class Dao_Student implements Dao {
    
      @Override
      public void create(Connection connection, Object o) throws SQLException {
            if (o instanceof Schedule) {
        Student s = (Student) o;
		String query = "INSERT INTO Students (id, Name,LName, Age) VALUES (?, ?, ?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, s.getId());
			stmt.setString(2, s.getName());
                        stmt.setString(3, s.getLname());
			stmt.setInt(4, s.getAge());
			stmt.executeUpdate();
			System.out.println("student created successfully.");
		}}
	}
      
      

	// Método para obtener una persona por su cédula
      @Override
	public  Student read(Connection connection, int id) throws SQLException {
		String query = "SELECT * FROM Students WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Student(rs.getInt("Id"),
                                                rs.getString("Name"),
                                                 rs.getString("LName"),
                                                rs.getInt("Age"));
							
				} else {
					System.out.println("The Student with the specified ID was not found.");
				}
			}
		}
		return null;
	}

	// Método para actualizar los datos de una persona
      @Override
	public  void update(Connection connection, Object o ) throws SQLException {
             if (o instanceof Schedule) {
            Student s = (Student) o;
		String query = "UPDATE Clientes SET Id = ?, Name = ?, LName = ?, Age = ? WHERE Id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, s.getId());
			stmt.setString(2, s.getName());
                        stmt.setString(2, s.getLname());
			stmt.setInt(3, s.getAge());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Successfully updated person.");
			} else {
				System.out.println("The Student with the specified ID was not found.");
			}
		}}
	}

	// Método para eliminar una persona por su cédula
      @Override
	public  void delete(Connection connection, int id) throws SQLException {
		String query = "DELETE FROM Students WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Successfully removed person.");
			} else {
				System.out.println("The Student with the specified ID was not found.");
			}
		}
	}

	// Método para obtener todas las personas de la tabla
      @Override
	public  List<Student> getAll(Connection connection) throws SQLException {
		List<Student> s = new ArrayList<Student>();
		String query = "SELECT * FROM Students";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					s.add(new Student(rs.getInt("Id"), 
                                                rs.getString("Name"),
                                                rs.getString("LName"),
                                                rs.getInt("Age")
                                         ));
				}
			}
		}
		return s;
	}



      @Override
	public  void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS Students (" + "" + "Id INT AUTO_INCREMENT PRIMARY KEY," + ""
				+ "Name VARCHAR(20) ," + "LName VARCHAR(20)," + "Age INT(3))";
		connection.createStatement().executeUpdate(query);
		System.out.println("Created or existing table.");
	}

}
