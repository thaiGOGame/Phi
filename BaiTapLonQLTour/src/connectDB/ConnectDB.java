package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTOUR;encrypt=false; user=sa;password=thaigo3007";
		con = DriverManager.getConnection(url);	 
	}
	public void disconnect() {
		if (con!=null) 
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		return con;
	}
}
