package Interactive;

import java.util.Date;
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
