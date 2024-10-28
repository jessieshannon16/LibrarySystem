package com.example.population;

import java.io.Serializable;

public class Images implements Serializable{
    private String smallThumbnail;
    private String thumbnail;

	public String getSmallThumbnail() {
		return this.smallThumbnail;
	}

	public void setSmallThumbnail(String smallThumbnail) {
		this.smallThumbnail = smallThumbnail;
	}

	public String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}