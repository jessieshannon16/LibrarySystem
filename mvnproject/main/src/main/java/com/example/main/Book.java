package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Isbn;
    private int GenreId;
    private int BorrowLengthId;
    private int Copies;
    private String Title;
    private String Blurb;

	public String getIsbn() {
		return this.Isbn;
	}

	public void setIsbn(String Isbn) {
		this.Isbn = Isbn;
	}

	public int getGenreId() {
		return this.GenreId;
	}

	public void setGenreId(int GenreId) {
		this.GenreId = GenreId;
	}

	public int getBorrowLengthId() {
		return this.BorrowLengthId;
	}

	public void setBorrowLengthId(int BorrowLengthId) {
		this.BorrowLengthId = BorrowLengthId;
	}

	public int getCopies() {
		return this.Copies;
	}

	public void setCopies(int Copies) {
		this.Copies = Copies;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getBlurb() {
		return this.Blurb;
	}

	public void setBlurb(String Blurb) {
		this.Blurb = Blurb;
	}
}