package Interactive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import Object.Room;

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

    public void addRoom(String room_ID, String type_room, float room_money, int Number) {

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Room room = new Room(room_ID, type_room, room_money, Number);
            sessionObj.save(room);

            transaction.commit();
        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
        } finally {
            sessionObj.close();
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
