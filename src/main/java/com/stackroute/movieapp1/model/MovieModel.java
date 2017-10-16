package com.stackroute.movieapp1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection="hackathon2")
public class MovieModel {
	@Id
	@NotNull
	private String id;
	
	private String username;
	private String emailid;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MovieModel(String id,String username,String emailid) {
		super();
		this.id=id;
		this.username = username;
		this.emailid = emailid;
		
	}
	public MovieModel() {
		
	}
}

//	private String Description;
//	public String getMovieID() {
//		return id;
//	}
//	public void setMovieID(String movieID) {
//		id = movieID;
	