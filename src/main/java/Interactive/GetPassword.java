package Interactive;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Interactive.sqlConnection;

public class GetPassword extends sqlConnection{
	static String get_login="Select * FROM ACCOUNT WHERE username=? and password=?";
	public static boolean getlogin(String ac,String pass)
	{
		
		boolean check = false;
		try {
			getconnection();		
			PreparedStatement sq = getconnection().prepareStatement(get_login);
			sq.setString(1, ac);
			sq.setString(2, pass);
			ResultSet re = sq.executeQuery();
			if(re != null && re.next())
			{
				check = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}
}
