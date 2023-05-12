package com.solvd.ta.lab2.items;

import java.util.EnumSet;
import java.util.Objects;

import com.solvd.ta.lab2.enums.Genre;

public class Movie extends Media {
	private String director;
	private int runtime;
	private double rating;

	public Movie(String title, int year, EnumSet<Genre> genre, String director, int runtime, double rating) {
		super(title, year, genre);
		this.director = director;
		this.runtime = runtime;
		this.rating = rating;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDirecttor() {
		return this.director;
	}

	public int getRuntime() {
		return this.runtime;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Title: " + getTitle() + "\nDirector: " + director + "\nYear Released: " + year + "\nGenre: " + getGenre()
				+ "\nRuntime: " + runtime + " minutes" + "\nIMDb Rating: " + rating + "\nSerial Number: "
				+ serialNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (null == o) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		Movie m = (Movie) o;
		return (getTitle().equals(m.getTitle()) && year == m.year && getGenre().equals(m.getGenre()) && director.equals(m.director)
				&& runtime == m.runtime && rating == m.rating && serialNumber == m.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(getTitle(), director);
		hash = 31 * hash + year;
		hash = 31 * hash + runtime;
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + Double.hashCode(rating);
		hash = 31 * hash + getGenre().hashCode();
		return hash;
	}
}
