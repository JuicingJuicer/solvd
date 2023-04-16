package com.solvd.ta.lab2;

import java.util.EnumSet;

// Base class for classes like books, movies, etc
public class Media {
	private String title;
	private int year;
	private EnumSet<Genre> genre;

	public Media(String title, int year, EnumSet<Genre> genre) {
		this.title = title;
		this.year = year;
		this.genre = genre;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setGenre(EnumSet<Genre> genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return this.title;
	}

	public int getYear() {
		return this.year;
	}

	public EnumSet<Genre> getGenre() {
		return this.genre;
	}
}
