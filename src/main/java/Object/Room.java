package Object;

import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Room")
public class Room {
    @Id
    @Column(name = "Room_ID")
    private String Room_ID;
    @Column(name = "Type_room")
    private String Type_room;
    @Column(name = "Room_money")
    private float Room_money;
    @Column(name = "Number")
    private int Number;

//    @OneToMany
//    private List<Student> students = new ArrayList<Student>();
//
//    @ManyToOne
//    private Dormitory dorm;

    public Room() {
    }

    public Room(String room_ID, String type_room, float room_money) {
        Room_ID = room_ID;
        Type_room = type_room;
        Room_money = room_money;
    }

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String room_ID) {
        Room_ID = room_ID;
    }

    public String getType_room() {
        return Type_room;
    }

    public void setType_room(String type_room) {
        Type_room = type_room;
    }

    public float getRoom_money() {
        return Room_money;
    }

    public void setRoom_money(float room_money) {
        Room_money = room_money;
    }
    
    public int getNumber() {
		return Number;
	}
    
    public void setNumber(int number) {
		Number = number;
	}
}
