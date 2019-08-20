package com.springdata.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Songs")

public class Song {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//size of our title
    @Size(min = 2, max = 20, message="Title has to be longer than 2 characters and shorter than 20\"")
    private String title;
    
    //size of our artist
    @Size(min = 2, max = 20, message="Artist name has to be longer than 2 characters and shorter than 20")
    private String artist;
    
    @NotNull 
    private Integer rating;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date createdAt;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date updatedAt;
	
    public Song() {}

	public Song(String title, String artist, Integer rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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
