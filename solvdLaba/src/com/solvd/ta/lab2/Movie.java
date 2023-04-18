package com.solvd.ta.lab2;

import java.util.EnumSet;

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
		return "Title: " + this.title + "\nDirector: " + this.director + "\nYear Released: " + this.year + "\nGenre: "
				+ this.genre + "\nRuntime: " + this.runtime + " minutes" + "\nIMDb Rating: " + this.rating;
	}

	public static void main(String[] args) {
		Movie batman = new Movie("The Dark Knight", 2008, EnumSet.of(Genre.ACTION, Genre.THRILLER), "Christopher Nolan",
				152, 9.0);
		System.out.println(batman);
	}
}
