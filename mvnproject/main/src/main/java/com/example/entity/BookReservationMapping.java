package com.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookReservationMapping implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BRMId;
    private LocalDateTime ReturnDate;
    private boolean IsReturned;

	@ManyToOne
	@JoinColumn(name="BookIsbn")
	private Book book;

	@ManyToOne
	@JoinColumn(name="ReservationId")
	private Reservations reservations;

	public int getBRMId() {
		return this.BRMId;
	}

	public void setBRMId(int BRMId) {
		this.BRMId = BRMId;
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

	public Book getBook() {
		return this.book;
	}

	public Reservations getReservations() {
		return this.reservations;
	}
}