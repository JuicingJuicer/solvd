package com.solvd.ta.lab2.items;

import java.util.EnumSet;
import java.util.Objects;

import com.solvd.ta.lab2.Genre;

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
		return "Title: " + getTitle() + "\nAuthor: " + author + "\nPublished: " + year + "\nGenre(s): " + getGenre() + "\nPages: "
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
		return (getTitle().equals(b.getTitle()) && year == b.year && getGenre().equals(b.getGenre()) && author.equals(b.author)
				&& pages == b.pages && serialNumber == b.serialNumber);
	}

	@Override
	public int hashCode() {
		int hash = Objects.hash(getTitle(), author);
		hash = 31 * hash + year;
		hash = 31 * hash + pages;
		hash = 31 * hash + serialNumber;
		hash = 31 * hash + getGenre().hashCode();
		return hash;
	}
}
