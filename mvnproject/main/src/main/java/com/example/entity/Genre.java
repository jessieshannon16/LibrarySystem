package com.example.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GenreId;
    private String Name;

	@OneToMany(mappedBy="genre")
	private List<Book> books;

	public int getGenreId() {
		return this.GenreId;
	}

	public void setGenreId(int GenreId) {
		this.GenreId = GenreId;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	
	public List<Book> getBooks() {
		return this.books;
	}

	@Override
	public String toString(){
		return this.Name;
	}
}