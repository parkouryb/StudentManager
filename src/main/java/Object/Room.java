package Object;

import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;
import java.util.*;
import java.io.*;


@Entity
@Table(name="Room")
public class Room {
    @Id
    @Column(name = "Room_ID")
    private String Room_ID;
    @Column(name = "Type_room")
    private int Type_room;
    @Column(name = "Room_money")
    private float Room_money;

//    @OneToMany
//    private List<Student> students = new ArrayList<Student>();
//
//    @ManyToOne
//    private Dormitory dorm;

    public Room() {
    }

    public Room(String room_ID, int type_room, float room_money) {
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

    public int getType_room() {
        return Type_room;
    }

    public void setType_room(int type_room) {
        Type_room = type_room;
    }

    public float getRoom_money() {
        return Room_money;
    }

    public void setRoom_money(float room_money) {
        Room_money = room_money;
    }
}
