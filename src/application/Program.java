package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
	
	public static void main(String[] args) {

		Connection conn = null; // Cria��o da vari�vel conn do tipo Connection.
		Statement st = null; // Cria��o da vari�vel st do tipo Statement.
		ResultSet rs = null; // Cria��o da vari�vel rs do tipo ResultSet.
		try {
			conn = DB.getConnection(); // .getConnection() conecta com o BD.

			st = conn.createStatement(); // createStatement() instancia um objeto do tipo Statement a partir de um objeto Connection.

			rs = st.executeQuery("select * from department"); // executeQuery() executa uma instru��o SQL de consulta no BD, recebe um selecto como arg.

			// A partir daqui rs ter� o resultado do select armazenado.
			
			while (rs.next()) { // Enquanto next() for true. next() chama a pr�xima linha da consulta.
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); // .get+tipodacoluna() retorna a coluna que estiver dentro dos par�nteses.
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