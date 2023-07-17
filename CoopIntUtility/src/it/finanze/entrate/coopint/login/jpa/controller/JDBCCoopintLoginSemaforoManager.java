package it.finanze.entrate.coopint.login.jpa.controller;

import it.finanze.entrate.coopint.login.jpa.model.CoopintLoginSemaforo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCCoopintLoginSemaforoManager {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static void main(String[] argv) {

		try {
			String tableName = "COOPINT_LOGIN_SEMAFORO";
			getCoopintLoginSemaforo(tableName);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public static List<CoopintLoginSemaforo> getCoopintLoginSemaforo(String tableName) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		List<CoopintLoginSemaforo> results = new ArrayList<CoopintLoginSemaforo>();
		CoopintLoginSemaforo result;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("SELECT * FROM "+tableName+" m WHERE m.area is not null");

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery("SELECT * FROM "+tableName+" m WHERE m.area is not null");

			while (rs.next()) {
				result = new CoopintLoginSemaforo(); 
				result.setNomeEar(rs.getString("NOME_EAR"));
				result.setAreaApplicazione(rs.getString("AREA"));
				result.setSottoAreaApplicazione(rs.getString("SOTTO_AREA"));
				result.setNomeApplicazione(rs.getString("NOME_APPL"));
				result.setGruppoApplicazione(rs.getString("GRUPPO"));
				result.setSuperuserCf(rs.getString("SUPERUSER_CF"));
				result.setNote(rs.getString("NOTE"));
				result.setAbilitazione(rs.getString("ABILITAZIONE"));
				result.setUrl(rs.getString("URL"));
				result.setProfili(rs.getString("PROFILI"));
				results.add(result);			
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return results;

	}
	
	public static List<CoopintLoginSemaforo> getCoopintLoginSemaforo(String tableName, String earName) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		List<CoopintLoginSemaforo> results = new ArrayList<CoopintLoginSemaforo>();
		CoopintLoginSemaforo result;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("SELECT * FROM "+tableName+" m WHERE m.area is not null AND m.nome_ear = '"+earName+"'");

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery("SELECT * FROM "+tableName+" m WHERE m.area is not null AND m.nome_ear = '"+earName+"'");

			while (rs.next()) {
				result = new CoopintLoginSemaforo(); 
				result.setNomeEar(rs.getString("NOME_EAR"));
				result.setAreaApplicazione(rs.getString("AREA"));
				result.setSottoAreaApplicazione(rs.getString("SOTTO_AREA"));
				result.setNomeApplicazione(rs.getString("NOME_APPL"));
				result.setGruppoApplicazione(rs.getString("GRUPPO"));
				result.setSuperuserCf(rs.getString("SUPERUSER_CF"));
				result.setNote(rs.getString("NOTE"));
				result.setAbilitazione(rs.getString("ABILITAZIONE"));
				result.setUrl(rs.getString("URL"));
				result.setProfili(rs.getString("PROFILI"));
				results.add(result);			
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return results;

	}
	
	public static List<CoopintLoginSemaforo> getCoopintEar(String earName) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		String tableName = "COOPINT_EAR";
		List<CoopintLoginSemaforo> results = new ArrayList<CoopintLoginSemaforo>();
		CoopintLoginSemaforo result;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery("SELECT * FROM "+tableName+" m WHERE m.area is not null AND m.nome_ear = '"+earName+"'");

			while (rs.next()) {
				result = new CoopintLoginSemaforo(); 
				result.setNomeEar(rs.getString("NOME_EAR"));
				result.setAreaApplicazione(rs.getString("AREA"));
				result.setSottoAreaApplicazione(rs.getString("SOTTO_AREA"));
				result.setNomeApplicazione(rs.getString("NOME_APPL"));
				result.setGruppoApplicazione(rs.getString("GRUPPO"));
				result.setSuperuserCf(rs.getString("SUPERUSER_CF"));
				result.setNote(rs.getString("NOTE"));
				result.setAbilitazione(rs.getString("ABILITAZIONE"));
				result.setUrl(rs.getString("URL"));
				result.setProfili(rs.getString("PROFILI"));
				results.add(result);			
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return results;

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("jdbc/coopintLogin");


			//dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			dbConnection = ds.getConnection();
			
			
			return dbConnection;

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}