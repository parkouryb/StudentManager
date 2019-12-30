package Object;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @Column(name="Bill_ID")
    private String Bill_ID;

    @Column(name="Student_ID")
    private String Student_ID;

    @Column(name="Bill_NAME")
    private String Bill_NAME;
    @Column(name="Room_money")
    private float Room_money;
    @Column(name="Water_money")
    private float Water_money;
    @Column(name="Total_money")
    private float Total_money;


//    @OneToOne
//    private Student student;

    public Bill() {

    }

    public Bill(String bill_ID, String student_ID,
                String bill_NAME,
                float room_money, float water_money, float total_money
                ) {
        Bill_ID = bill_ID;
        Student_ID = student_ID;
        Bill_NAME = bill_NAME;
        Room_money = room_money;
        Water_money = water_money;
        Total_money = total_money;
    }

    public String getBill_ID() {
        return Bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        Bill_ID = bill_ID;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getBill_NAME() {
        return Bill_NAME;
    }

    public void setBill_NAME(String bill_NAME) {
        Bill_NAME = bill_NAME;
    }

    public float getRoom_money() {
        return Room_money;
    }

    public void setRoom_money(float room_money) {
        Room_money = room_money;
    }

    public float getWater_money() {
        return Water_money;
    }

    public void setWater_money(float water_money) {
        Water_money = water_money;
    }

    public float getTotal_money() {
        return Total_money;
    }

    public void setTotal_money(float total_money) {
        Total_money = total_money;
    }

}
