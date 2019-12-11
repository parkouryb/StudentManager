package Object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "student_id")
    private int student_id;

    @Column(name = "room")
    private String room;

    @Column(name = "building")
    private String building;

    @Column(name = "rent")
    private double rent;

    @Column(name = "status")
    private boolean status;

    public Student() {

    }

    public Student(int student_id, String room, String building, double rent, boolean status) {
        this.student_id = student_id;
        this.room = room;
        this.building = building;
        this.rent = rent;
        this.status = status;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
