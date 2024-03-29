package com.springdata.studentroster.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Contacts")

public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, message = "Address has to be longer than 2 character")
	private String address;
	
	@Size(min = 2, message = "City has to be longer than 2 character")
	private String city;
	
	@NotNull
	private String state;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createdAt;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date updatedAt;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;
	
    public Contact() {}
    
	
	public Contact(String address, String city, String state, Student student) {
		
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
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



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	// right before object is created, save the date that the object is created at
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    //on every update, save the date that the object is updated at
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
