package Interactive;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Object.Contract;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ContractIT {
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
	
	public void addContract(Contract contract) {
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
	
    public void addContract(String contract_ID, Date day_in, Date day_out) {

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Contract contract = new Contract(contract_ID, day_in, day_out);
            sessionObj.save(contract);

            transaction.commit();
        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
        } finally {
            sessionObj.close();
        }

    }

    public void deleteContract(String contract_ID) {

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Contract contract = (Contract) sessionObj.get(Contract.class.getName(), contract_ID);
            sessionObj.flush();
            sessionObj.delete(contract);
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

    public Contract searchContract(String contract_ID) {

        Session sessionObj = sessionFactoryObj.openSession();
        Contract contract = null;
        try {
            contract = (Contract) sessionObj.get(Contract.class.getName(), contract_ID);

        } catch(HibernateException hibernateExeption) {
            System.out.println("error\n");
        }finally {
            sessionObj.close();
        }

        return contract;

    }
}
