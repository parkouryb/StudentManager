package Object;

import java.util.Date;

import javax.persistence.*;

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

    @OneToOne
    private Student student;


    public Contract() {

    }

    public Contract(String contract_ID, Date day_in, Date day_out) {
        Contract_ID = contract_ID;
        Day_in = day_in;
        Day_out = day_out;
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

}
