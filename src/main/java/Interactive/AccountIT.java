package Interactive;

import javax.imageio.IIOException;
import Object.Account;
import com.jcg.hibernate.maven.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountIT {

    static SessionFactory sessionFactoryObj;

    /**
     * Registration account with username and password
     * @param username
     * @param password
     * @param re_password
     */
    public void Registration(String username, String password, String re_password) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();
            if (password.compareTo(re_password) == 0) {
                Date creation_date = new Date();
                Account new_user = new Account(username, password, creation_date);

                sessionObj.save(new_user);
            }
            else {
                System.out.println("Registion incomplete!");
            }
            transaction.commit();
        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.print("This username : " + username + " already exist!\n");
            System.out.println("Registion incomplete!");
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }

        System.out.println("Registion completed!");
    }

    /**
     * List all accounts in the database
     */
    public void listAccount() {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        try {
            List accounts = sessionObj.createQuery("FROM Account").list();
            for (Iterator iterator = accounts.iterator(); iterator.hasNext();) {
                Account account = (Account) iterator.next();
                System.out.println(account.toString());
            }
        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
            hibernateExeption.printStackTrace();
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }

    /**
     * Login with username and password
     * @param username
     * @param password
     */
    public void Login(String username, String password) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Account account = (Account) sessionObj.get(Account.class, username);

            if (username.compareTo(account.getUsername()) == 0 &&
                password.compareTo(account.getPassword()) == 0) {
                System.out.println("Login ok");
            }
            else {
                System.out.println("wrong Username or Password");
            }
        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }

    }

    /**
     * change Password
     * @param username
     * @param old_password
     * @param new_password
     * @param re_new_password
     */
    public void changePassword(String username, String old_password, String new_password, String re_new_password) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Account account = (Account) sessionObj.get(Account.class.getName(), username);

            if (username.compareTo(account.getUsername()) == 0 &&
                old_password.compareTo(account.getPassword()) == 0) {

                if (new_password.compareTo(re_new_password) == 0) {
                    account.setPassword(new_password);
                }
                else {
                    System.out.println("re_new_password not the same with new_password");
                }
            }
            else {
                System.out.println("wrong Username or Password");
            }

            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("error");
        } catch(NullPointerException np) {
             System.out.println("not exist!");
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }

    /**
     * delete Account in the database
     * @param username
     */
    public void deleteAccount(String username) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Account account = (Account) sessionObj.get(Account.class.getName(), username);
            System.out.println(account.toString());
            sessionObj.flush();
            sessionObj.delete(account);
            sessionObj.flush();
            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("error");
        } catch(NullPointerException np) {
            System.out.println("not exist account to delete!");
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }
}
