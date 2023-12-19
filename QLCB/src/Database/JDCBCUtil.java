package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDCBCUtil {
	public static Connection getConnection() {
		Connection c= null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url= "jdbc:mySQL://127.0.0.1:3306/test";
			String usreName="root";
			String passWord="";
			
			c= DriverManager.getConnection(url, usreName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				java.sql.DatabaseMetaData mtdt= c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
