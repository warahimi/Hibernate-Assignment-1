package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Mappig Student class/entity to student table 
@Entity
@Table(name = "student")
public class Student {
	//Creating variables/fields and mapping them to table columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	//Creating COnstructors
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String major, String college, String country, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.college = college;
		this.country = country;
		this.city = city;
	}

	
	//Creating Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//toString method to print the object
	@Override
	public String toString() {
		return "Student ID: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nMajor: " + major
				+ "\nCollege: " + college + "\nCountry: " + country + "\nCity: " + city;
	}
	
	

	
	





	
	

}
