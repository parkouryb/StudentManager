package Interactive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Object.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

public class ManagerIT {
    static SessionFactory sessionFactoryObj;

    public boolean idExited(String id) {
		boolean check = false;
		List<String> idList = new ArrayList<String>();
		String id1 = null;
		ResultSet rs = null;
		String sqlCommand = "SELECT Manager_ID FROM manager " ;
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
	
	public boolean userExited(String user) {
		boolean check = false;
		List<String> listUser = new ArrayList<String>();
		String user1 = null;
		ResultSet rs = null;
		String sqlCommand = "select username from account";
		Statement pst;
		try {
			pst = sqlConnection.getconnection().createStatement();
			rs = pst.executeQuery(sqlCommand);
			while(rs.next()) {
				user1 = rs.getString(1);
				listUser.add(user1);
			}
			//System.out.println(listUser);
		} catch (SQLException ex) {
			System.out.println("search err " + ex.toString());
		}
		for(String us : listUser) {
			if(us.equals(user)) {
				check = true;
				break;
			}
		}
		return check;
	}
	
    public void addManager(Manager manager) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            sessionObj.save(manager);

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

    public void deleteManager(String manager_ID)  {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Manager manager = (Manager) sessionObj.get(Manager.class.getName(), manager_ID);

            sessionObj.flush();
            sessionObj.delete(manager);
            sessionObj.flush();
            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("error");
        } catch(NullPointerException np) {
            System.out.println("not exist manager to delete!");
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }
    
    public ResultSet searchManager() {
		ResultSet rs = null;
		String sqlCommand = "SELECT Manager_ID, Name, Gender, Position FROM manager";
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
    
    public ResultSet searchManager(String mngName) {
		ResultSet rs = null;
		String sqlCommand = "SELECT Manager_ID, Name, Gender, Position FROM manager WHERE Name LIKE '%" 
										+ mngName +"%'";
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
