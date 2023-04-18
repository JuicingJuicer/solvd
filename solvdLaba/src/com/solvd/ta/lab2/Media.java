package com.solvd.ta.lab2;

import java.util.EnumSet;

// Base class for classes like books, movies, etc
public abstract class Media {
	protected String title;
	protected int year;
	protected EnumSet<Genre> genre;

	public Media(String title, int year, EnumSet<Genre> genre) {
		this.title = title;
		this.year = year;
		this.genre = genre;
	}

	public abstract String toString();
}
