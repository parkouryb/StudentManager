package Object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Manager")
public class Manager {
    @Id
    @Column(name = "Manager_ID")
    private String Manager_ID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Birthday")
    private Date Birthday;
    @Column(name = "Gender")
    private String Gender;
    @Column(name = "Position")
    private String Position;

//    @ManyToOne
//    private Dormitory dorm;
//
//    @OneToMany
//    private List<Student> students = new ArrayList<Student>();

    public Manager() {

    }

    public Manager(String manager_ID, String name, Date birthday, String gender, String position) {
        Manager_ID = manager_ID;
        Name = name;
        Birthday = birthday;
        Gender = gender;
        Position = position;
    }

    public String getManager_ID() {
        return Manager_ID;
    }

    public void setManager_ID(String manager_ID) {
        Manager_ID = manager_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "Manager_ID='" + Manager_ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Birthday=" + Birthday +
                ", Gender='" + Gender + '\'' +
                ", Position='" + Position + '\'' +
                '}';
    }
}
