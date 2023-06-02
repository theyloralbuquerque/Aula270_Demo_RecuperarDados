package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
	
	public static void main(String[] args) {

		Connection conn = null; // Criação da variável conn do tipo Connection.
		Statement st = null; // Criação da variável st do tipo Statement.
		ResultSet rs = null; // Criação da variável rs do tipo ResultSet.
		try {
			conn = DB.getConnection(); // .getConnection() conecta com o BD.

			st = conn.createStatement(); // createStatement() instancia um objeto do tipo Statement a partir de um objeto Connection.

			rs = st.executeQuery("select * from department"); // executeQuery() executa uma instrução SQL de consulta no BD, recebe um selecto como arg.

			// A partir daqui rs terá o resultado do select armazenado.
			
			while (rs.next()) { // Enquanto next() for true. next() chama a próxima linha da consulta.
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); // .get+tipodacoluna() retorna a coluna que estiver dentro dos parênteses.
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}