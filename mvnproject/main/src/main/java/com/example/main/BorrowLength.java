package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BorrowLength{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int MaxLength;
	private Set<Book> books;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}
    
    public int getMaxLength() {
		return this.MaxLength;
	}

	public void setMaxLength(int MaxLength) {
		this.MaxLength = MaxLength;
	}

	@OneToMany(mappedBy="borrowLength",cascade = CascadeType.ALL)
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}