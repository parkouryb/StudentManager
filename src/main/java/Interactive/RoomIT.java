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
    
    public List<Room> getAllRoom(List<String> idList){
    	int number;
    	Room room = new Room();
    	List<Room> rooms = new ArrayList<Room>();
    	for(int i = 0 ;i<idList.size() ; i++) {
    		room = searchRoom(idList.get(i));
    		number = room.getNumber();
    		room.setNumber(number - 1);
    		rooms.add(room);
    	}
    	return rooms;
    }
    
    public List<String> getListRoom(){
    	List<String> idrooms = new ArrayList<String>();
    	String id = null;
    	String sqlString = "SELECT Room_ID FROM room";
    	ResultSet rs = null;
    	Statement statement;
    	try {
			statement = sqlConnection.getconnection().createStatement();
			rs = statement.executeQuery(sqlString);
			while(rs.next()) {
				id = rs.getString(1);
				idrooms.add(id);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	return idrooms;
    }
    
    public List<Room> getBlankRoom(List<String> idrooms){
    	//find how many people in a room which id = roomID
    		List<String> idList = new ArrayList<String>();
    		String id1 = null;
    		ResultSet rs = null;
    		String sqlCommand = "SELECT Room_ID FROM student ";							
    		Statement st;
    		try {
    			st = sqlConnection.getconnection().createStatement();
    			rs = st.executeQuery(sqlCommand);
    			while (rs.next()) {
    				id1 = rs.getString(1);
    				idList.add(id1);
    			}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	
    	//find blank rooms		
    	List<Room> BlankRooms = new ArrayList<Room>(); 
    	int slot; 
    	Room blankRoom = new Room();
    	String room_id;
    	boolean check;
    	for(int i = 0 ; i<idrooms.size() ; i++) {
    		room_id = idrooms.get(i);
    		check = fullOfRoom(room_id);
    		if(check == false) {
    			int number = 0;
    			for(int j = 0 ; j < idList.size() ; j++) {
    				if(idList.get(j).equals(room_id)) number++;
    			}
    			blankRoom = searchRoom(room_id);
    			slot = blankRoom.getNumber();
    			blankRoom.setNumber(slot - number);
    			BlankRooms.add(blankRoom);
    		}
    	}
    	if(BlankRooms.size() == 0) return null;
    	else return BlankRooms;
    }
    
    public List<Room> genderBlankRooms (List<Room> blankRooms, String genderString){
    	List<Room> genderRooms = new ArrayList<Room>();
    	for(int i = 0 ; i<blankRooms.size() ; i++) {
    		if(blankRooms.get(i).getType_room().equals(genderString)) {
    			genderRooms.add(blankRooms.get(i));
    		}
    	}
    	if(genderRooms.size() == 0) return null;
    	else return genderRooms;
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
    	
    	try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    	
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
