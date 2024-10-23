package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Reservations{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int UserId;
    private LocalDateTime TakeDate;
    private Users user;
	private Set<BookReservationMapping> bookReservationMappings;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getUserId() {
		return this.UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	public LocalDateTime getTakeDate() {
		return this.TakeDate;
	}

	public void setTakeDate(LocalDateTime TakeDate) {
		this.TakeDate = TakeDate;
	}

	@ManyToOne
	@JoinColumn(name="UserId", referencedColumnName="Id")
	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@OneToMany(mappedBy="reservations",cascade = CascadeType.ALL)
	public Set<BookReservationMapping> getBookReservationMappings() {
		return this.bookReservationMappings;
	}

	public void setBookReservationMappings(Set<BookReservationMapping> bookReservationMappings) {
		this.bookReservationMappings = bookReservationMappings;
	}
}