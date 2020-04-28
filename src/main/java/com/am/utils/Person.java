package com.am.utils;

public class Person {
	/**
	 * CTR
	 */
	public Person() {
		super();
	}
	/**
	 * 
	 * fields
	 * 
	 */
	String firstName;
	String lastName;
	String city;
	String country;
	String email;
	int id;
	/**
	 * 
	 * Email
	 * return
	 * 
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * param email
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * First name
	 * return
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * param firstName
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	/**
	 * param lastName
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * City
	 * return
	 * 
	 */
	public String getCity() {
		return city;
	}
	/** 
	 * param city
	 * 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Country
	 * return
	 */
	public String getCountry() {
		return country;
	}
	/** 
	 * param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * To string override all fields
	 * return
	 */

	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", email='" + email + '\'' +
				", id=" + id +
				'}';
	}
}
