package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private LocalDateTime LastLogin;
    private boolean IsActive;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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
}   