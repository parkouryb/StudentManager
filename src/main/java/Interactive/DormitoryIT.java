package Interactive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Object.Dormitory;

import java.util.ArrayList;
import java.util.List;

public class DormitoryIT {
    static SessionFactory sessionFactoryObj;
    public void addDorm(String dorm_name, String location, String phone_number) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Dormitory dormitory = new Dormitory(dorm_name, location, phone_number);
            sessionObj.save(dormitory);

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

    public Dormitory searchDorm(String dorm_name) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Dormitory dorm = null;
        try {
            dorm = (Dormitory) sessionObj.get(Dormitory.class.getName(), dorm_name);

        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
        }finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
        return dorm;
    }
}
