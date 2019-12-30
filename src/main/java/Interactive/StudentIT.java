package Interactive;

import Object.Manager;
import Object.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;

public class StudentIT {

    static SessionFactory sessionFactoryObj;

    /**
     * Add a student to the database
     * @param student_ID
     * @param contract_ID
     * @param room_ID
     * @param name
     * @param gender
     * @param birthday
     * @param hometown
     * @param course
     * @param faculty
     * @param educational_System
     * @param phone_Number
     */
    
    public static void addManager(Manager mg) {
    	String sqlString = "INSERT INTO manager(Manager_ID, Birthday, Gender, Name, Position) VALUES(?,?,?,?,?)";
    	try {
    		PreparedStatement ps =	sqlConnection.getconnection().prepareStatement(sqlString);
			ps.setString(1, mg.getManager_ID());
			java.sql.Date cal = new java.sql.Date (mg.getBirthday().getTime()) ;
			ps.setDate(2, cal);
			ps.setString(3, mg.getGender());
			ps.setString(4, mg.getName());
			ps.setString(5, mg.getPosition());

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
    public static void addStudent(Student std) {
    	String sqlString = "INSERT INTO student(Student_ID, Name, Gender, Birthday, Educational_System,"
    			+ "Faculty, Hometown,Phone_Number, Room_ID, Contract_ID, Course, Status)"
    						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    	try {
    		PreparedStatement ps =	sqlConnection.getconnection().prepareStatement(sqlString);
    		ps.setString(1, std.getStudent_ID());
    		ps.setString(2, std.getName());
    		ps.setString(3, std.getGender());
    		java.sql.Date cal = new java.sql.Date (std.getBirthday().getTime()) ;
			ps.setDate(4, cal);
			ps.setString(5, std.getEducational_System());
			ps.setString(6, std.getFaculty());
			ps.setString(7, std.getHometown());
			ps.setString(8, std.getPhone_Number());
			ps.setString(9, std.getRoom_ID());
			ps.setString(10, std.getContract_ID());
			ps.setInt(11, std.getCourse());
			ps.setString(12, std.getStatus());
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    /**
     * Find all students have name = name
     * @param name
     * @return List of student could found
     */
    public List<Student> searchStudentbyName(String name) {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        List<Student> res = new ArrayList<Student>();

        try {
            List<Student> lists = sessionObj.createCriteria(Student.class).list();

            for (Student std : lists) {
                if (std.getName().compareTo(name) == 0) {
//                    System.out.println(std.toString());
                    res.add(std);
                }
            }

        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
        if (res.size() > 0) return res;
        else return null;
    }

    /**
     * delete a Student in the database search by student_ID
     * @param student_ID
     */
    public void deleteStudent(String student_ID){
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Student student = (Student) sessionObj.get(Student.class.getName(), student_ID);
//            System.out.println(account.toString());
            sessionObj.flush();
            sessionObj.delete(student);
            sessionObj.flush();
            transaction.commit();

        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("error");
        } catch(NullPointerException np) {
            System.out.println("not exist student to delete!");
        } finally {
            sessionObj.close();
        }

        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }
}
