/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Capa2;

import Capa3.Professor;
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
public class Dao_Professor implements Dao {
    
    @Override
    public void create(Connection connection, Object o) throws SQLException {
            if (o instanceof Professor) {
                 Professor p = (Professor) o;
		String query = "INSERT INTO Professors (id, Name,LName, Age) VALUES (?, ?, ?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
                        stmt.setString(3, p.getLname());
			stmt.setInt(4, p.getAge());
			stmt.executeUpdate();
			System.out.println("Professor created successfully.");
		}}
	}

	// Método para obtener una persona por su cédula
    @Override
	public Professor read(Connection connection, int id) throws SQLException {
		String query = "SELECT * FROM Professors WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Professor(rs.getInt("Id"),
                                                rs.getString("Name"),
                                                 rs.getString("LName"),
                                                rs.getInt("Age"));
							
				} else {
					System.out.println("The Professor with the specified ID was not found.");
				}
			}
		}
		return null;
	}

	// Método para actualizar los datos de una persona
    @Override
	public  void update(Connection connection, Object o ) throws SQLException {
            if (o instanceof Professor) {
                 Professor p = (Professor) o;
		String query = "UPDATE Professors SET Id = ?, Name = ?, LName = ?, Age = ? WHERE Id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
                        stmt.setString(2, p.getLname());
			stmt.setInt(3, p.getAge());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Successfully updated person.");
			} else {
				System.out.println("The Professor with the specified ID was not found.");
			}
		}}
	}

	// Método para eliminar una persona por su cédula
    @Override
	public void delete(Connection connection, int id) throws SQLException {
		String query = "DELETE FROM Professors WHERE id = ?";
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
	public  List<Professor> getAll(Connection connection) throws SQLException {
		List<Professor> p = new ArrayList<Professor>();
		String query = "SELECT * FROM Professors";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					p.add(new Professor(rs.getInt("Id"), 
                                                rs.getString("Name"),
                                                rs.getString("LName"),
                                                rs.getInt("Age")
                                         ));
				}
			}
		}
		return p;
	}



    @Override
	public  void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS Professors (" + "" + "Id INT AUTO_INCREMENT PRIMARY KEY," + ""
				+ "Name VARCHAR(20) ," + "LName VARCHAR(20)," + "Age INT(3))";
		connection.createStatement().executeUpdate(query);
		System.out.println("Created or existing table.");
	}


}
