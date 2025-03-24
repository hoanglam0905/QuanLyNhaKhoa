package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c= null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url="jdbc:mySQL://localhost:3306/phongkhamnhakhoa";
			String usernsme="root";
			String password="lam123";
			
			c=DriverManager.getConnection(url, usernsme, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	public static void closeConnection(Connection c ){
		
	}
}
