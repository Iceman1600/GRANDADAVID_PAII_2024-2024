/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @ David Granda
 */
public class Connect {

    public static Connection getConnection() {
		String mysqlUrl = "jdbc:mysql://localhost:3306/Institute";
		String mysqlUser = "redis";
		String mysqlPassword = "redis";
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
			System.out.println("Connect Mysql");
		} catch (SQLException ex) {
			System.out.println("No se pudo conectar a Mysql");
			System.out.println(ex.getMessage());
		}

		return connection;
	}

}
