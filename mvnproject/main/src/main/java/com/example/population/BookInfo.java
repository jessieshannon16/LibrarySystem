package com.example.population;

import java.util.List;

public class BookInfo{
    private String title;
    private String subtitle;
    private List<String> authors;
	private String publisher;
    private String description;
    private int pageCount;
    private List<String> categories;
    private List<Isbn> industryIdentifiers;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public List<String> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<String> getCategories() {
		return this.categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<Isbn> getIndustryIdentifiers() {
		return this.industryIdentifiers;
	}

	public void setIndustryIdentifiers(List<Isbn> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
	}

	public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}