package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Set;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

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
	private Genre genre;
	private BorrowLength borrowLength;
	private Set<BookAuthorMapping> bookAuthorMappings;
	private Set<BookReservationMapping> bookReservationMappings;

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
	
	@ManyToOne
	@JoinColumn(name="GenreId", referencedColumnName="Id")
	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	@ManyToOne
	@JoinColumn(name="BorrowLengthId", referencedColumnName="Id")
	public BorrowLength getBorrowLength() {
		return this.borrowLength;
	}

	public void setBorrowLength(BorrowLength borrowLength) {
		this.borrowLength = borrowLength;
	}

	@OneToMany(mappedBy="book",cascade = CascadeType.ALL)
	public Set<BookAuthorMapping> getBookAuthorMappings() {
		return this.bookAuthorMappings;
	}

	public void setBookAuthorMappings(Set<BookAuthorMapping> bookAuthorMappings) {
		this.bookAuthorMappings = bookAuthorMappings;
	}

	@OneToMany(mappedBy="book",cascade = CascadeType.ALL)
	public Set<BookReservationMapping> getBookReservationMappings() {
		return this.bookReservationMappings;
	}

	public void setBookReservationMappings(Set<BookReservationMapping> bookReservationMappings) {
		this.bookReservationMappings = bookReservationMappings;
	}
}