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
    private int UserID;
    private String UserName;
    private String Email;
    private String PasswordHash;
    private LocalDateTime CreatedAt;

    public int getUserID(){
        return UserID;
    }

    public void setUserID(int UserID){
        this.UserID = UserID;
    }

    public String getUserName(){
        return UserName;
    }

    public void setUserName(String UserName){
        this.UserName = UserName;
    }

    public String getEmail(){
        return Email;
    }

    public void setUserID(String Email){
        this.Email = Email;
    }

    public String getPasswordHash(){
        return PasswordHash;
    }

    public void setPasswordHash(String getPasswordHash){
        this.PasswordHash = PasswordHash;
    }

    public LocalDateTime getCreatedAt(){
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime CreatedAt){
        this.CreatedAt = CreatedAt;
    }

}   