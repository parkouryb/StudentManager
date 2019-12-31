package Interactive;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlMoney {
	public sqlMoney() {
		
	}
	
	public ResultSet getNoMoneyStudent(String status) {
		ResultSet rs = null;
		String sqlCommand = "SELECT Student_ID,Name,Room_ID,Phone_Number FROM student WHERE status LIKE '%"
				+ status + "%'";
		PreparedStatement pst;
		try {
			pst = sqlConnection.getconnection()
					.prepareStatement(sqlCommand,
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs = pst.executeQuery();
		} catch (SQLException ex) {
			System.out.println("search err " + ex.toString());
		}
		return rs;
	}
	
}
