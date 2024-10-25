package com.example.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable=false,updatable=false)
    private int UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private LocalDateTime LastLogin;
    private boolean IsActive;

	@OneToMany(mappedBy="user")
	private List<Reservations> reservations;

	public int getUserId() {
		return this.UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public LocalDateTime getLastLogin() {
		return this.LastLogin;
	}

	public void setLastLogin(LocalDateTime LastLogin) {
		this.LastLogin = LastLogin;
	}

	public boolean isIsActive() {
		return this.IsActive;
	}

	public void setIsActive(boolean IsActive) {
		this.IsActive = IsActive;
	}

	
	public List<Reservations> getReservations() {
		return this.reservations;
	}
}   