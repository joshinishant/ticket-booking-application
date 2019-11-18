package com.sap.mdm.prd.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TICKET")
public class TicketBookingEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String Id;
	
	@Column(name="NUMBER")
	private String number;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastanme;
	
	@Column(name="MIDDLENAME")
	private String middleName;
	
	public String getId(){
		return Id;
	}
	public void setId(String Id) {
		this.Id=Id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastanme() {
		return lastanme;
	}
	public void setLastanme(String lastanme) {
		this.lastanme = lastanme;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketBookingEntity other = (TicketBookingEntity) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	public TicketBookingEntity() {
		super();
	}
	public TicketBookingEntity(String id, String number, String firstName, String lastanme, String middleName) {
		super();
		Id = id;
		this.number = number;
		this.firstName = firstName;
		this.lastanme = lastanme;
		this.middleName = middleName;
	}
	@Override
	public String toString() {
		return "TicketBookingEntity [Id=" + Id + ", number=" + number + ", firstName=" + firstName + ", lastanme="
				+ lastanme + ", middleName=" + middleName + "]";
	}
}
