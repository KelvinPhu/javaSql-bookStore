package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class bookStore {
	public static Connection createConnection() {
		Connection c = null;
		
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			
			String url = "jdbc:sqlserver://THIEN-PHU:1433;databaseName=bookStore;encrypt=false";
			String user = "sa";
			String password = "123456789Thien_Phu";
			
			try {
				c= DriverManager.getConnection(url, user, password);
				System.out.println("connected");
			} catch (SQLException e) {
				System.out.println("Fail to connected");
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnecion (Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
