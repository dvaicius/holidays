import java.sql.*;

public class HolidaysDbConnection {
	static String dbDriver = "";
	static String dbType = "sqlserver";
	static String dbHost = "localhost";
	static String dbPort = "1433"; 			// Standard MS SQL Port
	static String dbUser = "sa";
	static String dbPass = "darius";
	static String dbName = "test";
	
	private String getConnectionString() {
		final String connString = "jdbc:" + dbType + "://" + dbHost + ":" + dbPort + ";" + "databasename=" + dbName;
		
		return connString;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			// Class.forName(dbDriver);
			conn = DriverManager.getConnection(this.getConnectionString(), dbUser, dbPass);
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ResultSet execSelect(String sql) {
		ResultSet result = null;
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void getUsers() {
		System.out.println("Printing all users from DB");
		try {
			Connection conn = this.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [Users]");
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getInt("Id") + ": " + res.getString("Name") + " " + res.getString("Surname") + ", " + res.getString("Address"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getUsers(Integer userId) {
		System.out.println("Printing user with Id: " + userId + " from DB");
		try {
			Connection conn = this.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [Users] WHERE Id = ?");
			stmt.setInt(1, userId);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getInt("Id") + " " + res.getString("Name") + " " + res.getString("Surname") + " " + res.getString("Address"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getPublicHolidays() {
		System.out.println("Printing public holidays from DB");
		try {
			Connection conn = this.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [PublicHolidays]");
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				System.out.println(res.getInt("Id") + ": " + res.getDate("HolidayDate") + " - " + res.getString("HolidayTitle") + ", Permanent: " + res.getBoolean("PermanentHoliday") + ", Country Id: " + res.getInt("CountryId") + ", State Id: " + res.getInt("StateId"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
