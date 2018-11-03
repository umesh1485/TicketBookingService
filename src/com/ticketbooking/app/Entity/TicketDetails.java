package com.ticketbooking.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "ticketDetails")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class TicketDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long id;

	@NotNull
	@Size(min = 1)
	@XmlElement(required = true)
	private String firstName;

	@NotNull
	@Size(min = 1)
	@XmlElement(required = true)
	private String lastName;

	@NotNull
	@Size(min = 1, max = 20)
	@XmlElement(required = true)
	private String passport;

	@NotNull
	@Temporal(TemporalType.DATE)
	@XmlElement(required = true)
	private Date doj;

	public TicketDetails(String firstName, String lastName, String passport, Date doj) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.passport = passport;
		this.doj = doj;
	}

	public TicketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "TicketDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passport="
				+ passport + ", doj=" + doj + "]";
	}
}
