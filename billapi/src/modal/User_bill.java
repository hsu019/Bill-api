package modal;

import java.util.Date;

public class User_bill {

     private String Date;
     private String bill_type;
    private float bill_amount;
 
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	 
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	public float getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}
    

}