package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookAuthorMapping implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BAMId;

	@ManyToOne
	@JoinColumn(name="AuthorId")
	private Author author;

	@ManyToOne()
	@JoinColumn(name="BookIsbn")
	private Book book;

	@ManyToOne
	@JoinColumn(name="ContributionLevelId")
	private ContributionLevel contributionLevel;

	public int getBAMId() {
		return this.BAMId;
	}

	public void setBAMId(int BAMId) {
		this.BAMId = BAMId;
	}
	
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author){
		this.author = author;
	}
	
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book){
		this.book = book;
	}

	public ContributionLevel getContributionLevel() {
		return this.contributionLevel;
	}

	public void setContributionLevel(ContributionLevel contributionLevel){
		this.contributionLevel = contributionLevel;
	}
}