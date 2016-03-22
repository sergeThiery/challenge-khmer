package com.challenge.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYERS")
public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FirstName", nullable = false)
	private String firstName;
	
	@Id
	@Column(name = "LastName", nullable = false)
	private String lastName;
	
	@Column(name = "Address", nullable = true)
	private String address;
	
	@Column(name = "City", nullable = true)
	private String city;
	
	@Id
	@Column(name = "State", nullable = true)
	private String state;
	
	@Column(name = "Phone", nullable = false)
	private String phone;
	
	@Column(name = "Weight", nullable = true)
	private long weight;
	
	@Column(name = "Height", nullable = true)
	private long height;
	
	@Column(name = "Age", nullable = true)
	private int age;
	
	
	public Player(){
		
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public Player(String firstName, String lastName, String city){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = city;
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



}
