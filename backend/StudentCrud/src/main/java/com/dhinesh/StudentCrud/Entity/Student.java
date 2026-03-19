package com.dhinesh.StudentCrud.Entity;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long id;
	
	private String name;
	private String email;
	private String dept;
//	@JsonFormat(pattern="dd-MM-yyyy")
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	
	public Student() {
		
	}
	
	public Student(Long id, String name, String email, String dept, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;  
		this.email = email;
		this.dept = dept;
		this.dob = dob;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	

}
