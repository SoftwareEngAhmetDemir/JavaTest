package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Dash")
public class DashBoard {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id;
	  private String Messsage;
	  private String FirstName;
	  private String LastName;
	  private String YourEmail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMesssage() {
		return Messsage;
	}
	public void setMesssage(String messsage) {
		Messsage = messsage;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getYourEmail() {
		return YourEmail;
	}
	public void setYourEmail(String yourEmail) {
		YourEmail = yourEmail;
	}
	  
}
