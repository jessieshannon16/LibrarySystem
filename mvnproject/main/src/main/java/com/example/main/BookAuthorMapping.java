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
    private int AuthorId;
    private String BookIsbn;
    private int ContributionLevelId;
	private Author author;
	private Book book;
	private ContributionLevel contributionLevel;

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getAuthorId() {
		return this.AuthorId;
	}

	public void setAuthorId(int AuthorId) {
		this.AuthorId = AuthorId;
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

	@ManyToOne
	@JoinColumn(name="AuthorId", referencedColumnName="Id")
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
	@JoinColumn(name="ContributionLevelId", referencedColumnName="Id")
	public ContributionLevel getContributionLevel() {
		return this.contributionLevel;
	}

	public void setContributionLevel(ContributionLevel contributionLevel) {
		this.contributionLevel = contributionLevel;
	}

}