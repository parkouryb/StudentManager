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

    public void openSSF() {
        try {
            sessionFactoryObj = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
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

    public void closeSSF() {
        if (sessionFactoryObj != null) {
            sessionFactoryObj.close();
        }
    }

    public void addStudent_hbn(Student new_student) {

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            sessionObj.save(new_student);

            transaction.commit();
        } catch(HibernateException hibernateExeption) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.print("This student id : " + new_student.getStudent_ID() + " already exist!\n");
            System.out.println("Add a student fail!");
        } finally {
            sessionObj.close();
        }


    }

    /**
     * Find all students have name = name
     * @param name
     * @return List of student could found
     */
    public List<Student> searchStudentbyName(String name) {

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

        if (res.size() > 0) return res;
        else return null;
    }

    public Student searchStudentbyID(String StudentID) {

        Session sessionObj = sessionFactoryObj.openSession();
        Student res = new Student();

        try {
            List<Student> lists = sessionObj.createCriteria(Student.class).list();

            for (Student std : lists) {
                if (std.getStudent_ID().compareTo(StudentID) == 0) {
//                    System.out.println(std.toString());
                    res = std;
                    break;
                }
            }

        } finally {
            sessionObj.close();
        }

        return res;
    }

    /**
     * delete a Student in the database search by student_ID
     * @param student_ID
     */
    public void deleteStudent(String student_ID){

        Session sessionObj = sessionFactoryObj.openSession();
        Transaction transaction = null;

        try {
            transaction = sessionObj.beginTransaction();

            Student student = (Student) sessionObj.get(Student.class.getName(), student_ID);

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

    }

}
