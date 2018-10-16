package com.springapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="employeescomp")
@EntityListeners(AuditingEntityListener.class)
public class Developer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="expertise")
	@NotBlank
	private String expertise;
	
	@Column(name="fullname")
	@NotBlank
	private String fullname;
	
	@Column(name="age")
	private int age;
	
	@Column(name="city")
	@NotBlank
	private String city;
	
	public Developer() {}
	
	public Developer(Long id, @NotBlank String expertise, @NotBlank String fullname, @NotBlank int age,
			@NotBlank String city) {
		this.id = id;
		this.expertise = expertise;
		this.fullname = fullname;
		this.age = age;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
