package com.springdata.studentroster.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Students")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, message = "Name has to be longer than 2 character")
	private String first_name;

	@Size(min = 2, message = "Name has to be longer than 2 characters and shorter than 20")
	private String last_name;

	@NotNull
	private Integer age;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createdAt;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date updatedAt;
	
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Contact contact;

	public Student() {}

	public Student( String first_name, String last_name, Integer age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
