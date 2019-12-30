package Object;

import java.util.Date;

import javax.persistence.*;
import java.util.*;
import java.io.*;


@Entity
@Table(name="Contract")
public class Contract {
    @Id
    @Column(name="Contract_ID")
    private String Contract_ID;

    @Column(name = "Day_in")
    private Date Day_in;
    @Column(name = "Day_out")
    private Date Day_out = null;
    @Column(name = "creation_date")
    private Date creation_date;

//    @OneToOne
//    private Student student;


    public Contract() {

    }

    public Contract(String contract_ID, Date day_in, Date day_out, Date creation_date) {
        Contract_ID = contract_ID;
        Day_in = day_in;
        Day_out = day_out;
        this.creation_date = creation_date;
    }

    public String getContract_ID() {
        return Contract_ID;
    }

    public void setContract_ID(String contract_ID) {
        Contract_ID = contract_ID;
    }

    public Date getDay_in() {
        return Day_in;
    }

    public void setDay_in(Date day_in) {
        Day_in = day_in;
    }

    public Date getDay_out() {
        return Day_out;
    }

    public void setDay_out(Date day_out) {
        Day_out = day_out;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
