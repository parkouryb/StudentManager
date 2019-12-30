package Interactive;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.kerberos.KerberosCredMessage;

import Object.Contract;

public class sqlStudent {
	public sqlStudent() {
		
	}
	
	public boolean idstudentExited(String id) {
		boolean check = false;
		List<String> idList = new ArrayList<String>();
		String id1 = null;
		ResultSet rs = null;
		String sqlCommand = "SELECT Student_ID FROM student " ;
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
	
	public boolean contractExited(String contractID) {
		boolean check = false;
		List<String> idList = new ArrayList<String>();
		String id1 = null;
		ResultSet rs = null;
		String sqlCommand = "SELECT Contract_ID FROM contract " ;
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
			if(idString.equals(contractID)) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	public boolean fullOfRoom(String roomID) {
		boolean check = false;
		
		//find how many people in a room which id = roomID
		List<String> idList = new ArrayList<String>();
		String id1 = null;
		int number1 = 0;
		ResultSet rs1 = null;
		String sqlCommand1 = "SELECT Room_ID FROM student ";							
		Statement pst1;
		
		//find max people per room which id = roomID
		int k = 0;
		int number = 0;
		String id = null;
		int number2 = 0;
		List<String> idList2 = new ArrayList<String>();
		List<Integer> idList3 = new ArrayList<Integer>();
		ResultSet rs2 = null;
		String sqlCommand2 = "SELECT Room_ID, Number FROM room" ;
		Statement pst2;
		try {
			pst1 = sqlConnection.getconnection().createStatement();
			rs1 = pst1.executeQuery(sqlCommand1);
			while (rs1.next()) {
				id1 = rs1.getString(1);
				idList.add(id1);
			}
			for(int i = 0 ; i < idList.size() ; i++) {
				if(idList.get(i).equals(roomID)) number1++;
			}
			
			pst2 = sqlConnection.getconnection().createStatement();
			rs2 = pst2.executeQuery(sqlCommand2);
			while(rs2.next()) {
				id = rs2.getString(1);
				idList2.add(id);
				number = rs2.getInt(2);
				idList3.add(number);
			}
			for(int i = 0 ; i < idList2.size() ; i++) {
				if(idList2.get(i).equals(roomID)) k=i;
			}
			number2 = idList3.get(k);
		} 
		catch (SQLException ex) {
			System.out.println("search err " + ex.toString());
		}
		
		if(number1 == number2) {
			check = true;
		}
		return check;
	}
	
	public boolean courseEx(String courseString) {
		try{
            Integer.parseInt(courseString);
            return true;
              
        }
		catch(StringIndexOutOfBoundsException e){
            System.out.println("ERR: Ban quen chua nhap!");
            return false;
        }
        catch(NumberFormatException e){
            System.out.println("ERR: Sai kieu!");
            return false;
        }
	}
	
	public static void addContract(Contract contract) {
		String sqlString = "INSERT INTO contract(Contract_ID,Day_in,Day_out) VALUES(?,?,?)";
		try {
			PreparedStatement ps =	sqlConnection.getconnection().prepareStatement(sqlString);
			ps.setString(1, contract.getContract_ID());
			java.sql.Date cal = new java.sql.Date (contract.getDay_in().getTime()) ;
			ps.setDate(2, cal);
			java.sql.Date cal1 = new java.sql.Date (contract.getDay_out().getTime()) ;
			ps.setDate(3, cal1);
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
