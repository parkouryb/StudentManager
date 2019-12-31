package Object;

import java.util.Date;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @Column(name="Student_ID")
    private String Student_ID;

    @Column(name="Contract_ID")
    private String Contract_ID;

    @Column(name="Room_ID")
    private String Room_ID;

//    @ManyToOne
//    private Room room;
//
//    @ManyToOne
//    private Manager manager;
//
//    @OneToOne
//    private Bill bill;
//
//    @OneToOne
//    private Contract contract;


    @Column(name="Name")
    private String Name;
    @Column(name="Gender")
    private String Gender;
    @Column(name="Birthday")
    private Date Birthday;

    @Column(name="Hometown")
    private String Hometown;

    @Column(name="Course")
    private int Course;
    @Column(name="Faculty")
    private String Faculty;
    @Column(name="Educational_System")
    private String Educational_System;
    @Column(name="Phone_Number")
    private String Phone_Number;
    @Column(name="Status")
    private String Status;

    public Student() {

    }

    public Student(String student_ID, String contract_ID, String room_ID,
                   String name, String gender, Date birthday,
                   String hometown,
                   int course, String faculty, String educational_System, String phone_Number,
                   String status) {
        this.Student_ID = student_ID;
        this.Contract_ID = contract_ID;
        this.Room_ID = room_ID;
        this.Name = name;
        this.Gender = gender;
        this.Birthday = birthday;
        this.Hometown = hometown;
        this.Course = course;
        this.Faculty = faculty;
        this.Educational_System = educational_System;
        this.Phone_Number = phone_Number;
        this.Status = status;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getContract_ID() {
        return Contract_ID;
    }

    public void setContract_ID(String contract_ID) {
        Contract_ID = contract_ID;
    }

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String room_ID) {
        Room_ID = room_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getHometown() {
        return Hometown;
    }

    public void setHometown(String hometown) {
        Hometown = hometown;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        Course = course;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public String getEducational_System() {
        return Educational_System;
    }

    public void setEducational_System(String educational_System) {
        Educational_System = educational_System;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }
    
    public void setStatus(String status) {
		Status = status;
	}
    
    public String getStatus() {
		return Status;
	}

    public void setStatus(String status) {
		Status = status;
	}

    public String getStatus() {
		return Status;
	}

    @Override
    public String toString() {
        return "Student{" +
                "Student_ID='" + Student_ID + '\'' +
                ", Contract_ID='" + Contract_ID + '\'' +
                ", Room_ID='" + Room_ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Birthday=" + Birthday +
                ", Hometown='" + Hometown + '\'' +
                ", Course=" + Course +
                ", Faculty='" + Faculty + '\'' +
                ", Educational_System='" + Educational_System + '\'' +
                ", Phone_Number='" + Phone_Number + '\'' +
                '}';
    }
}
