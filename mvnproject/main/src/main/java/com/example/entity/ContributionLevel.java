package com.example.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ContributionLevel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ContributionLevelId;
    private String Level;

	@OneToMany(mappedBy="contributionLevel")
	private List<BookAuthorMapping> bookAuthorMappings;
	

	public int getContributionLevelId() {
		return this.ContributionLevelId;
	}

	public void setContributionLevelId(int ContributionLevelId) {
		this.ContributionLevelId = ContributionLevelId;
	}

	public String getLevel() {
		return this.Level;
	}

	public void setLevel(String Level) {
		this.Level = Level;
	}

	
	public List<BookAuthorMapping> getBookAuthorMappings() {
		return this.bookAuthorMappings;
	}
}