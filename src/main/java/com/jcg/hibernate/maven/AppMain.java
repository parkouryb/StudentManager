package com.jcg.hibernate.maven;

import java.util.Date;
import java.util.*;
import java.io.*;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {

    static SessionFactory sessionFactoryObj;

    public static void addUser(int userid, String userName, String createdBy, Date createdDate){
        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            User newUser = new User(userid, userName, createdBy, createdDate);
            sessionObj.save(newUser);

            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.print("This id : " + userid + " already exist!\n");
//            hibernateExeption.printStackTrace();
        } finally {
            sessionObj.close();
        }
    }

    public static void addAdmin(int admin_id, String admin_name, Date created_date){
        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Admin newAdmin = new Admin(admin_id, admin_name, created_date) ;
            sessionObj.save(newAdmin);

            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.print("This id : " + admin_id + " already exist!\n");
//            hibernateExeption.printStackTrace();
        } finally {
            sessionObj.close();
        }
    }

    public static void listUser(){
        Session sessionObj = sessionFactoryObj.openSession();
        try {

            List users = sessionObj.createQuery("FROM User").list();
            for (Iterator iterator = users.iterator(); iterator.hasNext();) {
                User user = (User) iterator.next();
                System.out.println(user.toString());
            }

        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
            hibernateExeption.printStackTrace();
        } finally {
            sessionObj.close();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        addUser(101, "Editor 101", "Admin", new Date());
        addUser(102, "Editor 102", "Admin", new Date());

        addAdmin(1, "Hieu", new Date());
        addAdmin(2, "Hieu", new Date());
        addAdmin(3, "Link", new Date());
        addAdmin(2, "Dang", new Date());

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
            System.out.println("SessionFactory is closed!");
        }

//        listUser();
    }
}

