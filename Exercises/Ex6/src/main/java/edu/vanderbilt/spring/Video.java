package edu.vanderbilt.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long size;
	private String genre;
	private String url;

	public Long getId() {
	return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

	public void setName(String name){
	this.name = name;
	}

	public String getName(){
	return name;
	}

	public void setSize(Long size) {
	this.size= size;
	}

	public Long getSize(){
	return size;
	}

	public void setGenre(String genre){
	this.genre = genre;
	}

	public String getGenre(){
	return genre;
	}

	public void setURL(String url){
	this.url = url;
	}

	public String getURL(){
	return url;
	}

}
