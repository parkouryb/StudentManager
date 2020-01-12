package Object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

//    @OneToOne
//    private Student student;


    public Contract() {

    }
    
    public Contract(String demo) {
    	Contract_ID = demo;
    	try {
			Day_in = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
			Day_out = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/9999");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public String toString() {
		return "Contract [Contract_ID=" + Contract_ID + ", Day_in=" + Day_in + ", Day_out=" + Day_out + "]";
	}
    
}
