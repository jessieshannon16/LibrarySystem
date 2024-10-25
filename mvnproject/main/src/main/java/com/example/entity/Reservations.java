package com.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Reservations implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ReservationId;
    private LocalDateTime TakeDate;

	
	@ManyToOne
	@JoinColumn(name="UserId")
    private Users user;

	@OneToMany(mappedBy="reservations")
	private List<BookReservationMapping> bookReservationMappings;

	public int getReservationId() {
		return this.ReservationId;
	}

	public void setReservationId(int ReservationId) {
		this.ReservationId = ReservationId;
	}

	public LocalDateTime getTakeDate() {
		return this.TakeDate;
	}

	public void setTakeDate(LocalDateTime TakeDate) {
		this.TakeDate = TakeDate;
	}

	public Users getUser() {
		return this.user;
	}

	
	public List<BookReservationMapping> getBookReservationMappings() {
		return this.bookReservationMappings;
	}

}