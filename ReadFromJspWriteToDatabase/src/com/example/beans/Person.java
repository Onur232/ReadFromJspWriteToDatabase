package com.example.beans;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//id field'ýn getter setter yazýlmalý ve jsp'de comment out olan id kýsmý açýlmalý
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="phone")
	private int phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="country")
	private String country;
	
	@Column(name="password")
	private String password;
	
	
	public Person(String username, int phone, String address, String country, String password) {
		super();
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.country = country;
		this.password = password;
	}
	
	public Person() {
		
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", phone=" + phone + ", address=" + address
				+ ", country=" + country + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
