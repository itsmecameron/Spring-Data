package com.springdata.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name="languages")

	public class Language {
		//id will be auto generated
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		//size of our language
	    @Size(min = 2, max = 20)
	    private String name;
	    
	    //size of our creator
	    @Size(min = 2, max = 20)
	    private String creator;
	    
	    //Version cannot be empty
	    @Min(1)
	    private double version;
	    
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="dd-MM-yyyy")
	    private Date createdAt;
	    @DateTimeFormat(pattern="dd-MM-yyyy")
	    private Date updatedAt;
	    
	    //empty function
	    
	    public Language() {
	    }
	    
	    public Language(String name, String creator, double version) {
	        this.name = name;
	        this.creator = creator;
	        this.version = version;
	    }

	    // generate getters and setters
	    
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

		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}

		public @Min(1) double getVersion() {
			return version;
		}

		public void setVersion(double version) {
			this.version = version;
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
