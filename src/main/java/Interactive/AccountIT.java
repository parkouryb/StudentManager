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

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountIT {

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

    /**
     * Registration account with username and password
     * @param username
     * @param password
     * @param re_password
     */
    public void Registration(String username, String password, String re_password) {

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;
        boolean flag = true;

        try {
            transaction = sessionObj.beginTransaction();
            if (password.compareTo(re_password) == 0) {

                Account new_user = new Account(username, password);

                sessionObj.save(new_user);

            }

            transaction.commit();
        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.print("This username : " + username + " already exist!\n");
            flag = false;
        } finally {
            sessionObj.close();
        }
        if (flag) System.out.println("Registion completed!");
        else System.out.println("Registion incomplete!");
    }

    public void addAccount(Account acc) {
    	String sqlString = "INSERT INTO account(username, password) VALUES(?,?)";
    	try {
    		PreparedStatement ps =	sqlConnection.getconnection().prepareStatement(sqlString);
    		ps.setString(1, acc.getUsername());
    		ps.setString(2, acc.getPassword());
    		ps.executeUpdate();
		} 
    	catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
    }


    /**
     * List all accounts in the database
     */
    public void listAccount() {

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

    }

    /**
     * Login with username and password
     * @param username
     * @param password
     */
    public boolean Login(String username, String password) {
    	boolean check = false;
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
            	check = true;
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
        return check;
    }

    /**
     * change Password
     * @param username
     * @param old_password
     * @param new_password
     * @param re_new_password
     */
    public void changePassword(String username, String old_password, String new_password, String re_new_password) {

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
                    System.out.println("hieu dep trai");
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

    }

    /**
     * delete Account in the database
     * @param username
     */
    public void deleteAccount(String username) {
        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Account account = (Account) sessionObj.get(Account.class.getName(), username);

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

    }
}
