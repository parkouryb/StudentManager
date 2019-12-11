package Object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Information")
public class Information {
    @Id
    @Column(name = "student_id")
    private int student_id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "class")
    private String _class;

    @Column(name = "school")
    private String school;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "day_in")
    private Date day_in;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDay_in() {
        return day_in;
    }

    public void setDay_in(Date day_in) {
        this.day_in = day_in;
    }

    public Information(int student_id, String name, String sex, String _class, String school, String phone_number, Date day_in) {
        this.student_id = student_id;
        this.name = name;
        this.sex = sex;
        this._class = _class;
        this.school = school;
        this.phone_number = phone_number;
        this.day_in = day_in;
    }

    public Information() {
    }
}
