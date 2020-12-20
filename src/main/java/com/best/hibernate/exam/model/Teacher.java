package com.best.hibernate.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getEducationDesc() {
		return educationDesc;
	}
	public void setEducationDesc(String educationDesc) {
		this.educationDesc = educationDesc;
	}
	private String name;
	private String email;
	private String nrc;
	private String educationDesc;
	@ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private Department department=new Department();
	public Teacher() {
		super();
	}
	public Teacher(Long id, String name, String email, String nrc, String educationDesc) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.nrc = nrc;
		this.educationDesc = educationDesc;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
