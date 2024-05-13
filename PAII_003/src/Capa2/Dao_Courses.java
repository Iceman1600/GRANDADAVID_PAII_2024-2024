/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Capa2;

import Capa3.Courses;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
public class Dao_Courses implements Dao {
    
    @Override
     public void create(Connection connection, Object o) throws SQLException {
          if (o instanceof Courses) {
        Courses c = (Courses) o;
		String query = "INSERT INTO Courses (Id, Name,Description, Level) VALUES (?, ?, ?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getName());
                        stmt.setString(3, c.getDescription());
			stmt.setInt(4, c.getLevel());
			stmt.executeUpdate();
			System.out.println("Course created successfully.");
		}}
	}

	// Método para obtener una persona por su cédula
    @Override
	public  Courses read(Connection connection, int id) throws SQLException {
		String query = "SELECT * FROM Courses WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Courses(rs.getInt("Id"),
                                                rs.getString("Name"),
                                                 rs.getString("Description"),
                                                rs.getInt("Level"));
							
				} else {
			System.out.println("The Course with the specified ID was not found.");
				}
			}
		}
		return null;
	}

	  @Override
	public void update(Connection connection, Object o ) throws SQLException {
                     if (o instanceof Courses) {
                   Courses c = (Courses) o;
               String query = "UPDATE Courses SET Id = ?, Name = ?, Description = ?, Level = ? WHERE Id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getName());
                        stmt.setString(2, c.getDescription());
			stmt.setInt(3, c.getLevel());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Successfully updated Course.");
			} else {
				System.out.println("The Course with the specified ID was not found.");
			}
		}}
	}

	// Método para eliminar una persona por su cédula
     @Override
	public void delete(Connection connection, int id) throws SQLException {
		String query = "DELETE FROM Courses WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Successfully removed course.");
			} else {
				System.out.println("The Course with the specified ID was not found.");
			}
		}
	}

	// Método para obtener todas las personas de la tabla
     @Override
	public  List<Courses> getAll(Connection connection) throws SQLException {
		List<Courses> c = new ArrayList<Courses>();
		String query = "SELECT * FROM Professors";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					c.add(new Courses(rs.getInt("Id"), 
                                                rs.getString("Name"),
                                                rs.getString("Description"),
                                                rs.getInt("Level")
                                         ));
				}
			}
		}
		return c;
	}



     @Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS Courses (" + "" + "Id INT AUTO_INCREMENT PRIMARY KEY," + ""
				+ "Name VARCHAR(20) ," + "Description VARCHAR(50)," + "Level INT(3))";
		connection.createStatement().executeUpdate(query);
		System.out.println("Created or existing table.");
	}


  

  

}
