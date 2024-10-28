package com.example.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book implements Serializable{
    @Id
    private String BookIsbn;
    private int Copies;
    private String Title;
	@Column(length = 2000)
    private String Blurb;
	private String Img;

	@ManyToOne
	@JoinColumn(name="GenreId")
	private Genre genre;

	@ManyToOne
	@JoinColumn(name="BorrowLengthId")
	private BorrowLength borrowLength;

	@OneToMany(mappedBy="book")
	private List<BookAuthorMapping> bookAuthorMappings;

	@OneToMany(mappedBy="book")
	private List<BookReservationMapping> bookReservationMappings;

	public String getBookIsbn() {
		return this.BookIsbn;
	}

	public void setBookIsbn(String BookIsbn) {
		this.BookIsbn = BookIsbn;
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

	public String getImg() {
		return this.Img;
	}

	public void setImg(String Img) {
		this.Img = Img;
	}
	
	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre){
		this.genre = genre;
	}
	
	public BorrowLength getBorrowLength() {
		return this.borrowLength;
	}

	public void setBorrowLength(BorrowLength borrowLength){
		this.borrowLength = borrowLength;
	}

	public List<BookAuthorMapping> getBookAuthorMappings() {
		return this.bookAuthorMappings;
	}

	public List<BookReservationMapping> getBookReservationMappings() {
		return this.bookReservationMappings;
	}

	@Override
	public String toString(){
		return this.Title;
	}
}