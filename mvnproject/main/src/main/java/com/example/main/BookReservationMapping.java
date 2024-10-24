package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.io.*;

@Entity
public class BookReservationMapping implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int ReservationId;
    private String Isbn;
    private LocalDateTime ReturnDate;
    private boolean IsReturned;
	private Book book;
	private Reservations reservations;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getReservationId() {
		return this.ReservationId;
	}

	public void setReservationId(int ReservationId) {
		this.ReservationId = ReservationId;
	}

	public String getIsbn() {
		return this.Isbn;
	}

	public void setIsbn(String Isbn) {
		this.Isbn = Isbn;
	}

	public LocalDateTime getReturnDate() {
		return this.ReturnDate;
	}

	public void setReturnDate(LocalDateTime ReturnDate) {
		this.ReturnDate = ReturnDate;
	}

	public boolean isIsReturned() {
		return this.IsReturned;
	}

	public void setIsReturned(boolean IsReturned) {
		this.IsReturned = IsReturned;
	}

	@ManyToOne
	@JoinColumn(name="Isbn")
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne
	@JoinColumn(name="ReservationId", referencedColumnName="Id")
	public Reservations getReservations() {
		return this.reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}
}