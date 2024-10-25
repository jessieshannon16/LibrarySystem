package com.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable=false,updatable=false)
    private int AuthorId;
    private String FirstName;
    private String LastName;

	@OneToMany(mappedBy="author")
	private Set<BookAuthorMapping> bookAuthorMappings = new HashSet<>();

	public int getAuthorId() {
		return this.AuthorId;
	}

	public void setAuthorId(int AuthorId) {
		this.AuthorId = AuthorId;
	}

	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Set<BookAuthorMapping> getBookAuthorMappings() {
		return this.bookAuthorMappings;
	}

	public void setBookAuthorMappings(Set<BookAuthorMapping> bookAuthorMappings){
		this.bookAuthorMappings = bookAuthorMappings;
	}

	@Override
	public String toString(){
		return this.FirstName + " " + this.LastName;
	}
}