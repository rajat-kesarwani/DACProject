package com.app.pojos;


import java.util.Calendar;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class User {
	
//	create table User(
//		      Customer_Id INTEGER PRIMARY KEY auto_increment ,
//		      Name varchar(100),
//		      User_role varchar(100),
//		      Gender varchar(10),
//		      Contact varchar(20),
//		      City varchar(100),
//		      State varchar(40),
//		      Zip INTEGER(100),
//		      Email varchar(100),
//		      Password varchar(100),
//		      createdOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//		);
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customer_Id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 10)
	private String user_role;
	
	@Column(length = 10)
	private String gender;
	
	
	private Long contact;
	
	@Column(length = 30)
	private String city;
	
	@Column(length = 30)
	private String state;
	

	private Integer zip;
	
	@NotNull
	@Column(length = 30)
	private String email;
	
	@NotNull
	@Column(length = 20)
	private String password;
	
	@CreationTimestamp
	@Column(name="createdAt" ,nullable = false, updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd") //html 5 complaint date time format
	private Date createdAt;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer customer_Id, String name, String user_role, String gender, Long contact, String city,
			String state, Integer zip, String email, String password, Date createdAt) {
		super();
		this.customer_Id = customer_Id;
		this.name = name;
		this.user_role = user_role;
		this.gender = gender;
		this.contact = contact;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [customer_Id=" + customer_Id + ", name=" + name + ", user_role=" + user_role + ", gender=" + gender
				+ ", contact=" + contact + ", city=" + city + ", state=" + state + ", zip=" + zip + ", email=" + email
				+ ", password=" + password + ", createdAt=" + createdAt + "]";
	}

	public Integer getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(Integer customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
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

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
      	

}
