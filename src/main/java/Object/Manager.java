package Object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
public class Manager {
    @Id
    @Column(name = "manager_id")
    private int manager_id;

    @Column(name = "name")
    private String name;

    @Column(name = "building")
    private String building;

    public Manager() {

    }

    public Manager(int manager_id, String name, String building) {
        this.manager_id = manager_id;
        this.name = name;
        this.building = building;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
