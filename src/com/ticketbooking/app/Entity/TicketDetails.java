package com.ticketbooking.app.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String fName;
	private String lName;
	private String passport;
	private Date doj;
	
	
	public TicketDetails(String fName, String lName, String passport, Date doj) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.passport = passport;
		this.doj = doj;
	}
	
	public TicketDetails() {
		super();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "PassengerDetails [id=" + id + ", fName=" + fName + ", lName=" + lName + ", Passport=" + passport
				+ ", doj=" + doj + "]";
	}

}
