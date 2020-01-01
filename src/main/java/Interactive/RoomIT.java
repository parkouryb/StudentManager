package Interactive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Object.Room;
import org.hibernate.SessionFactory;

public class RoomIT {
    static SessionFactory sessionFactoryObj;

    public void openSSF() {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    public void closeSSF() {
        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }
    
    public ResultSet getBlankRoom() {
		ResultSet rs = null;
		String sqlCommand = "SELECT room.Room_ID, room.Room_money, room.Type_room , "
									+ "COUNT(student.Room_ID), room.Number"
						   +"FROM student,room" 
				           +"WHERE room.Room_ID = student.Room_ID "
				                  + "AND room.Number > "
				                             + "(SELECT COUNT(student.Room_ID) FROM student, room"
				                             +   "WHERE room.Room_ID = student.Room_ID)"
                           +"GROUP BY student.Room_ID";
				
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
    
    public void addRoom(Room room) {
    	try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            sessionObj.save(room);

            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
        } catch(NullPointerException np) {
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }

    public void deleteRoom(String room_ID) {

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Room room = (Room) sessionObj.get(Room.class.getName(), room_ID);
            sessionObj.flush();
            sessionObj.delete(room);
            sessionObj.flush();
            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("error");
        } catch(NullPointerException np) {
            // to do
        } finally {
            sessionObj.close();
        }

    }
    
    public boolean idRoomExited(String id) {
    	boolean check = false;
    	String sqlString = "SELECT Room_ID FROM room";
    	List<String> idList = new ArrayList<String>();
    	String id1 = null;
    	Statement statement;
    	ResultSet rs = null;
    	
    	try {
    		statement = sqlConnection.getconnection().createStatement();
    		rs = statement.executeQuery(sqlString);
    		while(rs.next()) {
    			id1 = rs.getString(1);
    			idList.add(id1);
    		}
		} 
    	catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	for(String idString : idList) {
    		if(idString.equals(id)) {
    			check = true;
    			break;
    		}
    	}
    	return check;
    }
    
    public Room searchRoom(String room_ID) {

        Session sessionObj = sessionFactoryObj.openSession();
        Room room = null;
        try {
            room = (Room) sessionObj.get(Room.class.getName(), room_ID);

        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
        }finally {
            sessionObj.close();
        }

        return room;

    }
}
