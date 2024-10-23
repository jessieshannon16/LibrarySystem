package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Set;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.io.*;

@Entity
public class Author implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String FirstName;
    private String LastName;
	private Set<BookAuthorMapping> bookAuthorMappings;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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

	@OneToMany(mappedBy="author",cascade = CascadeType.ALL)
	public Set<BookAuthorMapping> getBookAuthorMappings() {
		return this.bookAuthorMappings;
	}

	public void setBookAuthorMappings(Set<BookAuthorMapping> bookAuthorMappings) {
		this.bookAuthorMappings = bookAuthorMappings;
	}
}