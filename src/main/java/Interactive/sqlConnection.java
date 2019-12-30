package Interactive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class sqlConnection {
	
	private static String db_name = "studentmanager";
	private static String user = "root";
	private static String password = "root";
	
	private static String connectionURL = "jdbc:mysql://localhost/" + db_name + "?serverTimezone=UTC";
	public static Connection getconnection()
	{
		try
		{
	        return DriverManager.getConnection(connectionURL, user, password);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	public static void closeConnection()
	{
		try {
			getconnection().close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public sqlConnection() {
		getconnection();
	}
	 
}
