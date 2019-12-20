package Object;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Dormitory")
public class Dormitory {
    @Id
    @Column(name = "Dorm_name")
    private String Dorm_name;
    @Column(name = "Location")
    private String Location;
    @Column(name = "Phone_number")
    private String Phone_number;

    @OneToMany
    private List<Room> rooms = new ArrayList<Room>();

    @OneToMany
    private List<Manager> managers = new ArrayList<Manager>();


    public Dormitory() {

    }

    public Dormitory(String dorm_name, String location, String phone_number) {
        Dorm_name = dorm_name;
        Location = location;
        Phone_number = phone_number;
    }

    public String getDorm_name() {
        return Dorm_name;
    }

    public void setDorm_name(String dorm_name) {
        Dorm_name = dorm_name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }
}
