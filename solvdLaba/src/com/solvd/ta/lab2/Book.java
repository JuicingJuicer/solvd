package com.solvd.ta.lab2;

import java.util.EnumSet;

public class Book extends Media {
	protected String author;
	protected int pages;

	public Book(String title, int year, EnumSet<Genre> genre, String author, int pages) {
		super(title, year, genre);
		this.author = author;
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nPublished: " + year + "\nGenre(s): " + genre + "\nPages: "
				+ pages;
	}

	public static void main(String[] args) {
		Book dune = new Book("Dune", 1965, EnumSet.of(Genre.SCIFI, Genre.FANTASY), "Frank Herbert", 896);
		System.out.println(dune);
	}
}
