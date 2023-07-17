package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnnection {

		public static Connection CreateConnection() {
			Connection conn =null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return conn;
		}
}
