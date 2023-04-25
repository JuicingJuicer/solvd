package com.solvd.ta.lab2;

import java.util.EnumSet;
import java.util.Objects;

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
				+ pages + "\nSerial Number: " + serialNumber;
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

		Book b = (Book) o;
		return (title.equals(b.title) && year == b.year && genre.equals(b.genre) && author.equals(b.author)
				&& pages == b.pages && serialNumber == b.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(title, author);
		hash = 31 * hash + year;
		hash = 31 * hash + pages;
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + genre.hashCode();
		return hash;
	}
}
