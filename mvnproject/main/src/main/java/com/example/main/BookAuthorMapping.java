package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BookAuthorMapping{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int ReservationId;
    private String BookIsbn;
    private int ContributionLevelId;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getReservatinId() {
		return this.ReservatinId;
	}

	public void setReservatinId(int ReservatinId) {
		this.ReservatinId = ReservatinId;
	}

	public String getBookIsbn() {
		return this.BookIsbn;
	}

	public void setBookIsbn(String BookIsbn) {
		this.BookIsbn = BookIsbn;
	}

	public int getContributionLevelId() {
		return this.ContributionLevelId;
	}

	public void setContributionLevelId(int ContributionLevelId) {
		this.ContributionLevelId = ContributionLevelId;
	}
}