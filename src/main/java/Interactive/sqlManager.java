package Interactive;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class sqlManager {
	public sqlManager() {
		
	}
	
	public boolean idExited(String id) {
		boolean check = false;
		List<String> idList = new ArrayList<String>();
		String id1 = null;
		ResultSet rs = null;
		String sqlCommand = "SELECT Manager_ID FROM manager " ;
		Statement pst;
		try {
			pst = sqlConnection.getconnection().createStatement();
			rs = pst.executeQuery(sqlCommand);
			while (rs.next()) {
				id1 = rs.getString(1);
				idList.add(id1);
			}
		} catch (SQLException ex) {
			System.out.println("search err " + ex.toString());
		}
		for(String idString : idList) {
			if(idString.equals(id)) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public boolean userExited(String user) {
		boolean check = false;
		List<String> listUser = new ArrayList<String>();
		String user1 = null;
		ResultSet rs = null;
		String sqlCommand = "select username from account";
		Statement pst;
		try {
			pst = sqlConnection.getconnection().createStatement();
			rs = pst.executeQuery(sqlCommand);
			while(rs.next()) {
				user1 = rs.getString(1);
				listUser.add(user1);
			}
			//System.out.println(listUser);
		} catch (SQLException ex) {
			System.out.println("search err " + ex.toString());
		}
		for(String us : listUser) {
			if(us.equals(user)) {
				check = true;
				break;
			}
		}
		return check;
	}
}
