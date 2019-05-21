package DButils;
import java.sql.*;

public class ConnectionDB {
	public static Connection fetchConnection() throws Exception{
		String url="jdbc:mysql://localhost:3306/mydb";
		return DriverManager.getConnection(url, "root","waviz");
	}

}
