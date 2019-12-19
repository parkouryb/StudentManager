package Main;

import java.util.Date;
import java.util.*;
import java.io.*;

import Interactive.*;
import Object.*;
import com.jcg.hibernate.maven.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {

    static SessionFactory sessionFactoryObj;
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        StudentIT studentIT = new StudentIT();
//        String student_ID, String contract_ID, String room_ID,
//                String name, String gender, Date birthday,
//                String hometown,
//        int course, String faculty, String educational_System, String phone_Number
//        studentIT.addStudent("18001132", "1231", "513",
//                "Ha Trung Hieu", "Male", new Date(),
//                "Yen Bai",
//                2018, "abc", "xyz", "0915866167");
//        studentIT.addStudent("18001133", "1231", "513",
//                "Trung Hieu", "feMale", new Date(),
//                "Yen Bai",
//                2018, "abc", "xyz", "0915866167");
        studentIT.deleteStudent("18001132");
        List <Student> lists = studentIT.searchStudentbyName("Ha Trung Hieu");
        if (lists != null) {
            for (Student std : lists) {
                System.out.println(std.toString());
            }
        }
        else System.out.println("nothing");

    }
}

//    public static void addUser(int userid, String userName, String createdBy, Date createdDate){
//        Session sessionObj = sessionFactoryObj.openSession();
//        Transaction transaction = null;
//
//        try {
//            transaction = sessionObj.beginTransaction();
//
//            User newUser = new User(userid, userName, createdBy, createdDate);
//            sessionObj.save(newUser);
//
//            transaction.commit();
//
//        } catch(HibernateException hibernateExeption) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.print("This id : " + userid + " already exist!\n");
////            hibernateExeption.printStackTrace();
//        } finally {
//            sessionObj.close();
//        }
//    }
//
//    public static void addAdmin(int admin_id, String admin_name, Date created_date){
//        Session sessionObj = sessionFactoryObj.openSession();
//        Transaction transaction = null;
//
//        try {
//            transaction = sessionObj.beginTransaction();
//
//            Admin newAdmin = new Admin(admin_id, admin_name, created_date) ;
//            sessionObj.save(newAdmin);
//
//            transaction.commit();
//
//        } catch(HibernateException hibernateExeption) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.print("This id : " + admin_id + " already exist!\n");
////            hibernateExeption.printStackTrace();
//        } finally {
//            sessionObj.close();
//        }
//    }
//
//    public static void listUser(){
//        Session sessionObj = sessionFactoryObj.openSession();
//        try {
//
//            List users = sessionObj.createQuery("FROM User").list();
//            for (Iterator iterator = users.iterator(); iterator.hasNext();) {
//                User user = (User) iterator.next();
//                System.out.println(user.toString());
//            }
//
//        } catch(HibernateException hibernateExeption) {
//            System.out.println("error\n");
//            hibernateExeption.printStackTrace();
//        } finally {
//            sessionObj.close();
//        }
//    }


