package Object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Parent")
public class Parent {
    @Id
    @Column(name = "student_id")
    private int student_id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "relationship")
    private String relationship;

    public Parent() {
    }

    public Parent(int student_id, String name, String phone_number, String relationship) {
        this.student_id = student_id;
        this.name = name;
        this.phone_number = phone_number;
        this.relationship = relationship;
    }

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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
