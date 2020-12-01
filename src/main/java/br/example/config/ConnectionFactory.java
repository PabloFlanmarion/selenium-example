package br.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Pablo
 *
 */
public class ConnectionFactory {

	private static Connection connection = null;

	/**
	 * Construtor vazio privado.
	 */
	private ConnectionFactory() {

	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dbparametro";
		String user = "root";
		String pass = "";
		connection = DriverManager.getConnection(url, user, pass);

		return connection;
	}

}
