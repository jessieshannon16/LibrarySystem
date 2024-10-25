package com.example.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class BorrowLength implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BorrowLengthId;
    private int MaxLength;

	@OneToMany(mappedBy="borrowLength")
	private List<Book> books;

	public int getBorrowLengthId() {
		return this.BorrowLengthId;
	}

	public void setBorrowLengthId(int BorrowLengthId) {
		this.BorrowLengthId = BorrowLengthId;
	}
    
    public int getMaxLength() {
		return this.MaxLength;
	}

	public void setMaxLength(int MaxLength) {
		this.MaxLength = MaxLength;
	}

	
	public List<Book> getBooks() {
		return this.books;
	}
}