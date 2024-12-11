package com.klef.jfsd.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty_table")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullname;
    private String password;
    private String email;
    private String phonenumber;
    private String department;
    private int age;
    private String gender;
    private int salaray;
    private String address;
    private LocalDate joiningdate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalaray() {
		return salaray;
	}
	public void setSalaray(int salaray) {
		this.salaray = salaray;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(LocalDate joiningdate) {
		this.joiningdate = joiningdate;
	}
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", username=" + username + ", fullname=" + fullname + ", password=" + password
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", department=" + department + ", age=" + age
				+ ", gender=" + gender + ", salaray=" + salaray + ", address=" + address + ", joiningdate="
				+ joiningdate + "]";
	}

}
